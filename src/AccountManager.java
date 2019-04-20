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
      if (user.isActive()){
        currentUser = user;
      }
    }
  }

  public void printUserList(){
    String active;
    if (userList.size() > 0){
      for (int i = 0; i < userList.size(); i++){
        if (userList.get(i).isActive()){
          active = " (active)";
        } else {
          active = "";
        }
        System.out.println(i+1 + " - " + userList.get(i).getUserName() + active);
      }
    } else {
      System.out.println("\n User list is empty. Add new user(s).\n");
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
    setActiveUser(userList.size() - 1);
    printUserList();
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
      System.out.println(currentUser.isActive());
      printUserList();
      saveUserList();
    } catch (IndexOutOfBoundsException e){
      System.out.println("No such an user index");
    }
  }
}
