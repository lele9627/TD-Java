import java.io.*;
import java.net.*;

public class HttpRequest {
    public String method;
    public String url;

    public void readClientRequest(Socket clientSocket) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String line = input.readLine();
        if (line != null && !line.isEmpty()) {
            String[] parts = line.split(" ");
            method = parts[0];
            url = parts[1];
        }
        while (!input.readLine().isEmpty()) {}
    }
}
