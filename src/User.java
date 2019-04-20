  public class User {
  private String userName;
  private boolean isActive;
  private String taskFilePath;


  public User(){
    this(false, "");
  }

  public User(boolean isActive, String userName) {
    this.userName = userName;
    this.isActive = isActive;
    this.taskFilePath = "users-" + userName + "-" + "todo.csv";
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public String getTaskFile() {
    return taskFilePath;
  }

  public void setTaskFile(String taskFilePath) {
    this.taskFilePath = taskFilePath;
  }
}
