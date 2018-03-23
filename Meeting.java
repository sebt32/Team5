import java.util.Date;

/**
 * Class which represents a meeting.
 * 
 * @author Josh Rivett
 * @version 1.0
 */
public class Meeting {
	//Fields for the data being stored in each node of the list.
    private Date startTime;
    private Date endTime;
    private String description;
    private Meeting leftNode;
    private Meeting rightNode;

    /**
     * Initialises fields if no parameters are given.
     */
    public Meeting()
    {
        //Sets the fields to default values.
        startTime = new Date();
        endTime = new Date();
        description = new String();

        //Sets next left and right node to null as there are no next nodes yet.
        leftNode = null;
        rightNode = null;
    }

    /**
     * Initialises fields to the parameters provided.
     * 
     * @param newStart The start date/time of the new meeting.
     * @param newEnd The end date/time of the new meeting.
     * @param newDescription The description of the new meeting.
     */
    public Meeting(Date newStart, Date newEnd, String newDescription)
    {
        //Sets the fields to the specified parameters.
        startTime = newStart;
        endTime = newEnd;
        description = newDescription;

        //Sets next left and right nodes to null as there are no next nodes yet.
        leftNode = null;
        rightNode = null;
    }

    /**
     * Returns the startTime field.
     * 
     * @return Date containing the meeting's start date/time.
     */
    public Date getStartTime() {
    	return startTime;
    }
    
    /**
     * Returns the endTime field.
     * 
     * @return Date containing the meeting's end date/time.
     */
    public Date getEndTime() {
    	return endTime;
    }
    
    /**
     * Returns the description field.
     * 
     * @return String containing the meeting's description.
     */
    public String getDescription() {
    	return description;
    }

    /**
     * Get the next left node in the tree.
     * 
     * @return The object reference of the next left node (or null if there is no next left node).
     */
    public Meeting getNextLeft()
    {
    	return leftNode;
    }
    
    /**
     * Get the next right node in the tree.
     * 
     * @return The object reference of the next right node (or null if there is no next right node).
     */
    public Meeting getNextRight()
    {
    	return rightNode;
    }

    /**
     * Set the next left node in the tree.
     * 
     * @param nextLeft A reference to a Meeting object which represents the next left node in the tree.
     */
    public void setNextLeft(Meeting nextLeft)
    {
    	leftNode = nextLeft;
    }
    
    /**
     * Set the next right node in the tree.
     * 
     * @param nextRight A reference to a Meeting object which represents the next right node in the tree.
     */
    public void setNextRight(Meeting nextRight)
    {
    	rightNode = nextRight;
    }
}
