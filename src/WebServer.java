import java.net.*;

public class WebServer {
    public void run(int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            HttpContext context = new HttpContext(clientSocket);
            Thread thread = new Thread(new RequestProcessor(context));
            thread.start();
        }
    }
}
