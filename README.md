# Iterative_Socket_Server
Single thread server : multithread client

//rough draft of the report
** add a title page to the actual report** 
Title page : 
Assignment name: Iterative Socket Server
Authors: Brett Knox, Gary li
Class: CNT4504 - Computer Networks & Distributed Processing
Professor name: 	Scott Kelly

Introduction: 
Purpose of the project: to create a single threaded server that connects to a multithreaded client & impliments the desired method requested by the client, the number of times the client requested it to be done.
The goals of this project were:
-create a single thread server that listens so a specific port, intakes input from a client for selecting a service (date & time, uptime, memory used, Netstat, current users, or running processes) and sends them the information they wanted.

-create a multithreaded client server that takes a users input for the port it needs to interact with, displays a menu of options to select from, asks for how many iterations of the request they want to complete ( that will become the number of threads created to impliment the specified request). This client server should also keep track of the total amount of time spent in each thread then sum them at the end for the total time spend by all the threads. 

how it was tested : we still need to run it to test it, but i assume we'll describe the total runtime / errors we might get when making the # of threads large whenever we do it. 
data to collect: total runtime, number of threads, operation performed, ratio of time per thread per operation

Data analysis: (we need to impliment them to answer these)
Answer the following questions:
1.)What affect, if any, does increasing the number of clients have on the Turn-around Time for individual clients?
2.)What affect, if any, does increasing the number of clients have on the Average Turn-around Time?
3.)What is the primary cause of the affect on individual client Turn-around Time and Average Turn-around Time?

conclusion: (we need the data analysis results for this)

lessons learned: ( general points to fill in later)
-what a socket is
-running linux commands via java
- creating and implimenting multiple threads ( mention some of the issues with this)
- how to impliment a server / client code



