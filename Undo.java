/**
 *
 */
public class Undo {
			//the current index node

			private UndoNode currentIndex = null;

			//the parent node far left node.

			private UndoNode parentNode = new UndoNode();

			
			/**
			 * Creates a new Undo object which is initially empty.
			 */
			public Undo(){

				currentIndex = parentNode;

			}

			
			/**
			 * Creates a new UndoB which is a duplicate of the parameter in both contents and current index.
			 * @param manager
			 */

			

			public Undo(Undo manager){

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

				UndoNode node = new UndoNode(Undoable);

				currentIndex.setRight(node);

				node.setRight(currentIndex);

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

				currentIndex.getUndoable().undo();

				//set index

				moveLeft();

			}

			
			/**
			 * Moves the internal pointer of the backed linked list to the left.
			 * @throws IllegalStateException If the left index is null.
			 */

			

			private void moveLeft(){

				if ( currentIndex.getLeft() == null ){

					throw new IllegalStateException("Internal index set to null.");

				}

				currentIndex = currentIndex.getLeft();

			}
			
			/**
			 * Moves the internal pointer of the backed linked list to the right.
			 * @throws IllegalStateException If the right index is null.
			 */
			private void moveRight(){

				if ( currentIndex.getRight() == null ){

					throw new IllegalStateException("Internal index set to null.");

				}

				currentIndex = currentIndex.getRight();

			}
		}