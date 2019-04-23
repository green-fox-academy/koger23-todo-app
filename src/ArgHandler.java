import java.util.Arrays;
import java.util.Collections;

public class ArgHandler {
  private static AccountHandler accountHandler = new AccountHandler();
  private static TaskList taskListObj = new TaskList(accountHandler);
  private static String REGEX = ",";

  public static void checkArgs(String[] args) {
    TerminalHandler.clearTerminal();
    Header.printHeader();
    switch (getArgs(args)) {
      case "-cu":
      case "--change-user":
        accountHandler.setActiveUser(Integer.valueOf(args[1]) - 1);
        break;
      case "-la":
      case "--listall":
        accountHandler.checkUserList();
        taskListObj.printList();
        break;
      case "-lu":
      case "--list-user":
        accountHandler.printUserList();
        break;
      case "-l":
      case "--list":
        accountHandler.checkUserList();
        taskListObj.printListUndoneOnly();
        break;
      case "-a":
      case "--add":
        accountHandler.checkUserList();
        argAddTask(args[1]);
        break;
      case "-au":
      case "--add-user":
        accountHandler.addUser(args[1]);
        break;
      case "-c":
      case "--check":
        accountHandler.checkUserList();
        argCheckTask(args[1]);
        break;
      case "-h":
      case "--help":
        Help.printHelp();
        break;
      case "-r":
      case "--remove":
        accountHandler.checkUserList();
        argRemoveTask(args[1]);
        break;
      case "-ru":
      case "--remove-user":
        argRemoveUser(args[1]);
        break;
      case "-rd":
      case "--removedone":
        accountHandler.checkUserList();
        argRemoveAllDoneTask();
        break;
      case "noArg":
        Help.printHelp();
        break;
      default:
        System.out.println("Unsupported argument");
        break;
    }
  }

  private static void argRemoveUser(String arg) {
    try {
      String[] args = arg.split(REGEX);
      Arrays.sort(args, Collections.reverseOrder());
      for (String i : args) {
        accountHandler.removeUser(Integer.valueOf(i) - 1);
      }
      accountHandler.printUserList();
    } catch (ArrayIndexOutOfBoundsException e) {
      msgNoIndexProvided();
    } catch (NumberFormatException e) {
      msgIndexIsNotAnumber();
    }
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
      taskListObj.printList();
    } catch (ArrayIndexOutOfBoundsException e) {
      msgNoIndexProvided();
    } catch (NumberFormatException e) {
      msgIndexIsNotAnumber();
    }
  }

  private static void argRemoveAllDoneTask() {
    try {
      taskListObj.removeDoneTasks();
      taskListObj.printList();
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
      taskListObj.printList();
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
      taskListObj.printList();
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
}
