import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataHandler {

  private List<String> data;
  private String FILENAME = "todo.csv";
  private final String sep = ";";

  public DataHandler() {

    Path path = Paths.get(FILENAME);
    File dataFile = new File(FILENAME);

    if (dataFile.isFile()){

      try {
        data = Files.readAllLines(path);
//        System.out.println("Datafile exists, read in.");

      } catch (IOException e) {
        System.out.println("Error while reading data file.");
        e.printStackTrace();
      }

    } else {
      try {
        dataFile.createNewFile();
//        System.out.println("Datafile did not exist, so it has been created.");

      } catch (IOException e) {
        System.out.println("I/O Error while creating data file.");
        e.printStackTrace();
      }
    }
  }

  public void saveDatas(){

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
