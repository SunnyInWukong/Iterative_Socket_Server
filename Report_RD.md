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
-
-create a multithreaded client server that takes a users input for the port it needs to interact with, displays a menu of options to select from, asks for how many iterations of the request they want to complete ( that will become the number of threads created to impliment the specified request). This client server should also keep track of the total amount of time spent in each thread then sum them at the end for the total time spend by all the threads. 
-option to select from the menu : 
"1 : Date and Time
2 : Uptime
3 : Memory Used
4 : Netstat
5 : Current Users
6 : Running Processes"

Client-Server Setup configuration : 
- the client program connects to a server, promptss the user for what operation/values they want to retrieve, prompts jow many timmes it wants to do said operation, then sends requests for this information to thhe server / the # associated with the operation for the server to then send back
- the server program listens to a pre-specified port(its in the code instead of requested from the user ( which we might need to alter), then once the client connects to that port, ;listens to the requests & runs the methods that will return the values the client requested 
- There wasn't much to discuss design wise, other than making the code fit the criteria described & to use the apprach for multithreading we selected. 
- 

how it was tested :  we'll describe the total runtime / errors we might get when making the # of threads large : though it doesnt look like the # of requests he said we should prompt in the menu will be largge enough to cause any real issues
data to collect: total runtime, number of threads, operation performed, ratio of time per thread per operation
table to make:  operation | number of requests | total time | average time | ( do for every option/ operation) & maybe the average change in the average time per increase in number of requests
( there was a way to see it visually, but i dont recall how. we'll need to ask about that one since it says we need a chart AND a graph for each operation ( though we could just make one via excel or somemthing if there aren't any built-in functions in the software he reccomended)

Data analysis: (we need to impliment them to answer these)
Answer the following questions:
1.)What affect, if any, does increasing the number of clients have on the Turn-around Time for individual clients? will need to see if the individual clients are the same speed & if the threading timing casues the difference or the load of requests changes the individual time as well
2.)What affect, if any, does increasing the number of clients have on the Average Turn-around Time? ( will bbe revealed in our tables and such)
3.)What is the primary cause of the affect on individual client Turn-around Time and Average Turn-around Time? server load, concurrency limits( since we're doping iterative instead of concurrent), network latency, command execution time , threading scheduling, time complexity of the methods performed (maybe??)

conclusion: (we need the data analysis results for this)

lessons learned: ( general points to fill in later)
-what a socket is
- how to connect server/ client code to a vpn && run in them in the terminal consol
- how to change the compliance level of my code / recompile to different java version so theres no issue with running it in a server using a different java version
-running linux commands via java 
- - creating and implimenting multiple threads ( mention some of the issues with this : the odd sytax needed, what runnabble keyword does, different notations/approaches found && picking which one to use,etc.)
- how to implement a server / client code (going through the steps shown in the " how to connect to the vpn:" announcement)
-how to determine individual client turn-around time for individual clients
- determining the amount threading buffers affect the turn-around time
- determining how much the server load affects the turn around time
- how different server commmands affect the turn around time ( if we are pressed for word count we could do this)
- 


