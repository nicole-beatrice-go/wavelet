import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    String[] parameters = [];
    String[] parameters2 = [];
    String[] string = [];
    String keyword = ""

    public String handleRequest(URI url) {
        if (url.getPath().equals("/search")) {
            parameters1 = url.getQuery().split("=");
            keyword = parameters1[1];
            if (url.getPath().contains(keyword)) {
                string.add(keyword);
                return string;
            }
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                parameters2 = url.getQuery().split("=");
                string.add((parameters2[1]));
            }
            return "404 Not Found!";
        }
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}