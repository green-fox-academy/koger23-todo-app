public class ArgHandler {

  public static void checkArgs(String[] args) {
    TaskList taskListObj = new TaskList();
    if (args.length == 0) {
      System.out.println("Command Line Todo application");
      System.out.println("=============================\n");
      Help.printHelp();
    } else if (args[0].equals("-la")) {
      taskListObj.printList();
    } else if (args[0].equals("-l")) {
      taskListObj.printListUndoneOnly();
    } else if (args[0].equals("-a")) {
      try {
        taskListObj.addTask(args[1]);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Unable to add: no task provided.\n");
        System.out.println("Example: Todo -a 'new task'\n");
        Help.printHelp();
      }
    } else if (args[0].equals("-r")) {
      try {
        taskListObj.removeTask(Integer.valueOf(args[1]) - 1);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Unable to remove: no index provided.\n");
      } catch (NumberFormatException e) {
        System.out.println("Unable to remove: index is not a number");
      }
    } else if (args[0].equals("-ru")) {
      try {
        taskListObj.removeDoneTasks();
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
    } else {
      System.out.println("Unsupported argument");
    }
  }
}
