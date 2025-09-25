public class ToDoItem {

    private  String description;
    private boolean Completed;

    public ToDoItem(String description, boolean Completed) {
        this.description = description;
        this.Completed = Completed;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isCompleted() {
        return Completed;
    }
    public void setCompleted(boolean completed) {
        Completed = completed;
    }
    



}
