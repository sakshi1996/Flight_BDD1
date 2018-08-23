Feature: To test Flight Application

@Registration
Scenario: To validate Registration page
Given Registration page should be available
When Validate registration page
Then Registration should be successful

@login
Scenario: To validate login page
Given Login page should be available
When Validate login page
Then Login should be successful