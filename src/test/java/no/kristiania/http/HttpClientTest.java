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
    void shouldGetFailedResponseCode() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/whatever");
        assertEquals(404, client.getStatusCode());
    }
    @Test
    void shouldReturnHeaderFields() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertEquals("text/html; charset=utf-8", client.getHeader("Content-Type"));
    }
    @Test
    void shouldReadContentLength() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertEquals(3741, client.getContentLength());
    }
    @Test
    void shouldReadMessageBody() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertTrue(client.getMessagebody().startsWith("<!DOCTYPE html>"),
                "Messagebody should start with <!DOCTYPE html>: " + client.getMessagebody());
    }





}