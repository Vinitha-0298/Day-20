Feature: User Login
   Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters "<username>" and "<password>" 
    And clicks the Login button
    Then the user should be redirected to Products page

  Examples:
      | username | password  |
        | standard_user | secret_sauce |
        | problem_user  | secret_sauce |
        | performance_glitch_user | secret_sauce |
        
 Scenario Outline: Unsuccessful login with invalid credentials
     Given the user is on the login page
     When the user enters "<username>" and "<password>" 
     And clicks the Login button
     Then an error message "<error_message>" should be displayed
     
      Examples:
        | username        | password      | error_message                                                                  |
        | locked_out_user | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                            |
        | invalid_user    | wrong_pass    | Epic sadface: Username and password do not match any user in this service      |
        |                 | secret_sauce  | Epic sadface: Username is required                                             |
        | standard_user   |               | Epic sadface: Password is required                                             |