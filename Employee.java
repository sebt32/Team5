import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileOutputStream;

/**
 * 
 */

/**
 * @author Sebastian Thomas
 *
 */
public class Employee {
	private String forename;
	private String surname;
	private String password;
	private int id;
	
	public void addMeeting()
	{
		MeetingTree tree = new MeetingTree();
		tree.addToTree();
	}
	
	public void editMeeting()
	{
		MeetingTree tree = new MeetingTree();
		tree.editNode();
	}
	
	public void deleteMeeting()
	{
		MeetingTree tree = new MeetingTree();
		tree.deleteMeeting();
	}
	
	public void undo()
	{
		
	}
	
	public void writeToFile()
	{
		
		if(root != null)
		{
			MeetingTree current;
			FileOutputStream outputStream;
			PrintWriter printWriter;
			try
			{
				current = root;
				outputStream = new FileOutputStream("aFile.txt");
				printWriter = new PrintWriter(outputStream); 
				printWriter.println(current.getData());
				
				while(current != null)
				{
					printWriter.println(current);
					if(current.getLeft() != null) 
					{
						current = current.getLeft();
						printWriter.println(current.getData());
					}
					else if(current.getRight() != null) 
					{
						current = current.getRight();
						printWriter.println(current.getData());
					}
					else
					{
						break;
					}
				}
					printWriter.close();
			}
			catch(IOException e)
			{
				System.out.println("Sorry, an error occurred..");
			}
		}
		
	}
	
	public MeetingTree readFromFile()
	{
		FileReader fileReader;
		BufferedReader bufferedReader;
		String nextLine;
		MeetingTree newNode;
		MeetingTree current, previous;
		try 
		{
			fileReader = new FileReader("lotteryNumbers.txt");
			bufferedReader = new BufferedReader(fileReader);
			nextLine = bufferedReader.readLine();
			String[] temp = nextLine.split(" ");
			while (nextLine != null)
			{
				if(root == null)
				{
					root = nextLine;
					newNode = root;
				}
				else if(nextLine > previous)
				{
					
				}
			bufferedReader.close();
			}
		}
		catch(IOException e)
		{
			System.out.println("Sorry, an error occurred..");
		}
	}
}

