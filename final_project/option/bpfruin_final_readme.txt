Brian Fruin

Final Project

Language Used: Java

***There are 2 main methods.  One in "Main", which has the console UI, and another one in "Tester", which executes a small test program.

Architectural Pattern Used: Layers

1)Data layer - Portfolio, Option, CallOption, PutOption, Stock, Security, SecuritiesIterator
2)Computation layer - Controller, Strategy, Visitable, Visitor
3)UI layer - Main, Tester

Design Patterns Used: Singleton, Visitor, Iterator, Strategy

This application keeps track of a trader's options position.  The user can enter buy or sell trades or put options, call options, and shares of stock.  The user can also update the last traded stock price, volatility, and risk free rate of all securities in his/her position.

The classes and methods are heavily commented in the source files