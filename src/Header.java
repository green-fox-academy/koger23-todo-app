public class Header {
  public static void printHeader(String[] args, AccountManager accountManager) {
    System.out.println("Command Line Todo Application");
    System.out.println("=============================");
    if (args.length > 0){
      try {
        if ((!args[0].equals("--help")) && (!args[0].equals("-h") && (!args[0].equals("-cu")) && (!args[0].equals("--change-user")))) {
          System.out.println("Logged in as: " + accountManager.getActiveUser().getUserName() + "\n");
        }
      } catch (NullPointerException e) {
        System.out.println("No user selected. Select one:\n(See -h, --help)\n");
        accountManager.printUserList();
        System.exit(1);
      }
    }
  }
}
