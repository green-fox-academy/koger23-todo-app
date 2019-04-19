public class User {
  private String userName;
  private boolean isActive;


  public User(){
    this(false, "");
  }

  public User(boolean isActive, String userName) {
    this.userName = userName;
    this.isActive = isActive;
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
}
