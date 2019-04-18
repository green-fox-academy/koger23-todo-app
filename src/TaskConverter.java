import java.util.List;

public class TaskConverter {


  public static Task convertDataToTask(String text, String separator){

    String[] arr = text.split(separator);

    Task task  = new Task(Boolean.parseBoolean(arr[0]), arr[1]);

    return task;
  }

  public static List<String> convertDataToString(Task task){

    return null;
  }

}
