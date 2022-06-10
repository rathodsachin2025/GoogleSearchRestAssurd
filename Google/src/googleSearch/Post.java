package googleSearch;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Post {

	@Test
	public void PostSERP() {
		
		
		
	    String position= "6"; 
	    String  query="q=google+search+api&num=100";
	    String website="https://rapidapi.com";
	    System.out.println("");
	    RestAssured.baseURI = "https://google-search3.p.rapidapi.com/";
	    
	    RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json");
	    Response response1 = httpRequest.header("X-RapidAPI-Key","39a2f4f4e6msh771b48f2024fa86p1af4b0jsnf3d64f43844a").get("api/v1/serp/");
	    
	    Response response2 = httpRequest.queryParams("query","q=google+search+api&num=100").get("api/v1/serp/");
	    
	    Response response = httpRequest.body("{ \"position\": \"" + position + "\", \"query\": \"" + query + "\",\"website\": \"" + website + "\"}").post("api/v1/serp/");
	    System.out.println("position :"+position);
	    System.out.println("query :"+query);
	    System.out.println("website :"+website);
	    ResponseBody body = response.getBody();
	    System.out.println("The response code - " +response.getStatusCode());

	    int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode , 200, "Successful");
        System.out.println("The response code - " +response.getStatusCode());

        //Assert Status line
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK" , "Correct status code returned");
        
        String contentType = response.header("Content-Type"); 
        System.out.println("Content-Type value: " + contentType);
        Assert.assertEquals("application/json", contentType); 
        
        System.out.println("");
        
        String date = response.header("date"); 
        System.out.println("date: " + date);
        
        String contentlength = response.header("content-length"); 
        System.out.println("content-length: " + contentlength);
        
        String xRapidapiRregion = response.header("x-rapidapi-region"); 
        System.out.println("x-rapidapi-region: " +  xRapidapiRregion);
                
        
        JsonPath jsonPathEvaluator = response.jsonPath();

       System.out.println("websit:" + jsonPathEvaluator.get("websit"));
        System.out.println("query:" + jsonPathEvaluator.get("query"));

	}
}