package step_definitions.api;

import org.junit.Assert;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITests {
	
	{
		RestAssured.baseURI = "https://api.github.com";
	}
	
	private String httpRequest;
	private String nameOfRepo;
	private static final String TOKEN = "565d1402383eddba542a0d9ddbc65228d2a0c502";
	
	@Given("I get my repositories")
	public void i_get_my_repositories() {
	    Response response = RestAssured.given()
	    		.get("/users/ums-education/repos");
	    
	    Assert.assertEquals("The status code should be 200 before we continue testing",
				200, response.getStatusCode());
	    
	    String myResponse = response.prettyPrint();
	    
	    System.out.println(myResponse);
	}
	
	@Given("I want to {string} a repository")
	public void i_want_to_a_repository(String httpRequest) {
		this.httpRequest = httpRequest;
	}

	@When("I pass in the {string}")
	public void i_pass_in_the(String nameOfRepo) {
	    this.nameOfRepo = nameOfRepo;
	}

	@Then("I should {string} the repository in my profile")
	public void i_should_the_repository_in_my_profile(String flag) {
		RequestSpecification request = null;
		Response response = null;
		String body = "{\n" + 
						"  \"name\": \"" + nameOfRepo + "\"\n" + 
					  "}";
		
		System.out.println(body);
		
	    switch (httpRequest) {
			case "post":
					request = RestAssured.given()
						.header("Content-Type", "application/json")
						.and()
						.header("Authorization", "Bearer " + TOKEN)
						.body(body);
						
					response = request.post("/user/repos");
					
					Assert.assertEquals("Status code should be 201", 
				    		201, response.getStatusCode());
				break;
	
			case "delete":
					request = RestAssured.given()
						.header("Content-Type", "application/json")
						.and()
						.header("Authorization", "Bearer " + TOKEN);
					
					response = request.delete("/repos/ums-education/"
							+ nameOfRepo);
					
					Assert.assertEquals("Status code should be 204", 
				    		204, response.getStatusCode());
				break;
				
			default:
				break;
		}
	    
	    
	}
	
}
