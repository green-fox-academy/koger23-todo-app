public class Help {
  public static void printHelp() {
    System.out.println("Command line arguments:");
    System.out.println("-l,  --list        Lists all unchecked tasks");
    System.out.println("-la, --listall     Lists all the tasks");
    System.out.println("-a,  --add         Adds a new task");
    System.out.println("-r,  --remove      Removes a task by index");
    System.out.println("-rd, --removedone  Remove all done task");
    System.out.println("-c,  --check       Completes an task");
  }
}
