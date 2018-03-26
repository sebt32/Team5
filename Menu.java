/**
 * Menu class for controlling the program.
 * 
 * @author Josh Rivett
 * @version 1.0
 */
public class Menu {
	//Creates an instance of an employee.
	Employee employee = new Employee();
	
	/**
	 * Displays the menu options to the user.
	 */
	public static void displayMenu() {
		System.out.println("\nPlease select one of the options below.");
		System.out.println("\n1. Add Meeting");
		System.out.println("2. Edit Meeting");
		System.out.println("3. Delete Meeting");
		System.out.println("4. Search Meetings");
		System.out.println("5. Print Meetings");
		System.out.println("6. Undo Action");
		System.out.println("0. Exit Program");
		System.out.print("\nEnter menu option: ");
	}
	
	/**
	 * Processes a menu choice from the user.
	 */
	public void processMenuChoices() {
		//Initialises required variables
		int choice = 0;
		boolean exit = false;
		
		do {
			displayMenu();
			
			//Receives a menu choice from the user
			choice = Validation.validInt();
			
			//Validates whether the choice is a valid menu option
			while (choice < 0 || choice > 6) {
				System.out.print("Enter valid menu option: ");
				choice = Validation.validInt();
			}
				
			//Processes the user's menu input
			switch (choice) {
				case 1:
					employee.addMeeting();
					break;
				case 2:
					employee.editMeeting();
					break;
				case 3:
					employee.deleteMeeting();
					break;
				case 4:
					employee.searchMeeting();
					break;
				case 5:
					employee.printMeetings();
					break;
				case 6:
					employee.undo();
					break;
				case 0:
					System.out.println("\nGoodbye...");
					exit = true;
					break;
			}
		} while (exit == false);
	}
	
	/**
	 * Main method of the program.
	 * 
	 * @param args Standard main method arguments
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.processMenuChoices();
	}
}
