import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class UserFileHandler {
  private static Path path;

  public static void saveDatas(List<String> taskList){
    try {
      Files.write(path, taskList);
    } catch (IOException e) {
      System.out.println("Error during saving file.");
      e.printStackTrace();
    }
  }

  public static Path getPath() {
    return path;
  }

  public static void setPath(Path path) {
    UserFileHandler.path = path;
  }
}
