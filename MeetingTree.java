import java.util.Date;

/**
 * Class for creating and manipulating a binary tree of meetings.
 * 
 * @author Josh Rivett
 * @version 1.0
 */
public class MeetingTree {
	private Meeting root; //Holds the object reference for the first node in the MeetingTree.

    /**
     * Initialises fields if no parameters are given.
     */
    public MeetingTree()
    {
        //Sets the root of the MeetingTree to null, and by extension, sets the MeetingTree as empty.
        root = null;
    }

    /**
     * Get the MeetingTree node which is at the 'root' of the MeetingTree
     * 
     * @return A reference to a Meeting object which represents the node at the root of the MeetingTree.
     */
    public Meeting getRoot()
    {
        return root;
    }

    /**
     * Set the root of the list to the given node.
     * 
     * @param  newRoot A reference to a Meeting object which will be the root of the MeetingTree. 
     */
    public void setRoot(Meeting newRoot)
    {
        root = newRoot;
    }

    /**
     * Adds a new node to the MeetingTree with the data given.
     * 
     * @param currentNode Current node of the MeetingTree.
     * @param startTime The new start time to be added to the MeetingTree.
     * @param endTime The new end time to be added to the MeetingTree.
     * @param description The new description to be added to the MeetingTree.
     * @return True if adding the meeting was successful, false otherwise.
     */
    public boolean addToMeetingTree(Meeting currentNode, Date startTime, Date endTime, String description) {
    	//Variable to keep track of whether the student was successfully added.
    	boolean successful = true;
    	
        //Makes sure there is already a root and if not, sets the new node as the root.
    	if (root == null) {
            root = new Meeting(startTime, endTime, description);
        } else {
        	//Gets the studentID of the current node.
        	Date currentTime = currentNode.getStartTime();
        	
        	//Determines whether the new meeting time is later or earlier than the current node.
        	if (startTime.before(currentTime)) {
        		//Checks if there is already a left node and if not, sets the new node to it.
        		if (currentNode.getNextLeft() != null) {
        			//Recursively calls the function.
        			addToMeetingTree(currentNode.getNextLeft(), startTime, endTime, description);
        		} else {
        			Meeting nextLeft = new Meeting(startTime, endTime, description);
        			currentNode.setNextLeft(nextLeft);
        			successful = true;
        		}
        	} else if (startTime.after(currentTime)) {
        		//Checks if there is already a right node and if not, sets the new node to it.
        		if (currentNode.getNextRight() != null) {
        			addToMeetingTree(currentNode.getNextRight(), startTime, endTime, description);
        		} else {
        			Meeting nextRight = new Meeting(startTime, endTime, description);
        			//Recursively calls the function.
        			currentNode.setNextRight(nextRight);
        			successful = true;
        		}
        	} else {
        		//Displays an error message as the studentID specified already exists.
        		System.out.println("\nError: Student with specified ID already exists.");
        		successful = false;
        	}
        }
    	
    	//Returns whether the student was added successfully or not.
    	return successful;
    }
    
    /**
     * Searches the MeetingTree for a specified node.
     * 
     * @param searchTime The start time being searched for.
     * @return The reference of the node that matches the start time or null if not found.
     */
    public Meeting searchMeetingTree(Date searchTime) {
    	//Initialises the required variables.
    	Meeting currentNode = root;
    	Date currentStartTime;
    	boolean found = false;
    	
    	//Loops until the time is found or the end of the MeetingTree is reached.
    	while (currentNode != null && !found) {
    		currentStartTime = currentNode.getStartTime();
    		
    		//Checks if the current time is the time being searched for.
    		if (searchTime == currentStartTime) {
    			found = true;
    		} else {
    			//Checks if the search time would be to the left or right of the current time.
    			if (searchTime.before(currentStartTime)) {
    				currentNode = currentNode.getNextLeft();
    			} else if (searchTime.after(currentStartTime)) {
    				currentNode = currentNode.getNextRight();
    			}
    		}
    	}
    	
    	//Returns the node of the time being searched for or null if it was not found.
    	if (found) {
    		return currentNode;
    	} else {
    		return null;
    	}
    }
    
