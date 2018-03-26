import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

/**
 * @author Sebastian Thomas
 */

public class Employee {
	private String forename;
	private String surname;
	private String password;
	private int id;
	private MeetingTree meetings = new MeetingTree();
	private Undo undo = new Undo();

	/**
	 * Method for adding new meetings to the meeting tree.
	 */
	public void addMeeting() {
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter the start date and start time of the meeting");
		System.out.println("Enter in the format: dd/mm/yy hh:mm");
		System.out.print("Start time: ");
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm");
	    Date startTime = null;
	    Date endTime = null;
	    String description;
		try 
		{
			startTime = dateFormat.parse(scr.nextLine());
	    } 
	    catch (ParseException e) 
	    {
	        e.printStackTrace();
	    }
		
		System.out.println("\nEnter the end date and end time of the meeting");
		System.out.println("Enter in the format: dd/mm/yy hh:mm");
		System.out.print("End time: ");
		try 
		{
			endTime = dateFormat.parse(scr.nextLine());
	    } 
	    catch (ParseException e) 
	    {
	        e.printStackTrace();
	    }
		System.out.println("\nEnter the description for the meeting");
		description = scr.nextLine();
		
		meetings.addToMeetingTree(meetings.getRoot(), startTime, endTime, description);
		//undo.addUndoable(Undoable);
	}
	
	/**
	 * Method to find a list of potential meeting dates based on given parameters.
	 */
	public void searchMeeting() 
	{
		Date startTime = null;
		
		Scanner s = new Scanner(System.in);
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		System.out.println("Enter the date and start time of the meeting you want to search");
		System.out.println("Enter in the format: dd/mm/yy hh:mm");
		System.out.print("Start time: ");
		
		try 
		{
			startTime = dateFormat.parse(s.nextLine());
	    } 
		
	    catch (ParseException e) 
	    {
	        e.printStackTrace();
	    }
		
		meetings.searchMeetingTree(startTime);
	}
	
	/**
	 * Method to edit an existing meeting.
	 */
	public void editMeeting() {
		
	}
	
	/**
	 * Method to delete a meeting.
	 */
	public void deleteMeeting() 
	{
		Date startTime = null;
		
		Scanner sc = new Scanner(System.in);
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		System.out.println("Enter the date and start time of the meeting you want to delete.");
		System.out.println("Enter in the format: dd/mm/yy hh:mm");
		System.out.print("Start time: ");
		try 
		{
			startTime = dateFormat.parse(sc.nextLine());
	    } 
	    catch (ParseException e) 
	    {
	        e.printStackTrace();
	    }
		
		
		meetings.deleteNode(startTime);
	}
	
	/**
	 * Method to undo the last add, edit, or delete action.
	 */
	public void undo() 
	{
		
	}
	
	/**
	 * Method to print the meetings of the employee to display.
	 */
	public void printMeetings() {
		meetings.printMeetingTree(meetings.getRoot());
	}
	
	/**
	 * Method to call the write to file method.
	 */
	public void writeToFile()
	{
		write(meetings.getRoot());
	}
	
	/**
	 * Method to write the employees meetings to a file.
	 * 
	 * @param currentNode
	 * @return
	 */
	public int write(Meeting currentNode) 
	{
		if (currentNode != null) 
		{
			FileOutputStream outputStream;
			PrintWriter printWriter;
			
			try 
			{
				outputStream = new FileOutputStream("aFile.txt");
				printWriter = new PrintWriter(outputStream);
				write(currentNode.getNextLeft());
				printWriter.println(currentNode + "," + currentNode.getStartTime() + "," + currentNode.getEndTime() + "," + currentNode.getDescription());
				write(currentNode.getNextRight());
			}
			
			catch (IOException e) 
			{
				System.out.println("Sorry, an error occurred..");
			}
		}
		return -1;
	}

	/**
	 * Method to read the employees meetings from a file.
	 */
	public void readFromFile()
	{
		  try 
		  {
			  Scanner file = new Scanner(new File("aFile.txt"));
			  while (file.hasNext())
			  {
				  String stringRead = file.nextLine();
				  Scanner parse = new Scanner(stringRead);
				  parse.useDelimiter(",");
				  
				  String dateString1 = parse.next();
				  DateFormat formatter = new SimpleDateFormat("dd/mm/yy hh:mm");
				  Date startTime = (Date)formatter.parse(dateString1);
				  
				  String dateString2 = parse.next();
				  Date endTime = (Date)formatter.parse(dateString2);
				  
				  String description = parse.next();
				  
				  try
				  {
					  meetings.addToMeetingTree(null, startTime, endTime, description);
					  System.out.println(startTime + " " + " " + endTime + " " + description);
				  }
				  
				  catch(InputMismatchException ime)
				  {
					  System.out.println("Error in meeting record: "+ stringRead + "; record ignored");
				  }
			  }
			  file.close();
		  }
		  
		  catch(FileNotFoundException fnfe)
		  {
			  System.out.println("Unable to find aFile.txt");
		  }
		  
		  catch(Exception ioe)
		  {
			  ioe.printStackTrace();
		  }
	}
}