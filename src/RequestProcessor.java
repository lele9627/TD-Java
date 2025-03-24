public class RequestProcessor implements Runnable {
    private HttpContext context;

    public RequestProcessor(HttpContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        try {
            context.request.readClientRequest(context.clientSocket);
            if ("/".equals(context.request.url)) {
                context.response.ok();
            } else {
                context.response.notFound();
            }
            context.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
