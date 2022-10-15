public class SearchEngine {
    
}

import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    String str = "";

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("String: %s", str);
        }  else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    str = " " + parameters[1];
                    return String.format("String %s has been added! It's now %s", parameters[1], str);
                }
            }
            if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {

                    

                    List<String> result = new ArrayList<>();
                    for (String s : list) {
                        if (s.contains("Java")) {
                            result.add(s);
                        }

                    
                        for (int i = 0; i < strArray.length; i++) {
                            // Printing the elements of String array
                            System.out.print(strArray[i] + ", ");
                        }
                    

                    str = " " + parameters[1];
                    return String.format("String %s has been added! It's now %s", parameters[1], str);

                }
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