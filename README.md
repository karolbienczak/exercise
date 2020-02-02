# exercise BDD scenario

Feaure: Create employee

Scenario: Create employee and check if it was done

Given: I am logged in to the API\
AND: I have prepared employee data\
WHEN: I send POST request to create new employee.\
AND: I send GET request to get created employee.\
THEN: I check if requests status are equal to 200.\
AND: I check responses datas.\
AND: I check if employee ID match.

## RUN

1. Pull project.
2. Use 'mvn clean test' command in project terminal.
