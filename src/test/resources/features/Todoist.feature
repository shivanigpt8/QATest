@todoist

  Feature: Test Todoist application

    @Test1
    Scenario: Create project
      Given create project "MyProject" via API
      When Open mobile application
      And login into mobile application
      |           Email          |           Password       |
      |  shivani.gpt27@gmail.com    |           TestAccount    |
      Then verify on mobile that project "MyProject" is created

      @Test2
      Scenario: Create task via mobile phone
      Given Open mobile application
      When Create test task "MyTask" via mobile application in test project "MyProject"
      Then Verify via API that task "MyTask" created successfully

      @Test3
      Scenario: Reopen task
      Given Open mobile application
      And Open test project "MyProject"
      When Open test task "MyTask"
      And Complete test task
      Then Reopen test task "MyTask" via API
      Then Verify that test task "MyTask" appears in test project "MyProject"




