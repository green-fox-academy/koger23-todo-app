import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataHandler {
  private List<String> data;
  private Path path;
  private String FILENAME = "todo.csv";

  public DataHandler() {
    path = Paths.get(FILENAME);
    File dataFile = new File(FILENAME);
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

  public static void main(String[] args) {
    DataHandler dH = new DataHandler();
  }

}
