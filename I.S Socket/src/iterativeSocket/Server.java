package iterativeSocket;

import java.io.*;
import java.net.*;
import java.time.*;
import java.util.*;

public class Server {
    private static final int SERVER_PORT = 1159; // fixed value port
    private static final LocalDateTime startingClock = LocalDateTime.now(); // starting time
    
    public static void main(String[] args) {
    	System.out.println("Server started. Listening on port " + SERVER_PORT + ".");
    	try (ServerSocket socketServer = new ServerSocket(SERVER_PORT)){
    		while(true) {
    			try {
    				Socket socketClient = socketServer.accept(); // one server each accept
    				clientHandle(socketClient);
    			} catch (IOException e) {
    				System.out.println("[Server] not accepting connection Error: " + e.getMessage());
    			}
    		}
    	}catch(IOException e) {
    		System.out.println("[Server] server cannot start: " + e.getMessage());
    	}
    }

	private static void clientHandle(Socket socketClient) { // handles all socket 
		try(
			BufferedReader readIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
				PrintWriter printOut = new PrintWriter(socketClient.getOutputStream(), true)
						){
							String serverRequest = readIn.readLine();
							if(serverRequest == null) {
								System.out.println("Invalid Request Recieved");
								return;
							}
							String serverResponse = requestHandle(serverRequest.trim());
							printOut.println(serverResponse);
		}catch (IOException e) {
			System.out.println("[Server] handling ERROR: " + e.getMessage());
		}finally {
			try {
				socketClient.close();
			} catch(IOException e) {
				System.out.println("[Server] ERROR CLOSE SOCKET: " + e.getMessage());
			}
		}
	}

	private static String requestHandle(String trimRequest) { // getting starting time request
		return switch (trimRequest) {
		case "1" -> "Date amd Time: " + LocalDateTime.now();
		case "2" -> {
			Duration startTime = Duration.between(startingClock, LocalDateTime.now());
			yield "Start time: " + startTime.toSeconds() + " seconds";
		}
		case "3" ->{
			Runtime timeRun = Runtime.getRuntime();
			long usedMemory = timeRun.totalMemory() - timeRun.freeMemory();
			yield "Memory Used: " + (usedMemory / (1024 * 1024)) + " MB";
		}
		case "4" -> runCommand("net state ");
		case "5" -> runCommand("who's on ");
		case "6" -> runCommand("ps -e");
		default -> "Invalid choice/command. Choose 1 to 6 as valid command.";
		};	
	}

	private static String runCommand(String runCommand) { // getting command output
		StringBuilder serverOutput = new StringBuilder();
		try {
			Process serverProcess = Runtime.getRuntime().exec(runCommand);
			try(BufferedReader readBuff = new BufferedReader(new InputStreamReader(serverProcess.getInputStream()))){
				String lineCommand;
				int c = 0;
				while ((lineCommand = readBuff.readLine()) != null && c++ < 10) {
					serverOutput.append(lineCommand).append("\n");
				}
			}
		}catch (IOException e) {
			return "Executing Error: " + e.getMessage();
		}
		return serverOutput.toString().trim();
	}
}