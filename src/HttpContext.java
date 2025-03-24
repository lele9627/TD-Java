import java.net.*;
import java.io.*;

public class HttpContext {
    public Socket clientSocket;
    public HttpRequest request;
    public HttpResponse response;

    public HttpContext(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.request = new HttpRequest();
        this.response = new HttpResponse(clientSocket);
    }

    public void close() throws IOException {
        clientSocket.close();
    }
}
