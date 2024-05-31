package todolist;

public class Task {
String title;
   
    String description;
    boolean completed;

    
    public Task(String title, String description) {
      this.title = title;
      this.description = description != null ? description : "";
      this.completed = false;
    }

    public String getTitle() {
      return title;
    }

   
    public String getDescription() {
      
      return description != null ? description : "";
    }
    public boolean isCompleted() {
      return completed;
    }
    public void markCompleted() {
      completed = true;
    }

}
//node class
class Node {
    
    Task task;
    Node next;
    
    public Node(Task task) {
      this.task = task;
      this.next = null;
    }
  }
//todolist class
class ToDoList {
    
    Node head;

    
    public ToDoList() {
      head = null;  
    }

    
    public void addToDo(Task task) {
      
      Node newNode = new Node(task);

      
      if (head == null) {
        head = newNode;
        return;
      }

      
      Node currentNode = head;
      while (currentNode.next != null) {
        currentNode = currentNode.next;
      }

      
      currentNode.next = newNode;
    }

    
    public void markToDoAsCompleted(String title) {
      
      Node currentNode = head;
      while (currentNode != null) {
        
        if (currentNode.task.getTitle().equals(title)) {
          currentNode.task.markCompleted();
          return;  
        }
        currentNode = currentNode.next;
      }
      
      System.out.println("Task not found!");
    }
  
    public void viewToDoList() {      
      if (head == null) {
        System.out.println("The to-do list is empty!");
        return;
      }

      
      int count = 1;
      Node currentNode = head;
      while (currentNode != null) {
        String completionStatus = currentNode.task.isCompleted() ? "Completed" : "Pending";
        System.out.println(count + ". " + currentNode.task.getTitle() + " (" + completionStatus + ")");
        if (currentNode.task.getDescription() != null && !currentNode.task.getDescription().isEmpty()) {
          System.out.println("\tDescription: " + currentNode.task.getDescription());
        }
        count++;
        currentNode = currentNode.next;
      }
    }
  }
class Main {
    public static void main(String[] args) {
      ToDoList toDoList = new ToDoList();

      toDoList.addToDo(new Task("Buy groceries", "Milk, bread, eggs"));
      toDoList.addToDo(new Task("Finish report", "Marketing analysis"));
      
}
}
