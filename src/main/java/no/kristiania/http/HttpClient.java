package no.kristiania.http;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpClient {
    private final int statusCode;

    public HttpClient(String host, int port, String requestTarget) throws IOException {
        Socket socket = new Socket(host, port);
        String request = "GET " + requestTarget + " HTTP/1.1\r\n" +
                "connection: close\r\n" +
                "Host: " + host + "\r\n" +
                "\r\n";
        socket.getOutputStream().write(request.getBytes());

        StringBuilder result = new StringBuilder();
        int c;
        while ((c = socket.getInputStream().read()) != -1) {
            result.append((char) c);
        }
        System.out.println(result);
        String responsMessage = result.toString();
        this.statusCode = Integer.parseInt(responsMessage.split(" ")[1]);
    }

    public static void main(String[] args) throws IOException {

    }

    public int getStatusCode() {
        return statusCode;
    }
}
