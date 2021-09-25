package no.kristiania.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);
        Socket clientSocket = serverSocket.accept();
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-length: 12\r\n" +
                "Content-type: text/plain\r\n" +
                "\r\n" +
                "Hello World!";
        clientSocket.getOutputStream().write(response.getBytes());

    }
}
