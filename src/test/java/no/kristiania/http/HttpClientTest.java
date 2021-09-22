package no.kristiania.http;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientTest {
    @Test
    void shouldGetSuccessfulResponseCode() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertEquals(200, client.getStatusCode());
    }
    @Test
    void shouldGetfailedResponseCode() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/whatever");
        assertEquals(404, client.getStatusCode());
    }


}