
import java.util.List;

public class Student {
    private int id;
    private String Name;
    private MarksSheet markSheets;

    public MarksSheet getMarkSheets() {
        return markSheets;
    }

    public void setMarkSheets(MarksSheet markSheets) {
        this.markSheets = markSheets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return id + " " + Name + " " + markSheets;
    }
}
