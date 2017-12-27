package resources;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import org.testng.Assert;

public class ServiceAPI {
	
	public static void deleteAllUsers(String restURL) throws ClientProtocolException, IOException {
		 
	    HttpUriRequest request = new HttpDelete(restURL);
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	         
	   Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
	}

}
