import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataHandler {
  private List<String> data;
  private Path path;
  private String fileName = "todo.csv";
  private AccountManager accountManager;

  public DataHandler(AccountManager accountManager) {
    this.accountManager = accountManager;
    if (this.accountManager.getActiveUser() != null){
      this.fileName = "users-" + this.accountManager.getActiveUser().getUserName() + "-" + "todo.csv";
    }
    path = Paths.get(this.fileName);
    File dataFile = new File(this.fileName);
    if (dataFile.isFile()){
      try {
        data = Files.readAllLines(path);
      } catch (IOException e) {
        System.out.println("Error while reading data file.");
        e.printStackTrace();
      }
    } else {
      try {
        dataFile.createNewFile();
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
