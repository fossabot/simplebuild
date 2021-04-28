Feature: Application is correctly initialized

  Scenario: Set Application title
    When I start the application with "Test1"
    Then title is "Default Application Title"

  Scenario: Set Application version
    When I start the application with hard coded args
    Then commercial version is "1.0.0"

  Scenario: Application arguments are good
    When I start the application with "Test1,Test2,Test3"
    Then argument list has 3 elements
    And argument 1 is "Test1"
    And argument 2 is "Test2"
    And argument 3 is "Test3"

  Scenario: Create Application with a define viewport
    When I start the application with width=320 and height=200
    Then the application is started
    And viewport is created
    And width is 320
    And height is 200

  Scenario: Create Application viewport from viewport argument
    When I start the application with "viewport=640x400"
    Then the application is started
    And viewport is created
    And width is 640
    And height is 400

  Scenario: Create application with default viewport size
    When I start the application without argument
    Then the application is started
    And viewport is created
    And width is 320
    And height is 200
