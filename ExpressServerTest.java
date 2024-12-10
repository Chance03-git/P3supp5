import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ExpressServerTest {

    @Test
    public void testPostRequest() throws Exception {
        // Set up the URL connection for the test
        URL url = new URL("http://localhost:3000/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);

        // JSON body to send
        String jsonInputString = "{\"content\": \"Hello, Express!\"}";

        // Send the POST request
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Test if the response code is 200 (OK)
        assertEquals(200, responseCode, "Expected HTTP response code 200");

        // Read the response body (optional, for additional assertions)
        // You could add further assertions to check the content of the response.
    }
}

