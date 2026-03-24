Feature: Scenartio outline check

Scenario: validiting valid and invalid login
	Given user is on login page
	When user enter "<username>" and "<password>"
	Then verify error and success "<message>"
	
	Examples:
	|username | password 						 | message 									 |
	|tomsmith | SuperSecretPassword! | secure 									 |
	|tomsmith | SuperSecretPa 			 | Your password is invalid! |