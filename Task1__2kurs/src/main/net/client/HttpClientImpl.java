package main.net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClientImpl implements HttpClient {

    public String get() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts?userId=2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            StringBuilder content;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                content = new StringBuilder();
                String input;
                while ((input = bufferedReader.readLine()) != null) {
                    content.append(input);
                }
            }

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            connection.disconnect();

            return content.toString();
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


        public String post() {
            try {
                URL postUrl = new URL("https://gorest.co.in/public/v1/users");
                HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
                String token = "a3d70ee6db24230185f738f9b0653a40c2747ae5f52ef65c03520eaca00e8495";

                postConnection.setRequestMethod("POST");

                postConnection.setRequestProperty("Content-Type", "application/json");
                postConnection.setRequestProperty("Accept", "application/json");
                postConnection.setRequestProperty("Authorization", "Bearer " + token);

                postConnection.setDoOutput(true);

                String jsonInputString = "{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"tenali.ramakrishna2@gmail.com\", \"status\":\"active\"}";

                try (OutputStream outputStream = postConnection.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                    outputStream.write(input, 0, input.length);
                }
                StringBuilder content;
                try (BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(postConnection.getInputStream(), StandardCharsets.UTF_8))) {
                    content = new StringBuilder();
                    String input;
                    while ((input = bufferedReader.readLine()) != null) {
                        content.append(input.trim());
                    }
                }

                return content.toString();
            } catch (ProtocolException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



}
