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

	public void addMeeting() 
	{
		MeetingTree tree = new MeetingTree();
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter the start date and start time of the meeting");
		System.out.println("Enter in the format: dd/mm/yy hh:mm");
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
		
		System.out.println("Enter the end date and end time of the meeting");
		System.out.println("Enter in the format: dd/mm/yy hh:mm");
		try 
		{
			endTime = dateFormat.parse(scr.nextLine());
	    } 
	    catch (ParseException e) 
	    {
	        e.printStackTrace();
	    }
		System.out.println("Enter the description for the meeting");
		description = scr.nextLine();
		
		tree.addToMeetingTree(null, startTime, endTime, description);
	}

	public void searchMeeting() 
	{
		Date startTime = null;
		
		Scanner s = new Scanner(System.in);
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		System.out.println("Enter the date and start time of the meeting you want to delete");
		System.out.println("Enter in the format: dd/mm/yy hh:mm");
		
		try 
		{
			startTime = dateFormat.parse(s.nextLine());
	    } 
		
	    catch (ParseException e) 
	    {
	        e.printStackTrace();
	    }
		
		MeetingTree tree = new MeetingTree();
		tree.searchMeetingTree(startTime);
	}
	
	public void showAll()
	{
		Meeting currentNode;
		MeetingTree mt = new MeetingTree();
		currentNode = mt.getRoot();
		mt.printMeetingTree(currentNode);
	}

	public void deleteMeeting() 
	{
		Date startTime = null;
		
		Scanner sc = new Scanner(System.in);
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		System.out.println("Enter the date and start time of the meeting you want to delete");
		System.out.println("Enter in the format: dd/mm/yy hh:mm");
		try 
		{
			startTime = dateFormat.parse(sc.nextLine());
	    } 
	    catch (ParseException e) 
	    {
	        e.printStackTrace();
	    }
		
		MeetingTree tree = new MeetingTree();
		tree.deleteNode(startTime);
	}

	public void undo() 
	{
		
	}
	public void writeToFile()
	{
		Meeting currentNode;
		MeetingTree r = new MeetingTree();
		currentNode = r.getRoot();
		write(currentNode);
	}
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
					  MeetingTree mtTemp = new MeetingTree();
					  mtTemp.addToMeetingTree(null, startTime, endTime, description);
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
