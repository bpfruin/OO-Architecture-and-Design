package broker;

//This is the CallMessage.  It has fields for the arguments for both methods, add and length
//as well as a field for the result when it is returned.  There are setters and getters for
//all the fields as they are all used.

public class CallMessage {

	String method;
	String message;
	int num1;
	int num2;
	int result;
	
	public CallMessage(){	
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
}
