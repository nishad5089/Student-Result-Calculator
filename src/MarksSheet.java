import java.util.List;

public class MarksSheet extends ResultManager {
    private List<SubjectMarks> subjectMarks;

    public List<SubjectMarks> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(List<SubjectMarks> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }
}
