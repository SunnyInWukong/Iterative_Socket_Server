# Iterative Socket Server

## Overview
This project implements a **single-threaded iterative client-server system in Java**.  
The server listens on a port, accepts client requests, performs system operations, and returns results.  
Unlike a concurrent server, it handles one client at a time (serially), making it useful for learning the trade-offs between iterative and concurrent designs.

---

## Features

### Server
- Listens on a specified port for incoming requests  
- Handles **one client at a time** (iterative design)  
- Supports the following system queries:
  - Current date and time  
  - Uptime (time since last boot)  
  - Current memory usage  
  - Active network connections  
  - Users currently logged in  
  - Processes currently running  

### Client
- Prompts user for:
  - Server IP address  
  - Port number  
  - Desired operation (from the list above)  
  - Number of requests to send  
- Sends the requests to the server  
- Displays the server’s responses  

---

## How It Works
- **Iterative design:**  
  Each client request is processed one at a time. A new request must wait until the current one finishes.  
- **Client-server communication:**  
  Implemented using Java sockets (`ServerSocket`, `Socket`).  
- **System commands:**  
  The server runs terminal commands via a helper method (`runCommand`) to collect system info.  

---

## Testing & Analysis
For testing, the server and client were run on a remote university system via VPN.  
Experiments collected data on:
- **Total turnaround time** for different request loads (1, 5, 10, 15, 20, 25).  
- **Average response time** per request.  

This data was later compared with the **Concurrent Socket Server** implementation to evaluate scalability and performance trade-offs.

---

## Lessons Learned
- Differences between **iterative** and **concurrent** server models.  
- Practical use of **Java socket programming**.  
- Performance analysis under varying loads.  
- Handling system-level commands from Java programs.  

