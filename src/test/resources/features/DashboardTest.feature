@dashboard

  Feature: This feature file list the QA Interview Integration Test

    @API
    Scenario Outline: Testing authorization of user roles - Validate that user acc with permission to create a reward is not able to visit the rest of the page sections (loyalties, campaigns, merchants, user lists, bulk actions)
      Given user logged in with "shivani.gpt8@gmail.com" and "shi123456"
      And tries to access "<section>" API endpoint
      Then status code 403 and message "User does not have rights to this object" should be returned
      Examples:
      |section|
      |/campaigns|
      |loyalty_programs|
      |/merchants|
      |/catalogs|
      |/file_imports|

    @API
    Scenario: Creating a reward - Validate that logged in user has sufficient permission to create a reward
      Given user logged in with "shivani.gpt8@gmail.com" and "shi123456"
      Then verify that logged in user has sufficient permission to "edit" "rewards"

    Scenario Outline: Creating a reward - Validate that non-authorized user should not have access to the reward detail/edit page if he tries to access directly from the URL
      Given user access the URL "<URL>" directly
      Then user should be on login page
      Examples:
      |URL|
      |https://www.perxtech.io/dashboard/p/rewards/list|
      |https://www.perxtech.io/dashboard/p/rewards/edit/10900|
      |https://www.perxtech.io/dashboard/p/rewards/create    |

     Scenario: Creating a reward - Validate successfully creating a reward only after giving both start and end date
       Given Perx dashboard URL is launched
       And user logs in dashboard with "shivani.gpt8@gmail.com" and "shi123456"
       When user click on Create New button on rewards page
       Then user should be on the page with title "Reward Info"
       When user enters reward name "TestAutomationReward" on the reward info page
       And user submits reward form without end date
       Then "Start date & end date required" error is displayed on reward page
       And user should be on the page with title "Reward Mechanics"
       When user fills "end date"
       And remove the start date
       And click Next button on rewards page
       Then "Start date & end date required" error is displayed on reward page
       And user should be on the page with title "Reward Mechanics"
       When user fills "start date"
       And click Next button on rewards page
       Then user should be on the page with title "Review"
       When user launch the reward
       And user navigates to "rewards" page
       Then reward "TestAutomationReward" should be displayed in the rewards list

      Scenario: Creating a reward - Validate that catalogues, labels, brands, tags and categories should disappaer for private reward
        Given Perx dashboard URL is launched
       And user logs in dashboard with "shivani.gpt8@gmail.com" and "shi123456"
       When user click on Create New button on rewards page
       Then user should be on the page with title "Reward Info"
       When user selects reward type as "Private"
        Then "Catalogues" label and input field should disappear
       Then "Brands" label and input field should disappear
        Then "Tags" label and input field should disappear
        Then "Categories" label and input field should disappear
        Then "Labels" label and input field should disappear

     @API
     Scenario: Upload a file in bulk list - Validate that logged in used has sufficient permission to visit the bulk file upload page and has the ability to upload
      Given user logged in with "admin@dashboard.com" and "admin1234"
      Then verify that logged in user has sufficient permission to "view" "bulk_actions"
       And verify that logged in user has sufficient permission to "edit" "bulk_actions"

      Scenario: Upload a file in bulk list - Validate that form upload should only accept from the accepted file list (.txt, .xlsx, .csv)
        Given Perx dashboard URL is launched
        And user logs in dashboard with "admin@dashboard.com" and "admin1234"
        When user upload txt,csv or xlsx file and tie it to an action then file should get uploaded and the file list should reflect the uploaded file
        |      FileName              |            Action       |
        |      perxtxt               |     Upload Users        |
        |      perxcsv               |     Issue Vouchers      |
        |      perxexcel             |     Upload Transactions |
        When user upload tries to upload doc file then this unsupported file should not be shown in File Upload form
          |    FileName              |
          |     testdoc              |


