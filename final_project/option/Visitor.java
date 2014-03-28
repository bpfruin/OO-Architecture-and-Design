package option;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.exp;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.text.DecimalFormat;

//these formulae came from http://dhruba.name/2012/09/01/the-black-scholes-algorithm-the-greeks-in-java/

public class Visitor {
	
	private static final double P = 0.2316419;
    private static final double B1 = 0.319381530;
    private static final double B2 = -0.356563782;
    private static final double B3 = 1.781477937;
    private static final double B4 = -1.821255978;
    private static final double B5 = 1.330274429;
	
	DecimalFormat df = new DecimalFormat("#.##");
	
	public Visitor(){
		
	}
	
	//The PutOption visit method calculates the price and Greeks of the option and sets all the approprite fields of the PutOption object.
	//The execution is rather simple, it just calculates a bunch of formulas in sequence.
	public void visit(PutOption putOption){		
		double d1 = d1(putOption.getStockLastTraded(), putOption.getStrikePrice(), putOption.getRiskFreeRate(), putOption.getTimeTilExpiry(), putOption.getVolatility());
        double d2 = d2(putOption.getStockLastTraded(), putOption.getStrikePrice(), putOption.getRiskFreeRate(), putOption.getTimeTilExpiry(), putOption.getVolatility());
        double sd1 = standardNormalDistribution(d1);
        double cd1 = cumulativeDistribution(d1, sd1);
        double thetaLeft = -(putOption.getStockLastTraded() * sd1 * putOption.getVolatility()) / (2 * sqrt(putOption.getTimeTilExpiry()));
        
        double pcd1 = cumulativeDistribution(-d1);
        double pcd2 = cumulativeDistribution(-d2);
        // price
        putOption.setPrice(putOption.getStrikePrice() * exp(-putOption.getRiskFreeRate() * putOption.getTimeTilExpiry()) * pcd2 - putOption.getStockLastTraded() * pcd1);
        // delta
        putOption.setDelta(cd1 - 1);
        // theta
        double thetaRight = putOption.getRiskFreeRate() * putOption.getStrikePrice() * exp(-putOption.getRiskFreeRate() * putOption.getTimeTilExpiry()) * pcd2;
        putOption.setTheta(thetaLeft + thetaRight);
        // rho
        putOption.setRho(-putOption.getStrikePrice() * putOption.getTimeTilExpiry() * exp(-putOption.getRiskFreeRate() * putOption.getTimeTilExpiry()) * pcd2);
        // gamma
        putOption.setGamma(sd1 / (putOption.getStockLastTraded() * putOption.getVolatility() * sqrt(putOption.getTimeTilExpiry())));
        // vega
        putOption.setVega(putOption.getStockLastTraded() * sd1 * sqrt(putOption.getTimeTilExpiry()));
	}
	
	//The CallOption visit method calculates the price and Greeks of the option and sets all the approprite fields of the CallOption object.
	//These formulae are slightly different than the PutOption formulae.
	public void visit(CallOption callOption){	
		double d1 = d1(callOption.getStockLastTraded(), callOption.getStrikePrice(), callOption.getRiskFreeRate(), callOption.getTimeTilExpiry(), callOption.getVolatility());
        double d2 = d2(callOption.getStockLastTraded(), callOption.getStrikePrice(), callOption.getRiskFreeRate(), callOption.getTimeTilExpiry(), callOption.getVolatility());
        double sd1 = standardNormalDistribution(d1);
        double cd1 = cumulativeDistribution(d1, sd1);
        double thetaLeft = -(callOption.getStockLastTraded() * sd1 * callOption.getVolatility()) / (2 * sqrt(callOption.getTimeTilExpiry()));
		
        double cd2 = cumulativeDistribution(d2);
        // price
        callOption.setPrice(callOption.getStockLastTraded() * cd1 - callOption.getStrikePrice() * exp(-callOption.getRiskFreeRate() * callOption.getTimeTilExpiry()) * cd2);
        // delta
        callOption.setDelta(cd1);
        // theta
        double thetaRight = callOption.getRiskFreeRate() * callOption.getStrikePrice() * exp(-callOption.getRiskFreeRate() * callOption.getTimeTilExpiry()) * cd2;
        callOption.setTheta(thetaLeft - thetaRight);
        // rho
        callOption.setRho(callOption.getStrikePrice() * callOption.getTimeTilExpiry() * exp(-callOption.getRiskFreeRate() * callOption.getTimeTilExpiry()) * cd2);
        // gamma
        callOption.setGamma(sd1 / (callOption.getStockLastTraded() * callOption.getVolatility() * sqrt(callOption.getTimeTilExpiry())));
        // vega
        callOption.setVega(callOption.getStockLastTraded() * sd1 * sqrt(callOption.getTimeTilExpiry()));
	}
	
	//The stock visit simply sets the price as the lastTraded(the value of a stock, obviously) and sets the
	//delta to 1, and all the other greeks to 0.  This is true for any stock under any conditions.
	public void visit(Stock stock){
		stock.setPrice(stock.getStockLastTraded());
		stock.setDelta(1);
		stock.setGamma(0);
		stock.setTheta(0);
		stock.setVega(0);
		stock.setRho(0);		
	}
	
	
	//Not my code.  Obtained from the Internet.
	//These formulae calculate values needed for the option valuation/greek formulae.
	private static double d1(double s, double k, double r, double t, double v) {
        double top = log(s / k) + (r + pow(v, 2) / 2) * t;
        double bottom = v * sqrt(t);
        return top / bottom;
    }
    
    private static double d2(double s, double k, double r, double t, double v) {
        return d1(s, k, r, t, v) - v * sqrt(t);
    }

    public static double cumulativeDistribution(double x) {
        return cumulativeDistribution(x, standardNormalDistribution(x));
    }
    
    public static double cumulativeDistribution(double x, double sdx) {
        double t = 1 / (1 + P * abs(x));
        double t1 = B1 * pow(t, 1);
        double t2 = B2 * pow(t, 2);
        double t3 = B3 * pow(t, 3);
        double t4 = B4 * pow(t, 4);
        double t5 = B5 * pow(t, 5);
        double b = t1 + t2 + t3 + t4 + t5;
        double cd = 1 - sdx * b;
        return x < 0 ? 1 - cd : cd;
    }

    public static double standardNormalDistribution(double x) {
        double top = exp(-0.5 * pow(x, 2));
        double bottom = sqrt(2 * PI);
        return top / bottom;
    }
}
