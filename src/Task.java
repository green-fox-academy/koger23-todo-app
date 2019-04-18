public class Task {
  boolean isFinished;
  String taskDescription;

  public Task(){
    this(false, "");
  }

  public Task(boolean isFinished, String taskDescription) {
    this.isFinished = isFinished;
    this.taskDescription = taskDescription;
  }

  public boolean isFinished() {
    return isFinished;
  }

  public void setFinished(boolean finished) {
    isFinished = finished;
  }

  public String getTaskDescription() {
    return taskDescription;
  }

  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }
}
