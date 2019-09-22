package glue;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helpers.configFileReader;
import org.junit.Assert;
import java.util.List;

public class APIglue {

    private RequestSpecification request;
    private String bearer_token;
    private Response response;

    private void set_base_URI(){
        configFileReader reader = new configFileReader("config.properties");
        RestAssured.baseURI = reader.getPropertyFromFile("baseURI");
        request = RestAssured.given();
    }

    @Given("^user logged in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void get_user_session(String email, String password){
        set_base_URI();
        Response response = request.formParams("email", email,"password", password).post("/user_sessions");

        Assert.assertEquals("User session is created",201, response.getStatusCode());
        bearer_token = response.jsonPath().get("bearer_token");
    }

    @Then("^verify that logged in user has sufficient permission to create a reward$")
    public void check_user_authorization(){
        set_base_URI();
        response = request.header("Authorization","Bearer " + bearer_token).get("/authorizations");
        Assert.assertEquals("User authorization is retrieved",200, response.getStatusCode());
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> permissions = jsonPathEvaluator.get("data.permissions.resource_name");
        int i =0 ;
        for(String s : permissions){
            if(s.equals("rewards")){
                List<String> actions = jsonPathEvaluator.get("data.permissions.actions["+i+"]");
                System.out.println("Actions for: " + s + " are " + actions);
                Assert.assertTrue("This user doesn't have permission to create a reward",actions.contains("edit"));
                System.out.println("This user have permission to create a reward");
            }
            i++;
        }
    }

    @And("^tries to access \"([^\"]*)\" API endpoint$")
    public void user_tries_to_access(String path){
        set_base_URI();
        response = request.header("Authorization","Bearer " + bearer_token).get(path);
    }

    @Then("^status code (\\d+) and message \"([^\"]*)\" should be returned$")
    public void verify_code_and_message(int code, String message){
        Assert.assertEquals("Logged in user is able to access the resource",code, response.getStatusCode());
        Assert.assertEquals("Expected error message mismatch",message, response.jsonPath().getString("message"));
    }

    @Then("^verify that logged in user has sufficient permission to \"([^\"]*)\" \"([^\"]*)\"$")
    public void check_user_authorization(String action, String resource){
        set_base_URI();
        response = request.header("Authorization","Bearer " + bearer_token).get("/authorizations");
        Assert.assertEquals("User authorization is retrieved",200, response.getStatusCode());
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> permissions = jsonPathEvaluator.get("data.permissions.resource_name");
        int i =0 ;
        for(String s : permissions){
            if(s.equals(resource)){
                List<String> actions = jsonPathEvaluator.get("data.permissions.actions["+i+"]");
                System.out.println("Actions for: " + s + " are " + actions);
                Assert.assertTrue("This user doesn't have permission to " + action + " " + resource,actions.contains(action));
                System.out.println("This user have permission to " + action + " " + resource);
                return;
            }
            i++;
        }
        Assert.fail(resource + " not present in list of permissions for the logged in user");
    }

   }
