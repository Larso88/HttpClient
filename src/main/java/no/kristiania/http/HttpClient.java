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



        String statusLine = readLine(socket);

        this.statusCode = Integer.parseInt(statusLine.split(" ")[1]);
    }

    private String readLine(Socket socket) throws IOException {
        StringBuilder result = new StringBuilder();

        int c;
        while ((c = socket.getInputStream().read()) != -1 && c != '\r') {
            result.append((char) c);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {

    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getHeader(String s) {
        return null;
    }
}
