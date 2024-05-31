package linkedlists;

class Node { 
  int data;
	  Node next;

	  Node(int data) {
	    this.data = data;
	    this.next = null;
	  }
	}

	class LinkedList {
	  Node head;

	  // 1. Inserting a node at any given position
	  public void insertAtPos(int data, int position) {
	    if (position < 1) {
	      System.out.println("Invalid position");
	      return;
	    }

	    Node newNode = new Node(data);
	    if (position == 1) {
	      newNode.next = head;
	      head = newNode;
	      return;
	    }

	    Node current = head;
	    int count = 1;
	    while (current != null && count < position - 1) {
	      current = current.next;
	      count++;
	    }

	    if (current == null) {
	      System.out.println("Invalid position");
	      return;
	    }

	    newNode.next = current.next;
	    current.next = newNode;
	  }

	  // 2. Deleting a node at any given position
	  public void deleteAtPosition(int position) {
	    if (position < 1) {
	      System.out.println("Invalid position");
	      return;
	    }

	    if (position == 1) {
	      head = head.next;
	      return;
	    }

	    Node current = head;
	    int count = 1;
	    while (current != null && count < position - 1) {
	      current = current.next;
	      count++;
	    }

	    if (current == null || current.next == null) {
	      System.out.println("Invalid position");
	      return;
	    }

	    current.next = current.next.next;
	  }

	  // 3. Deleting a node after a given node
	  public void deleteAfterNode(Node prevNode) {
	    if (prevNode == null || prevNode.next == null) {
	      System.out.println("No node to delete");
	      return;
	    }

	    prevNode.next = prevNode.next.next;
	  }

	  // 4. Searching a node in a singly linked list
	  public boolean searchNode(int data) {
	    Node current = head;
	    while (current != null) {
	      if (current.data == data) {
	        return true;
	      }
	      current = current.next;
	    }
	    return false;
	  }
	}

	class Stack {
	  Node top;

	  // Push operation
	  public void push(int data) {
	    Node newNode = new Node(data);
	    newNode.next = top;
	    top = newNode;
	  }

	  // Pop operation
	  public int pop() {
	    if (isEmpty()) {
	      System.out.println("Stack underflow");
	      return -1;
	    }
	    int data = top.data;
	    top = top.next;
	    return data;
	  }

	  // Peek operation
	  public int peek() {
	    if (isEmpty()) {
	      System.out.println("Stack is empty");
	      return -1;
	    }
	    return top.data;
	  }

	  // Check if stack is empty
	  public boolean isEmpty() {
	    return top == null;
	  }

}
