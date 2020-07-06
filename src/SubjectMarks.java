public class SubjectMarks {
    private Subject subjectName;
    private int marks;
    private String subjectGrade;
    private double subjectGradePoint;

    public SubjectMarks(Subject subject, int marks) {
        this.subjectName = subject;
        this.marks = marks;
        this.calculateGrade();
    }

    public String getSubjectGrade() {
        return subjectGrade;
    }

    public double getSubjectGradePoint() {
        return subjectGradePoint;
    }

    public Subject getSubjectName() {
        return subjectName;
    }

    public int getMarks() {
        return marks;
    }

    private void calculateGrade() {
        switch (this.marks / 10) {
            case 10:
            case 9:
            case 8:
                setGradeAndPoint("A+", 5);
                break;
            case 7:
                setGradeAndPoint("A", 4);
                break;
            case 6:
                setGradeAndPoint("A-", 3.5);
                break;
            case 5:
                setGradeAndPoint("B", 3);
                break;
            case 4:
                setGradeAndPoint("C", 2);
                break;
            case 3:
                setGradeAndPoint("D", 1);
                break;
            default:
                setGradeAndPoint("F", 0);
        }
    }

    private void setGradeAndPoint(String grade, double gradePoint) {
        if (this.marks < 33) {
            this.subjectGrade = "F";
            this.subjectGradePoint = 0;
        } else {
            this.subjectGrade = grade;
            this.subjectGradePoint = gradePoint;
        }
    }

    @Override
    public String toString() {
        return subjectName + " " + marks + " " + subjectGradePoint + " " + subjectGrade;
    }
}
