import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlExample {

    public static void main(String[] args) throws IOException {
        StringBuilder searchString =
                new StringBuilder("https://www.google.ru/#newwindow=1&safe=strict&q=");

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;
        inputLine = keyboard.readLine();
        keyboard.close();

        searchString.append(inputLine);
        URL url = new URL(searchString.toString());

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(url.openStream()));
        while ((inputLine = bufferedReader.readLine()) != null)
            System.out.println(inputLine);
        bufferedReader.close();
    }
}
