import java.util.ArrayList;
import java.util.List;


public class UserConverter {
  public static Task convertDataToTask(String text, String separator){
    String[] arr = text.split(separator);
    User user  = new User(Boolean.parseBoolean(arr[1]), arr[0]);
    return user;
  }

  public static List<String> convertDataToString(List<User> userList, String separator){
    List<String> taskStrings = new ArrayList<>();
    for (User user : userList){
      String taskString = user.getUserName() + separator + user.isActive();
      taskStrings.add(taskString);
    }
    return taskStrings;
  }
}
