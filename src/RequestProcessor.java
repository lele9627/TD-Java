public class RequestProcessor implements Runnable {
    private HttpContext context;

    public RequestProcessor(HttpContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        try {
            context.request.readClientRequest(context.clientSocket);
            System.out.println("Méthode : " + context.request.method);
            System.out.println("URL     : " + context.request.url);

            String url = context.request.url;

            if ("/".equals(url)) {
                context.response.sendFile("text/html", "public/index.html");
            } else {
                String filePath = "public" + url;
                String mimeType = getMimeType(filePath);
                context.response.sendFile(mimeType, filePath);
            }

            context.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getMimeType(String path) {
        if (path.endsWith(".html")) return "text/html";
        if (path.endsWith(".css")) return "text/css";
        if (path.endsWith(".png")) return "image/png";
        if (path.endsWith(".jpg") || path.endsWith(".jpeg")) return "image/jpeg";
        return "application/octet-stream";
    }
}
