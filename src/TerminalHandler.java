import java.io.IOException;


public class TerminalHandler {
  private String osName;

  public TerminalHandler() {
    setOsName(System.getProperty("os.name"));
  }

  public String getOsName() {
    return osName;
  }

  public void setOsName(String osName) {
    this.osName = osName;
  }

  public static void clearTerminalWin() throws IOException, InterruptedException {
    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
  }

  public static void clearTerminalLinux() {
    System.out.print("\033\143");
  }

  public static void main(String[] args) {
    TerminalHandler terminalHandler = new TerminalHandler();
    System.out.println("Test");

    switch (terminalHandler.getOsName()){
      case "Windows":
        try {
          clearTerminalWin();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          break;
        }
      case "Linux":
        clearTerminalLinux();
        break;
    }
  }
}
