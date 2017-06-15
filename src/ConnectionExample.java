import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionExample {
    public static void main(String[] args) throws IOException {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;
        inputLine = keyboard.readLine();
        keyboard.close();

        String query = "https://www.google.ru/#newwindow=1&safe=strict&q=" + inputLine;
        HttpURLConnection connection = (HttpURLConnection)new URL(query).openConnection();
        connection.setRequestMethod("GET");

        connection.connect();

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            while ((inputLine = bufferedReader.readLine()) != null)
                System.out.println(inputLine);
            bufferedReader.close();
        }
    }
}
