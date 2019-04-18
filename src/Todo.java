public class Todo {


  private static TaskList taskListObj = new TaskList();

  public Todo() {

  }

  public static void main(String[] args) {

    if (args.length == 0) {
      System.out.println("Command Line Todo application");
      System.out.println("=============================\n");
      System.out.println("Command line arguments:");
      System.out.println("-l   Lists all the tasks");
      System.out.println("-a   Adds a new task");
      System.out.println("-r   Removes an task");
      System.out.println("-c   Completes an task");

    } else if (args[0].equals("-l")) {
      taskListObj.printList();
    }
  }
}

