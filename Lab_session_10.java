import java.io.*;
import java.net.*;

public class Lab_session_10 {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:");
            System.out.println(" As server: java Lab_session_10 server <port>");
            System.out.println(" As client: java Lab_session_10 client <host> <port>");
            return;
        }

        String mode = args[0].toLowerCase();
        try {
            if (mode.equals("server")) {
                int port = Integer.parseInt(args[1]);
                runAsServer(port);
            } else if (mode.equals("client")) {
                if (args.length < 3) {
                    System.out.println("Client usage: java Lab_session_10 client <host> <port>");
                    return;
                }
                String host = args[1];
                int port = Integer.parseInt(args[2]);
                runAsClient(host, port);
            } else {
                System.out.println("Unknown mode: " + mode);
                System.out.println("Use 'server' or 'client'.");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Port must be an integer.");
        } catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
    }

    // Server sets up a ServerSocket and accepts a single client. Two threads handle incoming and outgoing messages.
    private static void runAsServer(int port) throws IOException {
        System.out.println("Starting server on port " + port + " ...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for client to connect...");
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
                chatOverSocket(clientSocket, "Server");
            }
        }
        System.out.println("....Server stopped");
    }

    // Client connects to server and uses two threads for send/receive
    private static void runAsClient(String host, int port) throws IOException {
        System.out.println("Connecting to " + host + ":" + port + " ...");
        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to server " + socket.getRemoteSocketAddress());
            chatOverSocket(socket, "Client");
        }
        System.out.println("Client stopped.");
    }

    // Shared chat logic (starts reader & writer threads). Closes socket when "exit" typed or connection is closed.
    private static void chatOverSocket(Socket socket, String role) throws IOException {
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));

        // Thread to read messages coming from the remote side and print them to console
        Thread reader = new Thread(() -> {
            try {
                String line;
                while ((line = socketIn.readLine()) != null) {
                    System.out.println((role.equals("Server") ? "Client" : "Server") + ": " + line);
                    if ("exit".equalsIgnoreCase(line.trim())) {
                        break;
                    }
                }
            } 
            catch (IOException e) {}
        });
        reader.setDaemon(true);
        reader.start();

        // Thread to read from console and send to remote
        Thread writer = new Thread(() -> {
            try {
                String inputLine;
                while ((inputLine = consoleIn.readLine()) != null) {
                    socketOut.println(inputLine);
                    if ("exit".equalsIgnoreCase(inputLine.trim())) {
                        break;
                    }
                }
            } 
            catch (IOException e) {}
        });
        writer.setDaemon(true);
        writer.start();

        // Waiting for either thread to finish (exit typed or connection closed)
        try {
            writer.join();
        } catch (InterruptedException ignored) { }
        // If writer finished because user typed "exit", send exit (already sent) and close socket.
        try {
            socket.close();
        } catch (IOException ignored) { }
        System.out.println(role + " connection closed.");
    }
}
