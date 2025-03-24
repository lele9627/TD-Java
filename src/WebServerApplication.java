public class WebServerApplication {
    public static void main(String[] args) throws java.io.IOException {
        WebServer server = new WebServer();
        server.run(80); // Port 80
    }
}
