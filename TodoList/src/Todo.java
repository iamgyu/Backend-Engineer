import java.io.Serializable;

public class Todo implements Serializable {
    private String title;
    private String detail;
    private boolean done = false;

    Todo(String title, String detail){
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isDone() {
        return done;
    }
}
