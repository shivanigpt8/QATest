package glue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.net.URLEncoder;

public class APIglue {

    @Then("^Verify via API that task \"(.*)\" created successfully$")
    public void checkTask(String taskName) throws Exception
    {
        String url = "https://api.todoist.com/rest/v1/tasks";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("authorization","Bearer " + "2f72bba03895a837fd2c08b4b082adf8fb2304fd");
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        Assert.assertEquals("Create project API resposnse code is:" + con.getResponseCode(),con.getResponseCode(),200);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        JSONArray myResponse = new JSONArray(response.toString());
        for(int i =0; i<myResponse.length(); i++)
        {
            JSONObject jObj = myResponse.getJSONObject(i);
            if(jObj.has("content"))
            {
                if(jObj.getString("content").equalsIgnoreCase(taskName)) {
                    System.out.println("Name is: " + jObj.getString("content"));
                    Assert.assertEquals("Task is created",jObj.getString("content"),taskName);
                    return;
                }
            }
        }
        Assert.fail("Task is not created");
    }


    @When("create project \"(.*)\" via API")
    public void createProject(String projectName) throws Exception
    {
        URL url = new URL("https://api.todoist.com/rest/v1/projects");
        Map<String,String> params = new HashMap<>();
        params.put("name", projectName);
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,String> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("authorization","Bearer " + "2f72bba03895a837fd2c08b4b082adf8fb2304fd");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            sb.append((char)c);
        String response = sb.toString();
        System.out.println(response);
        JSONObject myResponse = new JSONObject(response.toString());
        Assert.assertEquals("Project name in API response is not correct",projectName,myResponse.getString("name"));
        Assert.assertEquals("Create project API resposnse code is:" + conn.getResponseCode(),200,conn.getResponseCode());
    }

    @Then("^Reopen test task \"(.*)\" via API$")
    public void reopenTask(String taskName) throws Exception
    {
        Object taskID = getTaskIDFromTaskName(taskName);
        System.out.println("Task Id for task " + taskName + " is " + taskID);
        String link = "https://api.todoist.com/rest/v1/tasks/" + taskID + "/reopen";
        URL url = new URL(link);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("authorization","Bearer " + "2f72bba03895a837fd2c08b4b082adf8fb2304fd");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        Assert.assertEquals("Create project API resposnse code is:" + conn.getResponseCode(),conn.getResponseCode(),204);
        Assert.assertEquals("Response body of reopen task API is not blank",conn.getResponseMessage(),"No Content");
    }

    public Object getTaskIDFromTaskName(String taskName) throws Exception
    {
        String url = "https://api.todoist.com/rest/v1/tasks";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("authorization","Bearer " + "2f72bba03895a837fd2c08b4b082adf8fb2304fd");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        JSONArray myResponse = new JSONArray(response.toString());
        System.out.println("result after Reading JSON Response");
        for(int i =0; i<myResponse.length(); i++)
        {
            JSONObject jObj = myResponse.getJSONObject(i);
            if(jObj.has("content"))
            {
                if(jObj.getString("content").equalsIgnoreCase(taskName)) {
                    return jObj.get("id");
                }
            }
        }
        return 0;
    }
}
