$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/DashboardTest.feature");
formatter.feature({
  "line": 3,
  "name": "This feature file list the QA Interview Integration Test",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@dashboard"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Testing authorization of user roles - Validate that user acc with permission to create a reward is not able to visit the rest of the page sections (loyalties, campaigns, merchants, user lists, bulk actions)",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions)",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user logged in with \"shivani.gpt8@gmail.com\" and \"shi123456\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "tries to access \"\u003csection\u003e\" API endpoint",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "status code 403 and message \"User does not have rights to this object\" should be returned",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);",
  "rows": [
    {
      "cells": [
        "section"
      ],
      "line": 10,
      "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;1"
    },
    {
      "cells": [
        "/campaigns"
      ],
      "line": 11,
      "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;2"
    },
    {
      "cells": [
        "loyalty_programs"
      ],
      "line": 12,
      "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;3"
    },
    {
      "cells": [
        "/merchants"
      ],
      "line": 13,
      "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;4"
    },
    {
      "cells": [
        "/catalogs"
      ],
      "line": 14,
      "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;5"
    },
    {
      "cells": [
        "/file_imports"
      ],
      "line": 15,
      "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;6"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Testing authorization of user roles - Validate that user acc with permission to create a reward is not able to visit the rest of the page sections (loyalties, campaigns, merchants, user lists, bulk actions)",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@dashboard"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user logged in with \"shivani.gpt8@gmail.com\" and \"shi123456\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "tries to access \"/campaigns\" API endpoint",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "status code 403 and message \"User does not have rights to this object\" should be returned",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "shivani.gpt8@gmail.com",
      "offset": 21
    },
    {
      "val": "shi123456",
      "offset": 50
    }
  ],
  "location": "APIglue.get_user_session(String,String)"
});
formatter.result({
  "duration": 3877160648,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/campaigns",
      "offset": 17
    }
  ],
  "location": "APIglue.user_tries_to_access(String)"
});
formatter.result({
  "duration": 305126073,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "403",
      "offset": 12
    },
    {
      "val": "User does not have rights to this object",
      "offset": 29
    }
  ],
  "location": "APIglue.verify_code_and_message(int,String)"
});
formatter.result({
  "duration": 9694173,
  "status": "passed"
});
formatter.after({
  "duration": 63583,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Testing authorization of user roles - Validate that user acc with permission to create a reward is not able to visit the rest of the page sections (loyalties, campaigns, merchants, user lists, bulk actions)",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@dashboard"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user logged in with \"shivani.gpt8@gmail.com\" and \"shi123456\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "tries to access \"loyalty_programs\" API endpoint",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "status code 403 and message \"User does not have rights to this object\" should be returned",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "shivani.gpt8@gmail.com",
      "offset": 21
    },
    {
      "val": "shi123456",
      "offset": 50
    }
  ],
  "location": "APIglue.get_user_session(String,String)"
});
formatter.result({
  "duration": 567653901,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "loyalty_programs",
      "offset": 17
    }
  ],
  "location": "APIglue.user_tries_to_access(String)"
});
formatter.result({
  "duration": 288006619,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "403",
      "offset": 12
    },
    {
      "val": "User does not have rights to this object",
      "offset": 29
    }
  ],
  "location": "APIglue.verify_code_and_message(int,String)"
});
formatter.result({
  "duration": 7938458,
  "status": "passed"
});
formatter.after({
  "duration": 28715,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Testing authorization of user roles - Validate that user acc with permission to create a reward is not able to visit the rest of the page sections (loyalties, campaigns, merchants, user lists, bulk actions)",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@dashboard"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user logged in with \"shivani.gpt8@gmail.com\" and \"shi123456\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "tries to access \"/merchants\" API endpoint",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "status code 403 and message \"User does not have rights to this object\" should be returned",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "shivani.gpt8@gmail.com",
      "offset": 21
    },
    {
      "val": "shi123456",
      "offset": 50
    }
  ],
  "location": "APIglue.get_user_session(String,String)"
});
formatter.result({
  "duration": 422146543,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/merchants",
      "offset": 17
    }
  ],
  "location": "APIglue.user_tries_to_access(String)"
});
formatter.result({
  "duration": 400729689,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "403",
      "offset": 12
    },
    {
      "val": "User does not have rights to this object",
      "offset": 29
    }
  ],
  "location": "APIglue.verify_code_and_message(int,String)"
});
formatter.result({
  "duration": 2012099,
  "error_message": "java.lang.AssertionError: Logged in user is able to access the resource expected:\u003c403\u003e but was:\u003c200\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:743)\r\n\tat org.junit.Assert.assertEquals(Assert.java:118)\r\n\tat org.junit.Assert.assertEquals(Assert.java:555)\r\n\tat glue.APIglue.verify_code_and_message(APIglue.java:64)\r\n\tat ✽.Then status code 403 and message \"User does not have rights to this object\" should be returned(features/DashboardTest.feature:8)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 70146,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Testing authorization of user roles - Validate that user acc with permission to create a reward is not able to visit the rest of the page sections (loyalties, campaigns, merchants, user lists, bulk actions)",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@dashboard"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user logged in with \"shivani.gpt8@gmail.com\" and \"shi123456\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "tries to access \"/catalogs\" API endpoint",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "status code 403 and message \"User does not have rights to this object\" should be returned",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "shivani.gpt8@gmail.com",
      "offset": 21
    },
    {
      "val": "shi123456",
      "offset": 50
    }
  ],
  "location": "APIglue.get_user_session(String,String)"
});
formatter.result({
  "duration": 562356809,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/catalogs",
      "offset": 17
    }
  ],
  "location": "APIglue.user_tries_to_access(String)"
});
formatter.result({
  "duration": 378938309,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "403",
      "offset": 12
    },
    {
      "val": "User does not have rights to this object",
      "offset": 29
    }
  ],
  "location": "APIglue.verify_code_and_message(int,String)"
});
formatter.result({
  "duration": 934877,
  "error_message": "java.lang.AssertionError: Logged in user is able to access the resource expected:\u003c403\u003e but was:\u003c200\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:743)\r\n\tat org.junit.Assert.assertEquals(Assert.java:118)\r\n\tat org.junit.Assert.assertEquals(Assert.java:555)\r\n\tat glue.APIglue.verify_code_and_message(APIglue.java:64)\r\n\tat ✽.Then status code 403 and message \"User does not have rights to this object\" should be returned(features/DashboardTest.feature:8)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 728129,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Testing authorization of user roles - Validate that user acc with permission to create a reward is not able to visit the rest of the page sections (loyalties, campaigns, merchants, user lists, bulk actions)",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;testing-authorization-of-user-roles---validate-that-user-acc-with-permission-to-create-a-reward-is-not-able-to-visit-the-rest-of-the-page-sections-(loyalties,-campaigns,-merchants,-user-lists,-bulk-actions);;6",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@dashboard"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user logged in with \"shivani.gpt8@gmail.com\" and \"shi123456\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "tries to access \"/file_imports\" API endpoint",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "status code 403 and message \"User does not have rights to this object\" should be returned",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "shivani.gpt8@gmail.com",
      "offset": 21
    },
    {
      "val": "shi123456",
      "offset": 50
    }
  ],
  "location": "APIglue.get_user_session(String,String)"
});
formatter.result({
  "duration": 519834454,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/file_imports",
      "offset": 17
    }
  ],
  "location": "APIglue.user_tries_to_access(String)"
});
formatter.result({
  "duration": 270496232,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "403",
      "offset": 12
    },
    {
      "val": "User does not have rights to this object",
      "offset": 29
    }
  ],
  "location": "APIglue.verify_code_and_message(int,String)"
});
formatter.result({
  "duration": 21521869,
  "status": "passed"
});
formatter.after({
  "duration": 65224,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Creating a reward - Validate that logged in user has sufficient permission to create a reward",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-logged-in-user-has-sufficient-permission-to-create-a-reward",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "user logged in with \"shivani.gpt8@gmail.com\" and \"shi123456\"",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "verify that logged in user has sufficient permission to \"edit\" \"rewards\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "shivani.gpt8@gmail.com",
      "offset": 21
    },
    {
      "val": "shi123456",
      "offset": 50
    }
  ],
  "location": "APIglue.get_user_session(String,String)"
});
formatter.result({
  "duration": 496388683,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "edit",
      "offset": 57
    },
    {
      "val": "rewards",
      "offset": 64
    }
  ],
  "location": "APIglue.check_user_authorization(String,String)"
});
formatter.result({
  "duration": 329386119,
  "status": "passed"
});
formatter.after({
  "duration": 44713,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 21,
  "name": "Creating a reward - Validate that non-authorized user should not have access to the reward detail/edit page if he tries to access directly from the URL",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-non-authorized-user-should-not-have-access-to-the-reward-detail/edit-page-if-he-tries-to-access-directly-from-the-url",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 22,
  "name": "user access the URL \"\u003cURL\u003e\" directly",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "user should be on login page",
  "keyword": "Then "
});
formatter.examples({
  "line": 24,
  "name": "",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-non-authorized-user-should-not-have-access-to-the-reward-detail/edit-page-if-he-tries-to-access-directly-from-the-url;",
  "rows": [
    {
      "cells": [
        "URL"
      ],
      "line": 25,
      "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-non-authorized-user-should-not-have-access-to-the-reward-detail/edit-page-if-he-tries-to-access-directly-from-the-url;;1"
    },
    {
      "cells": [
        "https://www.perxtech.io/dashboard/p/rewards/list"
      ],
      "line": 26,
      "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-non-authorized-user-should-not-have-access-to-the-reward-detail/edit-page-if-he-tries-to-access-directly-from-the-url;;2"
    },
    {
      "cells": [
        "https://www.perxtech.io/dashboard/p/rewards/edit/10900"
      ],
      "line": 27,
      "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-non-authorized-user-should-not-have-access-to-the-reward-detail/edit-page-if-he-tries-to-access-directly-from-the-url;;3"
    },
    {
      "cells": [
        "https://www.perxtech.io/dashboard/p/rewards/create"
      ],
      "line": 28,
      "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-non-authorized-user-should-not-have-access-to-the-reward-detail/edit-page-if-he-tries-to-access-directly-from-the-url;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 26,
  "name": "Creating a reward - Validate that non-authorized user should not have access to the reward detail/edit page if he tries to access directly from the URL",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-non-authorized-user-should-not-have-access-to-the-reward-detail/edit-page-if-he-tries-to-access-directly-from-the-url;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@dashboard"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "user access the URL \"https://www.perxtech.io/dashboard/p/rewards/list\" directly",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "user should be on login page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.perxtech.io/dashboard/p/rewards/list",
      "offset": 21
    }
  ],
  "location": "webAppglue.open_URL(String)"
});
formatter.result({
  "duration": 4972294568,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.verify_user_is_on_login_page()"
});
formatter.result({
  "duration": 54369741,
  "status": "passed"
});
formatter.after({
  "duration": 1691305067,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Creating a reward - Validate that non-authorized user should not have access to the reward detail/edit page if he tries to access directly from the URL",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-non-authorized-user-should-not-have-access-to-the-reward-detail/edit-page-if-he-tries-to-access-directly-from-the-url;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@dashboard"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "user access the URL \"https://www.perxtech.io/dashboard/p/rewards/edit/10900\" directly",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "user should be on login page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.perxtech.io/dashboard/p/rewards/edit/10900",
      "offset": 21
    }
  ],
  "location": "webAppglue.open_URL(String)"
});
formatter.result({
  "duration": 4882201355,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.verify_user_is_on_login_page()"
});
formatter.result({
  "duration": 62155599,
  "status": "passed"
});
formatter.after({
  "duration": 1757344161,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Creating a reward - Validate that non-authorized user should not have access to the reward detail/edit page if he tries to access directly from the URL",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-non-authorized-user-should-not-have-access-to-the-reward-detail/edit-page-if-he-tries-to-access-directly-from-the-url;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@dashboard"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "user access the URL \"https://www.perxtech.io/dashboard/p/rewards/create\" directly",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "user should be on login page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.perxtech.io/dashboard/p/rewards/create",
      "offset": 21
    }
  ],
  "location": "webAppglue.open_URL(String)"
});
formatter.result({
  "duration": 4755204075,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.verify_user_is_on_login_page()"
});
formatter.result({
  "duration": 86064913,
  "status": "passed"
});
formatter.after({
  "duration": 1597413684,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Creating a reward - Validate successfully creating a reward only after giving both start and end date",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-successfully-creating-a-reward-only-after-giving-both-start-and-end-date",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "Perx dashboard URL is launched",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "user logs in dashboard with \"shivani.gpt8@gmail.com\" and \"shi123456\"",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "user click on Create New button on rewards page",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "user should be on the page with title \"Reward Info\"",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "user enters reward name \"TestAutomationReward\" on the reward info page",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "user submits reward form without end date",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "\"Start date \u0026 end date required\" error is displayed on reward page",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "user should be on the page with title \"Reward Mechanics\"",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "user fills \"end date\"",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "remove the start date",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "click Next button on rewards page",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "\"Start date \u0026 end date required\" error is displayed on reward page",
  "keyword": "Then "
});
formatter.step({
  "line": 43,
  "name": "user should be on the page with title \"Reward Mechanics\"",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "user fills \"start date\"",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "click Next button on rewards page",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "user should be on the page with title \"Review\"",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "user launch the reward",
  "keyword": "When "
});
formatter.step({
  "line": 48,
  "name": "user navigates to \"rewards\" page",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "reward \"TestAutomationReward\" should be displayed in the rewards list",
  "keyword": "Then "
});
formatter.match({
  "location": "webAppglue.launch_web_app()"
});
formatter.result({
  "duration": 5129122187,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "shivani.gpt8@gmail.com",
      "offset": 29
    },
    {
      "val": "shi123456",
      "offset": 58
    }
  ],
  "location": "webAppglue.login(String,String)"
});
formatter.result({
  "duration": 1018086328,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.click_createBtn_on_rewardsPage()"
});
formatter.result({
  "duration": 2178366307,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Reward Info",
      "offset": 39
    }
  ],
  "location": "webAppglue.validate_user_on_page(String)"
});
formatter.result({
  "duration": 912917756,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestAutomationReward",
      "offset": 25
    }
  ],
  "location": "webAppglue.enter_reward_name(String)"
});
formatter.result({
  "duration": 1585471538,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.verify_error_on_submit_reward()"
});
formatter.result({
  "duration": 746353711,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Start date \u0026 end date required",
      "offset": 1
    }
  ],
  "location": "webAppglue.verify_error_on_reward_page(String)"
});
formatter.result({
  "duration": 57019723,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Reward Mechanics",
      "offset": 39
    }
  ],
  "location": "webAppglue.validate_user_on_page(String)"
});
formatter.result({
  "duration": 57848765,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "end date",
      "offset": 12
    }
  ],
  "location": "webAppglue.fill_date(String)"
});
formatter.result({
  "duration": 1005265915,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.remove_start_date()"
});
formatter.result({
  "duration": 193462997,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.click_next_btn()"
});
formatter.result({
  "duration": 73468477,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Start date \u0026 end date required",
      "offset": 1
    }
  ],
  "location": "webAppglue.verify_error_on_reward_page(String)"
});
formatter.result({
  "duration": 48426973,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Reward Mechanics",
      "offset": 39
    }
  ],
  "location": "webAppglue.validate_user_on_page(String)"
});
formatter.result({
  "duration": 58237237,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "start date",
      "offset": 12
    }
  ],
  "location": "webAppglue.fill_date(String)"
});
formatter.result({
  "duration": 935603812,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.click_next_btn()"
});
formatter.result({
  "duration": 326095794,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Review",
      "offset": 39
    }
  ],
  "location": "webAppglue.validate_user_on_page(String)"
});
formatter.result({
  "duration": 68460176,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.launch_reward()"
});
formatter.result({
  "duration": 289957186,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rewards",
      "offset": 19
    }
  ],
  "location": "webAppglue.navigate_to_page(String)"
});
formatter.result({
  "duration": 1087528966,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestAutomationReward",
      "offset": 8
    }
  ],
  "location": "webAppglue.verify_reward_in_list(String)"
});
formatter.result({
  "duration": 1183811896,
  "status": "passed"
});
formatter.after({
  "duration": 1780527395,
  "status": "passed"
});
formatter.scenario({
  "line": 51,
  "name": "Creating a reward - Validate that catalogues, labels, brands, tags and categories should disappaer for private reward",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;creating-a-reward---validate-that-catalogues,-labels,-brands,-tags-and-categories-should-disappaer-for-private-reward",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 52,
  "name": "Perx dashboard URL is launched",
  "keyword": "Given "
});
formatter.step({
  "line": 53,
  "name": "user logs in dashboard with \"shivani.gpt8@gmail.com\" and \"shi123456\"",
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "user click on Create New button on rewards page",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "user should be on the page with title \"Reward Info\"",
  "keyword": "Then "
});
formatter.step({
  "line": 56,
  "name": "user selects reward type as \"Private\"",
  "keyword": "When "
});
formatter.step({
  "line": 57,
  "name": "\"Catalogues\" label and input field should disappear",
  "keyword": "Then "
});
formatter.step({
  "line": 58,
  "name": "\"Brands\" label and input field should disappear",
  "keyword": "Then "
});
formatter.step({
  "line": 59,
  "name": "\"Tags\" label and input field should disappear",
  "keyword": "Then "
});
formatter.step({
  "line": 60,
  "name": "\"Categories\" label and input field should disappear",
  "keyword": "Then "
});
formatter.step({
  "line": 61,
  "name": "\"Labels\" label and input field should disappear",
  "keyword": "Then "
});
formatter.match({
  "location": "webAppglue.launch_web_app()"
});
formatter.result({
  "duration": 4682919475,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "shivani.gpt8@gmail.com",
      "offset": 29
    },
    {
      "val": "shi123456",
      "offset": 58
    }
  ],
  "location": "webAppglue.login(String,String)"
});
formatter.result({
  "duration": 827986265,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.click_createBtn_on_rewardsPage()"
});
formatter.result({
  "duration": 2397820452,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Reward Info",
      "offset": 39
    }
  ],
  "location": "webAppglue.validate_user_on_page(String)"
});
formatter.result({
  "duration": 1049916870,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Private",
      "offset": 29
    }
  ],
  "location": "webAppglue.select_reward(String)"
});
formatter.result({
  "duration": 280476734,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Catalogues",
      "offset": 1
    }
  ],
  "location": "webAppglue.verify_label_and_field_not_displayed(String)"
});
formatter.result({
  "duration": 115702042,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Brands",
      "offset": 1
    }
  ],
  "location": "webAppglue.verify_label_and_field_not_displayed(String)"
});
formatter.result({
  "duration": 72391665,
  "error_message": "java.lang.AssertionError: Label Brands is displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertFalse(Assert.java:64)\r\n\tat glue.webAppglue.verify_label_and_field_not_displayed(webAppglue.java:215)\r\n\tat ✽.Then \"Brands\" label and input field should disappear(features/DashboardTest.feature:58)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Tags",
      "offset": 1
    }
  ],
  "location": "webAppglue.verify_label_and_field_not_displayed(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Categories",
      "offset": 1
    }
  ],
  "location": "webAppglue.verify_label_and_field_not_displayed(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Labels",
      "offset": 1
    }
  ],
  "location": "webAppglue.verify_label_and_field_not_displayed(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 1897373524,
  "status": "passed"
});
formatter.scenario({
  "line": 63,
  "name": "Upload a file in bulk list - Validate that logged in used has sufficient permission to visit the bulk file upload page and has the ability to upload",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;upload-a-file-in-bulk-list---validate-that-logged-in-used-has-sufficient-permission-to-visit-the-bulk-file-upload-page-and-has-the-ability-to-upload",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 64,
  "name": "user logged in with \"admin@dashboard.com\" and \"admin1234\"",
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "verify that logged in user has sufficient permission to \"view\" \"bulk_actions\"",
  "keyword": "Then "
});
formatter.step({
  "line": 66,
  "name": "verify that logged in user has sufficient permission to \"edit\" \"bulk_actions\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "admin@dashboard.com",
      "offset": 21
    },
    {
      "val": "admin1234",
      "offset": 47
    }
  ],
  "location": "APIglue.get_user_session(String,String)"
});
formatter.result({
  "duration": 487611337,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "view",
      "offset": 57
    },
    {
      "val": "bulk_actions",
      "offset": 64
    }
  ],
  "location": "APIglue.check_user_authorization(String,String)"
});
formatter.result({
  "duration": 302542546,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "edit",
      "offset": 57
    },
    {
      "val": "bulk_actions",
      "offset": 64
    }
  ],
  "location": "APIglue.check_user_authorization(String,String)"
});
formatter.result({
  "duration": 297869800,
  "status": "passed"
});
formatter.after({
  "duration": 57840,
  "status": "passed"
});
formatter.scenario({
  "line": 68,
  "name": "Upload a file in bulk list - Validate that form upload should only accept from the accepted file list (.txt, .xlsx, .csv)",
  "description": "",
  "id": "this-feature-file-list-the-qa-interview-integration-test;upload-a-file-in-bulk-list---validate-that-form-upload-should-only-accept-from-the-accepted-file-list-(.txt,-.xlsx,-.csv)",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 69,
  "name": "Perx dashboard URL is launched",
  "keyword": "Given "
});
formatter.step({
  "line": 70,
  "name": "user logs in dashboard with \"admin@dashboard.com\" and \"admin1234\"",
  "keyword": "And "
});
formatter.step({
  "line": 71,
  "name": "user upload txt,csv or xlsx file and tie it to an action then file should get uploaded and the file list should reflect the uploaded file",
  "rows": [
    {
      "cells": [
        "FileName",
        "Action"
      ],
      "line": 72
    },
    {
      "cells": [
        "perxtxt",
        "Upload Users"
      ],
      "line": 73
    },
    {
      "cells": [
        "perxcsv",
        "Issue Vouchers"
      ],
      "line": 74
    },
    {
      "cells": [
        "perxexcel",
        "Upload Transactions"
      ],
      "line": 75
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 76,
  "name": "user upload tries to upload doc file then this unsupported file should not be shown in File Upload form",
  "rows": [
    {
      "cells": [
        "FileName"
      ],
      "line": 77
    },
    {
      "cells": [
        "testdoc"
      ],
      "line": 78
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "webAppglue.launch_web_app()"
});
formatter.result({
  "duration": 4685710160,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin@dashboard.com",
      "offset": 29
    },
    {
      "val": "admin1234",
      "offset": 55
    }
  ],
  "location": "webAppglue.login(String,String)"
});
formatter.result({
  "duration": 822417612,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.verify_file_is_uploaded(DataTable)"
});
formatter.result({
  "duration": 39521550789,
  "status": "passed"
});
formatter.match({
  "location": "webAppglue.verify_file_is_not_uploaded(DataTable)"
});
formatter.result({
  "duration": 14901255787,
  "status": "passed"
});
formatter.after({
  "duration": 1734909976,
  "status": "passed"
});
});