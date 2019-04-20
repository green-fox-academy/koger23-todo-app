import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;

public class DataHandler {
  private List<String> data;
  private Path path;
  private String fileName;
  private AccountManager accountManager;
  private File dataFile;

  public DataHandler(AccountManager accountManager) {
    this.accountManager = accountManager;
    if (this.accountManager.getActiveUser() != null){
      this.fileName = accountManager.getActiveUser().getTaskFile();
      dataFile = new File(this.fileName);
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
    System.out.println(user.getUserName() + " created!");
    System.out.println(dataFile.exists());
    if (!dataFile.exists()){
      System.out.println(dataFile.getName());
      try {
        dataFile.createNewFile();
        System.out.println(user.getUserName() + " created!");
      } catch (IOException e) {
        System.out.println("I/O Error while creating data file.");
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
