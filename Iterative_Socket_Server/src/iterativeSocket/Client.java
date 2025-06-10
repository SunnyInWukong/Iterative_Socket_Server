package iterativeSocket;

import java.io.*;               
import java.net.*;              
import java.util.*;

public class Client {
	// Valid sets of arrays
	private static final List<Integer> REQUEST_VALID_NUM = Arrays.asList(1, 5, 10, 15, 20, 25); 
	
	public static void main(String[] args) throws Exception{
		Scanner clientScan = new Scanner(System.in);
		
		System.out.print("Enter an IP address: ");
		String serverClient = clientScan.nextLine();
		
		System.out.print("Enter the port: ");
		int numPort = clientScan.nextInt();
		clientScan.nextLine();
	
	
	while (true) { // pulls the commands
		System.out.println("\n List of Commands");
		System.out.println("1: Date and Time");
		System.out.println("2: Uptime");
		System.out.println("3: Memory Usage");
		System.out.println("4: Netstat");
		System.out.println("5: Current Users");
		System.out.println("6: Running Processes");
		System.out.println("Enter your command (1-6): ");
		String commandLine = clientScan.nextLine().trim();
		
		if(!commandLine.matches("[1-6]")) { // no higher then 6 or less then 1
			System.out.println("Incorrect Choice. Please enter a number between 1 and 6");
			continue;
		}
		System.out.print("Enter a request number(1, 5, 10, 15, 20, 25): ");
		int c; // represents as counts
		try { //checking the valid input
			c = clientScan.nextInt();
			clientScan.nextLine();
			if(!REQUEST_VALID_NUM.contains(c)) {
				System.out.println("Error count. Enter one of the valid number" + REQUEST_VALID_NUM);
			}
		}catch (InputMismatchException e) {
			System.out.println("Error input. Enter numerical value");
			clientScan.nextLine();
			continue;
		}
		List<Long> cTimes = Collections.synchronizedList(new ArrayList<>());
		Thread[] cThreads = new Thread[c];
		
		for(int i = 0; i < c; i++) {
			final int idThread = i;
			cThreads[i] = new Thread(() -> {
				try(
				Socket cSocket = new Socket(serverClient, numPort);
				PrintWriter cOutput = new PrintWriter(cSocket.getOutputStream(), true);
				BufferedReader cIn = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
						){
					long clientStart = System.nanoTime();
					cOutput.println();
					String clientResponse = cIn.readLine();
					long endClient = System.nanoTime();
					
					long clientTurnAround = (endClient - clientStart) / 1_000_000;
					synchronized (cTimes) {
						cTimes.add(clientTurnAround);
					}
					System.out.println("[Client " + idThread + "] turn around: " + clientTurnAround +
							 "ms | Response: " + clientResponse);
				}catch(IOException e) {
					System.out.println("[Client " + idThread + "] ERROR! " + e.getMessage());
				}
			});
			cThreads[i].start();
		}
		for (Thread j : cThreads) {
			j.join();
		}
		long totalClient = cTimes.stream().mapToLong(Long::longValue).sum();
		double cAverage = cTimes.isEmpty() ? 0: (double) totalClient / cTimes.size();
		
		System.out.println("Turn around summaries");
		System.out.println("Time: " + totalClient + " ms");
		System.out.println("Average of the time: %.2f" + cAverage);
	}
	}
}
