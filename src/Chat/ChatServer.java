package Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
	 private static final int PORT = 12345; 
	 private static Set<ClientHandler> clientHandlers = new HashSet<>();
	 public static void main(String[] args) {
		 System.out.println("Server is running...");
	        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
	            while (true) {
	                Socket socket = serverSocket.accept();
	                ClientHandler clientHandler = new ClientHandler(socket);
	                clientHandlers.add(clientHandler);
	                new Thread(clientHandler).start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	 public static void broadcast(String message, ClientHandler excludeClient) {
	        for (ClientHandler client : clientHandlers) {
	            if (client != excludeClient) {
	                client.sendMessage(message);
	            }	
	        }
}
}