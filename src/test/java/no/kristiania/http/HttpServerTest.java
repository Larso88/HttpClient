package no.kristiania.http;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HttpServerTest {
    @Test
    void shouldReadResponseCode() throws IOException {
        HttpServer server = new HttpServer(8080);
        HttpClient client = new HttpClient("localhost", server.getActualPort(), "/hello");
        assertEquals(200, client.getStatusCode());
    }
}