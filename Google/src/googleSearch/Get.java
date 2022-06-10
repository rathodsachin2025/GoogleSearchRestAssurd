package googleSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Get {
	
	@Test
    public void GetSearch() { 
        
        RestAssured.baseURI = "https://google-search3.p.rapidapi.com/api/v1/search/q=elon+musk"; 
        
        RequestSpecification httpRequest = RestAssured.given(); 
      
       Response response = httpRequest.header("X-RapidAPI-Key","39a2f4f4e6msh771b48f2024fa86p1af4b0jsnf3d64f43844a").get();
        //Response response=httpRequest.get();
        
        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        //Response in raw format
        System.out.println("Response Body is: " + body.asString());
        // Print the status and message body of the response received from the server 
        System.out.println("Status received => " + response.getStatusLine());
        //Response in pretty format
        //System.out.println("Response=>" + response.prettyPrint());
        
        // Assert that correct status code is returned.
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode , 200, "Successful");
        
        //Assert Status line
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK" , "Correct status code returned");
        
        // Get all the headers and then iterate over allHeaders to print each header 
         Headers allHeaders = response.headers(); 
        // Iterate over all the Headers 
         for(Header header : allHeaders) { 
           System.out.println("Key: " + header.getName() + " Value: " + header.getValue()); 
         } 
         
        // Access header with a given name. 
         String contentType = response.header("Content-Type"); 
         System.out.println("Content-Type value: " + contentType);
         Assert.assertEquals("application/json", contentType); 
         
         String date = response.header("date"); 
         System.out.println("date: " + date);
         
         String contentlength = response.header("content-length"); 
         System.out.println("content-length: " + contentlength);
         
         String xRapidapiRregion = response.header("x-rapidapi-region"); 
         System.out.println("x-rapidapi-region: " +  xRapidapiRregion);
         
        // Access header with a given name. Header = Content-Encoding
         String acceptLanguage = response.header("Content-Encoding"); 
         System.out.println("Content-Encoding: " + acceptLanguage);      
	}
}
