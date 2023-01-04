Feature: validating place API's
@AddPlace
  Scenario Outline: Verify that the place is added succesfully
    Given add place payload "<name>","<language>","<address>" 
    When user calls the "addPlaceAPI" with "POST" http request
    Then verify the API call got success with status code 200
    And "status" in the response body shows "OK"
    And "scope" in the response body shows "APP"
 
    
    Examples:
|name			|language		|address|
|AA House |English		|Wilmont court|   
#|BB House	|French			|Town Cres| 


@DeletePlace 
Scenario: Verify that the place is deleted succesfully

Given delete place payload
When user calls the "deletePlaceAPI" with "POST" http request
Then verify the API call got success with status code 200
And "status" in the response body shows "OK"