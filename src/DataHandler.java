import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataHandler {
  private List<String> data;
  private Path path;
  private String fileName;
  private AccountHandler accountHandler;
  private File dataFile;

  public DataHandler(AccountHandler accountHandler) {
    this.accountHandler = accountHandler;
    if (this.accountHandler.getActiveUser() != null){
      this.fileName = accountHandler.getActiveUser().getTaskFile();
      this.path = Paths.get(accountHandler.getActiveUser().getTaskFile());
      dataFile = new File(this.fileName);
      createTaskFile(accountHandler.getActiveUser());
    }
  }

  public void removeTaskFile(User user){
    dataFile = new File(user.getTaskFile());
    if (dataFile.delete()){
      System.out.println("Userdata deleted successfully");
    }
  }

  public void createTaskFile(User user){
    path = Paths.get(user.getTaskFile());
    dataFile = new File(user.getTaskFile());
    if (!dataFile.exists()){
      try {
        dataFile.createNewFile();
      } catch (IOException e) {
        System.out.println("I/O Error while creating data file.");
        e.printStackTrace();
      }
    } else {
      try {
        this.data = Files.readAllLines(path);
      } catch (IOException e) {
        System.out.println("I/O Error while reading data file.");
        e.printStackTrace();
      }
    }
  }

  public void saveDatas(List<String> taskList){
    try {
      Files.write(path, taskList);
    } catch (IOException e) {
      System.out.println("Error during saving tasks.");
      e.printStackTrace();
    }
  }

  public void loadDatas(){
  }

  public List<String> getData(){
    return data;
  }
}
