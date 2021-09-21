package no.kristiania.http;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpClient {
    public HttpClient(String host, int port, String target) throws IOException {
        Socket socket = new Socket("httpbin.org", 80);
        String request = "GET /html HTTP/1.1\r\n" +
                "Host: httpbin.org\r\n" +
                "\r\n";
        socket.getOutputStream().write(request.getBytes());

        int c;
        while ((c = socket.getInputStream().read()) != -1 && c != '\r') {
            System.out.print((char) c);
        }
    }

    public static void main(String[] args) throws IOException {

    }

    public int getStatusCode() {
        return 200;
    }
}
