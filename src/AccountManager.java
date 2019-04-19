import java.util.ArrayList;
import java.util.List;


public class AccountManager {
  private User currentUser;
  private List<User> userList = new ArrayList<>();
  private String separator = ";";
  private UserFileHandler uFh = new UserFileHandler();

  public AccountManager(){
    populateUserList();
  }

  public void populateUserList(){
    for (String line : uFh.getData()) {
      User user = UserConverter.convertDataToTask(line, separator);
      userList.add(user);
    }
  }

  public void printUserList(){
    String active;
    for (int i = 0; i < userList.size(); i++){
      if (userList.get(i).isActive()){
        active = " (active)";
      } else {
        active = "";
      }
      System.out.println(i+1 + " - " + userList.get(i).getUserName() + active);
    }
  }

  public void addUser(String userName){
    User userObj = new User(false, userName);
    boolean userNameExists = false;
    for (User user : userList){
      if (user.getUserName().equals(userName)){
        System.out.println("Username already exists.");
        userNameExists = true;
        break;
      }
    }
    if (!userNameExists){
      userList.add(userObj);
      saveUserList();
    }
  }

  public void removeUser(int index){
    try {
      userList.remove(index);
      saveUserList();
    } catch (IndexOutOfBoundsException e) {
      System.out.println("No such an user index");
    }
  }

  private void saveUserList() {
    UserFileHandler.saveDatas(UserConverter.convertDataToString(userList, separator));
  }

  public User getActiveUser(){
    return currentUser;
  }

  public void setActiveUser(int index) {
    for (User user : userList){
      user.setActive(false);
    }
    try {
      userList.get(index).setActive(true);
      currentUser = userList.get(index);
    } catch (IndexOutOfBoundsException e){
      System.out.println("No such an user index");
    }
  }
}
