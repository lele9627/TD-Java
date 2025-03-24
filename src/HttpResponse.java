import java.io.*;
import java.net.*;

public class HttpResponse {
    private OutputStream output;

    public HttpResponse(Socket clientSocket) throws IOException {
        this.output = clientSocket.getOutputStream();
    }

    public void ok() throws IOException {
        output.write("HTTP/1.0 200 OK\n".getBytes());
    }

    public void notFound() throws IOException {
        output.write("HTTP/1.0 404 Not Found\n".getBytes());
        output.write("Content-Type: text/html\n\n".getBytes());
        output.write("<html><body><h1>404 - Not Found</h1></body></html>".getBytes());
    }

    public void sendContent(String type, String content) throws IOException {
        output.write(("Content-Type: " + type + "\n").getBytes());
        output.write("\n".getBytes());
        output.write(content.getBytes());
    }

    public void sendFile(String type, String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            notFound();
            return;
        }

        output.write("HTTP/1.0 200 OK\n".getBytes());
        output.write(("Content-Type: " + type + "\n\n").getBytes());

        FileInputStream fileInput = new FileInputStream(file);
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fileInput.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        fileInput.close();
    }
}
