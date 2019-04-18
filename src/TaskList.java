import java.util.ArrayList;
import java.util.List;

public class TaskList {

  private List<Task> taskList = new ArrayList<>();
  private DataHandler dataHandler = new DataHandler();
  private final String separator = ";";

  public TaskList() {
    populateList();
  }

  public void populateList(){

    for (String line : dataHandler.getData()){

      Task task = TaskConverter.convertDataToTask(line, separator);

      taskList.add(task);

    }

  }

  public List<Task> getTaskList() {
    return taskList;
  }

  public void setTaskList(List<Task> taskList) {
    this.taskList = taskList;
  }

  public void addTask(Task task){

  }

  public void removeTask(Task task){

  }

  public void removeTask(int index){

  }

  public void checkTask(int index){

  }

  public void printList(){

    for (int i = 0; i < taskList.size(); i++){

      System.out.println(i + " - " + taskList.get(i).getTaskDescription());

    }

  }

  public static void main(String[] args) {

    TaskList taskList = new TaskList();

    taskList.printList();

  }

}
