import java.util.ArrayList;
import java.util.List;

public class TaskConverter {
  public static Task convertDataToTask(String text, String separator){
    String[] arr = text.split(separator);
    Task task  = new Task(Boolean.parseBoolean(arr[1]), arr[0]);
    return task;
  }

  public static List<String> convertDataToString(List<Task> taskList, String separator){
    List<String> taskStrings = new ArrayList<>();
    for (Task task : taskList){
      String taskString = task.getTaskDescription() + separator + task.isFinished();
      taskStrings.add(taskString);
    }
    return taskStrings;
  }
}
