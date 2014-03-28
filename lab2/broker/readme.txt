Brian Fruin

Java

Lab 2 - Broker Pattern

This program implements a simple version of the broker pattern.  The user is asked whether they want to add two integers or get the length of a string.  The corresponding arguments are asked for.  The method name and arguments are boxed up into a standard CallMessage object by the client proxy and sent to the broker.  The broker converts the CallMessage into a standard string format which is sent through a transport layer to the next broker.  This broker converts the String back to a CallMessage which is sent to a ServerProxy and finally to a Server which calls the appropriate method on one of its servant objects.  The result is sent back to the client in a similar manner in the reverse order.  All of the classes are well commented.