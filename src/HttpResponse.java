import java.io.*;
import java.net.*;

public class HttpResponse {
    private BufferedWriter output;

    public HttpResponse(Socket clientSocket) throws IOException {
        output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    }

    public void ok() throws IOException {
        output.write("HTTP/1.0 200 OK\n");
        output.write("Content-Type: text/html\n\n");
        output.write("<html><body><h1>La marmotte c'est genial</h1></body></html>");
        output.flush();
    }

    public void notFound() throws IOException {
        output.write("HTTP/1.0 404 Not Found\n");
        output.write("Content-Type: text/html\n\n");
        output.write("<html><body><h1>Erreur 404 : Page non trouvée</h1></body></html>");
        output.flush();
    }
}
