Feature: Pet Clinic

	Background: To launch the browser
		Given Launch the browser
		
	Scenario Outline: Find Owner
		When Hit pet clinic on the browser
		Then navigate to find owner 
		And send keys <lastName> to search box
		And Search it <firstName> <lastName> <address> <city> <phone>
		
	Examples:
	| firstName | lastName | address | city | phone |
	| Frank | Herberte | Dune | Arrakis | 123456 |
	| Victor | Hugos | Winstonst. | London | 147852 |
	| Christian | Bales | Times | Newyork | 789632 |
	| Christiano | Ronaldo | Times | NewYork | 789632 |

	