import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class UserFileHandler {
  private List<String> data;
  private static Path path;
  private String FILENAME = "users.csv";
  private File dataFile;

  public UserFileHandler() {
    this.path = Paths.get(FILENAME);
    this.dataFile = new File(FILENAME);
    createUserFile();
  }

  public void createUserFile(){
    if (dataFile.isFile()){
      try {
        this.data = Files.readAllLines(path);
      } catch (IOException e) {
        System.out.println("IO Error while reading userdata file.");
        e.printStackTrace();
      }
    } else {
      try {
        dataFile.createNewFile();
        this.data = Files.readAllLines(path);
      } catch (IOException e) {
        System.out.println("I/O Error while creating userdata file.");
        e.printStackTrace();
      }
    }
  }

  public static void saveDatas(List<String> taskList){
    try {
      Files.write(path, taskList);
    } catch (IOException e) {
      System.out.println("IO Error during saving file.");
      e.printStackTrace();
    }
  }

  public String getFILENAME() {
    return FILENAME;
  }

  public void setFILENAME(String FILENAME) {
    this.FILENAME = FILENAME;
  }

  public static Path getPath() {
    return path;
  }

  public static void setPath(Path path) {
    UserFileHandler.path = path;
  }

  public List<String> getData(){
    return data;
  }
}
