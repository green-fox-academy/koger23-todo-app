import java.util.Arrays;
import java.util.Collections;

public class ArgHandler {
  private static TaskList taskListObj = new TaskList();
  private static String REGEX = ",";

  public static void checkArgs(String[] args) {
    switch (getArgs(args)) {
      case "-la":
        taskListObj.printList();
        break;
      case "--listall":
        taskListObj.printList();
        break;
      case "-l":
        taskListObj.printListUndoneOnly();
        break;
       case "--list":
        taskListObj.printListUndoneOnly();
        break;
      case "-a":
        argAddTask(args[1]);
        break;
      case "--add":
        argAddTask(args[1]);
        break;
      case "-c":
        argCheckTask(args[1]);
        break;
      case "--check":
        argCheckTask(args[1]);
        break;
      case "-h":
        Help.printHelp();
        break;
      case "--help":
        Help.printHelp();
        break;
      case "-r":
        argRemoveTask(args[1]);
        break;
      case "--remove":
        argRemoveTask(args[1]);
        break;
      case "-rd":
        argRemoveAllDoneTask(args[1]);
        break;
      case "--removedone":
        argRemoveAllDoneTask(args[1]);
        break;
      case "noArg":
        printHeader();
        Help.printHelp();
        break;
      default:
        System.out.println("Unsupported argument");
        break;
    }
  }
  private static void printHeader() {
    System.out.println("Command Line Todo application");
    System.out.println("=============================\n");
  }

  private static String getArgs(String[] args){
    if (args.length > 0) {
     return args[0];
    } else if (args.length == 0){
      return "noArg";
    } else {
      return "unsupported";
    }
  }

  private static void argCheckTask(String arg) {
    try {
      String[] args = arg.split(REGEX);
      for (String i : args) {
        taskListObj.checkTask(Integer.valueOf(i) - 1);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      msgNoIndexProvided();
    } catch (NumberFormatException e) {
      msgIndexIsNotAnumber();
    }
  }

  private static void argRemoveAllDoneTask(String arg) {
    try {
      taskListObj.removeDoneTasks();
    } catch (ArrayIndexOutOfBoundsException e) {
      msgNoIndexProvided();
    } catch (NumberFormatException e) {
      msgIndexIsNotAnumber();
    }
  }

  private static void argRemoveTask(String arg) {
    try {
      String[] args = arg.split(REGEX);
      Arrays.sort(args, Collections.reverseOrder());
      for (String i : args) {
        taskListObj.removeTask(Integer.valueOf(i) - 1);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      msgNoIndexProvided();
    } catch (NumberFormatException e) {
      msgIndexIsNotAnumber();
    }
  }

  private static void argAddTask(String arg) {
    try {
      String[] args = arg.split(REGEX);
      for (String i : args) {
        taskListObj.addTask(i);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      msgNoIndexProvided();
      System.out.println("Example: Todo -a 'new task'\n");
      Help.printHelp();
    }
  }

  private static void msgIndexIsNotAnumber() {
    System.out.println("Unable to make action: index is not a number");
  }

  private static void msgNoIndexProvided() {
    System.out.println("Unable to make action: no task provided.\n");
  }

  private static void splitArgs(String[] args){

  }
}