    /**
     * Deletes a specified node from the MeetingTree.
     * 
     * @param searchTime Start time of the node to be deleted.
     * @return True if the node was deleted and false if not.
     */
    public boolean deleteNode(Date searchTime) {
    	//Initialises the required variables.
    	Meeting previousNode = null;
    	Meeting currentNode = root;
    	String side = "";
    	Date currentTime;
    	boolean found = false;
    	boolean deleted = false;
    	
    	//Loops until the time is found or the end of the MeetingTree is reached.
    	while (currentNode != null && !found) {
    		currentTime = currentNode.getStartTime();
    		
    		//Checks if the current time is the time being searched for.
    		if (searchTime == currentTime) {
    			found = true;
    		} else {
    			//Checks if the search time would be to the left or right of the current time.
    			if (searchTime.before(currentTime)) {
    				previousNode = currentNode;
    				side = "left";
    				currentNode = currentNode.getNextLeft();
    			} else if (searchTime.after(currentTime)) {
    				previousNode = currentNode;
    				side = "right";
    				currentNode = currentNode.getNextRight();
    			}
    		}
    	}
    	
    	//Returns the node of the time being searched for or null if it was not found.
    	if (found) {
    		//Checks if the node to be deleted was on the left or right of the previous node.
    		if (side.equals("left")) {
    			//Checks if both of the left and right pointers are null
    			if (currentNode.getNextLeft() == null && currentNode.getNextRight() == null) {
    				previousNode.setNextLeft(null);
    			//Checks if just the right pointer is null.
        		} else if (currentNode.getNextLeft() != null && currentNode.getNextRight() == null) {
        			previousNode.setNextLeft(currentNode.getNextLeft());
    			//Checks if just the left pointer is null.
	    		} else if (currentNode.getNextLeft() == null && currentNode.getNextRight() != null) {
	    			previousNode.setNextLeft(currentNode.getNextRight());
    			//Checks if both the left and right pointers are not null
	    		} else if (currentNode.getNextLeft() != null && currentNode.getNextRight() != null) {
	    			
	    		}
    			deleted = true;
			} else if (side.equals("right")) {
				//Checks if both of the left and right pointers are null
    			if (currentNode.getNextLeft() == null && currentNode.getNextRight() == null) {
    				previousNode.setNextRight(null);
    			//Checks if just the right pointer is null.
        		} else if (currentNode.getNextLeft() != null && currentNode.getNextRight() == null) {
        			previousNode.setNextRight(currentNode.getNextLeft());
    			//Checks if just the left pointer is null.
	    		} else if (currentNode.getNextLeft() == null && currentNode.getNextRight() != null) {
	    			previousNode.setNextRight(currentNode.getNextRight());
	    		//Checks if both the left and right pointers are not null
	    		} else if (currentNode.getNextLeft() != null && currentNode.getNextRight() != null) {
	    			
	    		}
    			deleted = true;
    		} else {
				root = null;
				deleted = true;
			}
    	} else {
    		System.out.println("Error: The student to be deleted could not be found.");
    		deleted = false;
    	}
		return deleted;
    }
    
    /**
     * Prints the contents of the MeetingTree.
     * 
     * @param currentNode The node currently being traversed.
     */
    public void printMeetingTree(Meeting currentNode) {
    	//Checks the current node is not null.
    	if (currentNode != null) {
    		//Recursively calls the function to check the left branch, prints its own contents, then checks the right branch.
    		printMeetingTree(currentNode.getNextLeft());
    		System.out.println("Start Time: " + currentNode.getStartTime() + ", End Time: " + currentNode.getEndTime() + ", Description: " + currentNode.getDescription());
    		printMeetingTree(currentNode.getNextRight());
    	}
    }
}
