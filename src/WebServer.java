import java.io.*;
import java.net.*;

public class WebServer {

    private void readRequest(Socket socket) throws IOException {
        BufferedReader inputt = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    private void writeResponse(Socket socket) throws IOException {
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        output.println("HTTP/1.1 200 OK");
        output.println("Content-Type: text/html");

        output.println("<!DOCTYPE html>");
        output.println("<html><head><title></title></head><body></body></html>");
        output.flush();
    }


    public void run(int portNumber) throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            readRequest(clientSocket);
            writeResponse(clientSocket);
            clientSocket.close();
        }
    }

}
