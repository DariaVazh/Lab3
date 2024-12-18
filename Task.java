public class Task {
    private String name;
    private boolean status;


    public Task(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {//геттер названия
        return name;
    }

    public boolean getStatus() {//геттер статуса
        return status;
    }

    public void setStatus(boolean c){
        this.status = c;
    }

    @Override
    public String toString() {
        String st;
        if (status)
            st = "[x] ";
        else
            st = "[ ] ";
        return st + name;
    }
}
