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

  public void addTask(String taskDescription){

    Task task = new Task();
    task.setTaskDescription(taskDescription);

    taskList.add(task);

    saveTaskList();

  }

  public void removeTask(int index){

    try{
      taskList.remove(index);
      saveTaskList();
    } catch (IndexOutOfBoundsException e){
      System.out.println("Unable to remove: index is out of bound");
    }
  }

  public void saveTaskList(){
    dataHandler.saveDatas(TaskConverter.convertDataToString(taskList, separator));
  }

  public void checkTask(int index){

    try{
      taskList.get(index).setFinished(!taskList.get(index).isFinished());
      saveTaskList();
    } catch (IndexOutOfBoundsException e){
      System.out.println("Unable to remove: index is out of bound");
    }
  }

  public void printList(){

    if (taskList.size() == 0){
      System.out.println("No todos for today! :)");
    } else {

      for (int i = 0; i < taskList.size(); i++) {

        String state = " ";

        if (taskList.get(i).isFinished()){
          state = "x";
        }

        System.out.println(i + 1 + " - [" + state + "] " + taskList.get(i).getTaskDescription());

      }
    }
  }

  public void printListUndoneOnly(){

    if (taskList.size() == 0){
      System.out.println("No todos for today! :)");
    } else {

      for (int i = 0; i < taskList.size(); i++) {

        if (taskList.get(i).isFinished() == false){
          System.out.println(i + 1 + " - [ ] " + taskList.get(i).getTaskDescription());
        }
      }
    }
  }

  public void removeDoneTasks(){

    List<Integer> toRemove = new ArrayList<>();

    for (Task task : taskList){
      if (task.isFinished == true){
        toRemove.add(taskList.indexOf(task));
      }
    }
    for (int index : toRemove){
      taskList.remove(index);
      saveTaskList();
    }
  }

  public static void main(String[] args) {

    TaskList taskList = new TaskList();

    taskList.printList();

  }

}
