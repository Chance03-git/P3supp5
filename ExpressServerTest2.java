import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class ExpressServerTest2 {
     @Test
    public void testPostRequest() throws Exception {
        URL url = new URL("http://localhost:3000/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);

        // JSON body to send
        String jsonInputString = "{\"content\": \"Hello, MongoDB!\"}";

        // Send the POST request
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();

        // Assert that the response code is 200 (OK)
        assertEquals(200, responseCode, "Expected HTTP response code 200");
    }
}
