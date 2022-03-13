
 Feature: loginfeatures

  Scenario Outline: Agile login
    Given User is in login page
    When title of the page is Agile-AH
    Then user enters the "<username>" and "<password>"
    And click on the login button
    And user is on the Home page
    And find all the broken links
    And find the word assessments
   
    Examples: 
    | username | password |
    | kkalpana55@gmail.com |temp1234 |
