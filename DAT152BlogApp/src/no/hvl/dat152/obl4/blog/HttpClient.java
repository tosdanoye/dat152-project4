package no.hvl.dat152.obl4.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * @author tdoy
 */

public class HttpClient {
	
	private String endpoint;
	
	public HttpClient(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public String requestToken(String clientId, String data) {
		
		char[] buffer = new char[4096];
		URL url;

		try {
			
			// we will use this HTTP client (not a browser) to request for the JWT token
			String client_credentials = Base64.getUrlEncoder().encodeToString(clientId.getBytes());
			
			URI uri = new URI(endpoint);
			url = uri.toURL();
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Java Agent");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Authorization", "Basic "+client_credentials);
			con.setDoOutput(true);
			
			PrintWriter pw = new PrintWriter(con.getOutputStream(), false);
			pw.write(data);		// pass the data in the body
			pw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			br.read(buffer, 0, buffer.length);
			
			con.disconnect();
			
			return new String(buffer);
			
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
		return null;

	}
	
	public String processToken(String clientId, String data) throws IOException {
		
		String client_credentials = Base64.getUrlEncoder().encodeToString(clientId.getBytes());
		
		OkHttpClient client = new OkHttpClient();
		
		RequestBody body = RequestBody.create(data.getBytes());
		Request request = new Request.Builder()
				.url(endpoint)
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("Authorization", "Basic "+client_credentials)
				.post(body)
				.build();
		
		try (Response response = client.newCall(request).execute()){
			if(!response.isSuccessful())
				throw new IOException("Unexpected code " + response);
			
			return response.body().string();
		}
	}

}
