package no.kristiania.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private final ServerSocket serverSocket;
    private final Thread thread;

    public HttpServer(int portNumber) throws IOException {
        serverSocket = new ServerSocket(portNumber);
        thread = new Thread(this::handleClient);
        thread.start();

    }

    private void join() throws InterruptedException {
        thread.join();
    }

    private void handleClient() {
        try {
            Socket clientSocket = serverSocket.accept();
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-length: 12\r\n" +
                    "Content-type: text/plain\r\n" +
                    "\r\n" +
                    "Hello World!";
            clientSocket.getOutputStream().write(response.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpServer httpServer = new HttpServer(8081);
        httpServer.join();
    }

    public int getActualPort() {
        return serverSocket.getLocalPort();
    }
}
