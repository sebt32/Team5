import java.util.List;

import java.util.ArrayList;



import javax.swing.event.ChangeEvent;




public class UndoB {

	

	//the current index node

	private Node currentIndex = null;

	//the parent node far left node.

	private Node parentNode = new Node();

	
	/**

	 * Creates a new UndoB object which is initially empty.

	 */

	

	public UndoB(){

		currentIndex = parentNode;

	}

	
	/**

	 * Creates a new UndoB which is a duplicate of the parameter in both contents and current index.

	 * @param manager

	 */

	

	public UndoB(UndoB manager){

		this();

		currentIndex = manager.currentIndex;

	}

	/**

	 * Clears all Changables contained in this manager.

	 */


	public void clear(){

		currentIndex = parentNode;

	}

	
	/**

	 * Adds a Undoable to manage.

	 * @param changeable 

	 */

	

	public void addUndoable(Undoable Undoable){

		Node node = new Node(Undoable);

		currentIndex.right = node;

		node.left = currentIndex;

		currentIndex = node;

	}

	

	/**

	 * Determines if an undo can be performed.

	 * @return

	 */


	public boolean canUndo(){

		return currentIndex != parentNode;

	}

	



	

	/**

	 * Undoes the Undoable at the current index. 

	 * @throws IllegalStateException if canUndo returns false. 

	 */


	

	public void undo(){

		//validate

		if ( !canUndo() ){

			throw new IllegalStateException("Cannot undo. Index is out of range.");

		}

		//undo

		currentIndex.Undoable.undo();

		//set index

		moveLeft();

	}

	
	/**

	 * Moves the internal pointer of the backed linked list to the left.

	 * @throws IllegalStateException If the left index is null.

	 */

	

	private void moveLeft(){

		if ( currentIndex.left == null ){

			throw new IllegalStateException("Internal index set to null.");

		}

		currentIndex = currentIndex.left;

	}

	
	/**

	 * Moves the internal pointer of the backed linked list to the right.

	 * @throws IllegalStateException If the right index is null.

	 */



	private void moveRight(){

		if ( currentIndex.right == null ){

			throw new IllegalStateException("Internal index set to null.");

		}

		currentIndex = currentIndex.right;

	}

	/**

	 * Inner class to implement a doubly linked list for the queue of Undoables. 

	 *
	 *

	 */


	private class Node {

		private Node left = null;

		private Node right = null;

		

		private final Undoable Undoable;

		

		public Node(Undoable c){

			Undoable = c;

		}

		

		public Node(){

			Undoable = null;

		}

	}

	

}
