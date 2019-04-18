public class Todo {


  private static TaskList taskListObj = new TaskList();

  public Todo() {

  }

  public static void main(String[] args) {

    if (args.length == 0) {
      System.out.println("Command Line Todo application");
      System.out.println("=============================\n");
      printHelp();

    } else if (args[0].equals("-l")) {
      taskListObj.printList();

    } else if (args[0].equals("-a")) {

      try {
        taskListObj.addTask(args[1]);

      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Unable to add: no task provided.\n");
        System.out.println("Example: Todo -a 'new task'\n");
        printHelp();
      }

    } else if (args[0].equals("-r")) {
      try {
        taskListObj.removeTask(Integer.valueOf(args[1]) - 1);

      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Unable to remove: no index provided.\n");
      } catch (NumberFormatException e) {
        System.out.println("Unable to remove: index is not a number");
      }
    } else if (args[0].equals("-c")) {
      try {
        taskListObj.checkTask(Integer.valueOf(args[1]) - 1);

      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Unable to remove: no index provided.\n");
      } catch (NumberFormatException e) {
        System.out.println("Unable to remove: index is not a number");
      }
    }  else {
      System.out.println("Unsupported argument");
    }
  }

  public static void printHelp() {
    System.out.println("Command line arguments:");
    System.out.println("-l   Lists all the tasks");
    System.out.println("-a   Adds a new task");
    System.out.println("-r   Removes an task");
    System.out.println("-c   Completes an task");
  }
}

