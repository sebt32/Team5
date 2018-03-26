/**
 * Class to implement a doubly linked list for the queue of Undoables. 
 *
 */
public class UndoNode {

	private UndoNode left = null;
	private UndoNode right = null;	
	private Meeting data;
	private final Undoable Undoable;

	public UndoNode(Undoable c){
		Undoable = c;
	}
	
	public UndoNode(){
		Undoable = null;
	}

	public UndoNode getLeft() {
		return left;
	}

	public void setLeft(UndoNode left) {
		this.left = left;
	}

	public UndoNode getRight() {
		return right;
	}

	public void setRight(UndoNode right) {
		this.right = right;
	}

	public Undoable getUndoable() {
		return Undoable;
	}	
}