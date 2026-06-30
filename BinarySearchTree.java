package assign08;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class creates a Binary Search Tree Data Type Makes a tree out of nodes
 * each with up to two children Each child has a left and right side
 * 
 * @author Cameron McKay and Daler Turyssov
 * @version 2025-06-22
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	Node<Type> head;
	int size;

	public BinarySearchTree() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public Iterator<Type> iterator() {
		return new BinarySearchTreeIterator();
	}

	@Override
	public boolean add(Type item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Type item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Type item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type first() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type last() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	/**
	 * Creats a DOT representation of the BST
	 * 
	 * @return - A string DOT representation of a Binary Search Tree
	 */
	public String generateDOT() {
		return null;
	}

	/**
	 * Private Helper method for BinarySearchTree
	 * 
	 * Gets the left most child of a BST (smallest value)
	 * 
	 * @return - The smallest value in a BST
	 */
	private Node<Type> getLeftMost(Node<Type> head) {
		if (head.leftChild != null) {
			return this.getLeftMost(head.leftChild);
		}
		return head;
	}

	/**
	 * Private Helper method for BinarySearchTree
	 * 
	 * Get the successor node. The successor is the leftmost Node of the right
	 * subtree. If there is no successor, goes through parents until found. Returns
	 * null if no successor exists.
	 * 
	 * @return the successor node
	 */
	private Node<Type> successor(Node<Type> original) {
		if (original.rightChild == null) {
			return null;
		}

		while (original == original.getParent().getRightChild()) {
			Node<Type> parent = original.getParent();
			original.getParent();
			parent = parent.getParent();
		}

		if (original.rightChild.getLeftChild() == null) {
			return original.rightChild;
		}

		return this.getLeftMost(original);

	}

	/**
	 * Private Helper method for BinarySearchTree
	 * 
	 * Removes a node from the BST. Changes BST to fit the newly removed node.
	 * 
	 * @param toRemove - Node to be removed from BST
	 */
	private void removeNode(Node<Type> toRemove) {
		Node<Type>data = null;
		if( toRemove.getLeftChild() !=null && toRemove.getRightChild() !=null) {
			data.setParent(toRemove.getParent());
		}
		if (toRemove.getLeftChild() == null && toRemove.getRightChild() == null) {
			if (toRemove.getParent().getLeftChild() == toRemove) {
				toRemove.getParent().getLeftChild().setLeftChild(null);
			} else {
				toRemove.getParent().getRightChild().setRightChild(null);
			}
		}
	}

	/**
	 * Creates an Iterator for Singly BST Has functions for hasNext, next, and
	 * remove
	 * 
	 */
	private class BinarySearchTreeIterator implements Iterator<Type> {
		private Node<Type> nextNode;
		private Node<Type> lastReturned;
		private boolean isNext = false;

		/**
		 * Generates the BinarySearchTreeIterator Object
		 */
		public BinarySearchTreeIterator() {
			if (head != null) {
				nextNode = getLeftMost(head);
			}
		}

		/**
		 * Checks if the next node is null (end of list)
		 */
		@Override
		public boolean hasNext() {
			return (nextNode != null);

		}

		/**
		 * Returns the value of the next node
		 */
		@Override
		public Type next() {
			Type data = nextNode.getData();
			return data;

		}

		/**
		 * Removes the last element returned from next
		 */
		@Override
		public void remove() {
			
			if( lastReturned.getLeftChild() !=null && lastReturned.getRightChild() !=null) {
		Node<Type> current = nextNode;
		Node<Type>  successor = current.successor();
		
		
		}

	}

	// Handles Nodes //////////////////////////////////////////////////////////

	/**
	 * Creates the nodes inside the BST
	 * 
	 */
	private static class Node<Type> {
		private Type data;
		private Node<Type> leftChild;
		private Node<Type> rightChild;
		private Node<Type> parent;

		/**
		 * Creates the node with data.
		 * 
		 * Both children and parent start out being null.
		 * 
		 * @param data - data held by the node
		 */
		public Node(Type data) {
			this.data = data;
		}

		/**
		 * Sets the left child node in the BST
		 * 
		 * @param child - the new left child
		 */
		public void setLeftChild(Node<Type> child) {
			this.leftChild = child;
		}

		/**
		 * Sets the right child node in the BST
		 * 
		 * @param child - the new right child
		 */
		public void setRightChild(Node<Type> child) {
			this.rightChild = child;
		}

		/**
		 * Sets the parent node in the BST
		 * 
		 * @param parent - the new parent
		 */
		public void setParent(Node<Type> parent) {
			this.parent = parent;
		}

		/**
		 * Returns the left child node in the BST
		 * 
		 * @return the left child node in the BST
		 */
		public Node<Type> getLeftChild() {
			return this.leftChild;
		}

		/**
		 * Returns the right child node in the BST
		 * 
		 * @return the right child node in the BST
		 */
		public Node<Type> getRightChild() {
			return this.rightChild;
		}

		/**
		 * Returns the parent node in the BST
		 * 
		 * @return the parent node in the BST
		 */
		public Node<Type> getParent() {
			return this.parent;
		}

		/**
		 * Returns the data from the Node
		 * 
		 * @return the data from the Node
		 */
		public Type getData() {
			return this.data;
		}
	}
}