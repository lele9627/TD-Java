public class WebServerApplication {
    public static void main(String[] args) throws Exception {
        WebServer server = new WebServer();
        server.run(80);
    }
}
