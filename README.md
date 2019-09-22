<b>The test project uses below </b>
-	Cucumber as the test framework 
-	Selenium webdriver library for interacting with web browser
-	Rest assured library for API test

<b>To run the test- </b>
1.	Download the project 
2.	Run the runner file
3.	The test project runs successfully with Chrome v74 (as the chrome driver used is for  chrome v74)
4.	To run only the API test (which doesn’t require browser), use the tag @API. Change the tag from @dashboard to @API in runner.java file

<b>Test report – </b>
After test run , a report will be generated with the name index.html, which will be in target/cucumber-reports directory. 
Open the index.html using any browser
The report of the last test run has been uploaded at the above path for the reference. To view the uploaded report download the target/cucumber-reports directory and open the index.html using any browser.
The test in green are the scenarios which passed
The test in red are the scenarios which failed
The test in blue are the test steps which were skipped because of the failure in the test scenario

<b>Defects found in automated test run – </b>
While running the @dashboard test, 3 tests were failed,because the application behaviour is not as expected, the reason for failure is clearly captured in test report
1.	Validate that user acc with permission to create a reward is not able to visit the rest of the page sections (loyalties, campaigns, merchants, user lists, bulk actions) – This test fails because the user shivani.gpt8@gmail.com which has permissions to edit and view reward is able to access  /merchants endpoint also. The test fails with clear error message and the actual and expected status code.

2.	Validate that user acc with permission to create a reward is not able to visit the rest of the page sections (loyalties, campaigns, merchants, user lists, bulk actions) – This test fails because the user shivani.gpt8@gmail.com which has permissions to edit and view reward is able to access /catalogs endpoint also. The test fails with clear error message and the actual and expected status code.

3.	Validate that catalogues, labels, brands, tags and categories should disappaer for private reward –This test fails because on selecting reward type as private ,only catalogues field disappears , labels, brands and tags remains visible. So the test fails with clear error message. 

<b>Assumption- </b>
In the scenario – “Create a reward” , there is a test to check “It should not show up in the rewards listing”. 
It has been assumed that the test should be “It should show up in the rewards listing” because the reward is and should be displayed in the rewards list after being created. The test is coded as per this assumption.

