import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class ResultManager {
    private String grade;
    private double gpa;

    public double calculateGPA(final MarksSheet marksSheet) {
        double total = 0;
        for (SubjectMarks subjectMarks : marksSheet.getSubjectMarks()) {
            total += subjectMarks.getSubjectGradePoint();
        }
        this.gpa = total / marksSheet.getSubjectMarks().size();
        return gpa;
    }

    public String calculateTotalGrade(final double gpa) {
        if (gpa == 5) {
            this.grade = "A+";
        } else if (gpa >= 4 ) {
            this.grade = "A";
        } else if (gpa >= 3.5) {
            this.grade = "A-";
        } else if (gpa >= 3) {
            this.grade = "B";
        } else if (gpa >= 2) {
            this.grade = "C";
        } else if (gpa >= 1) {
            this.grade = "D";
        } else {
            this.grade = "F";
        }
        return this.grade;
    }

    public void printResultAtFile(final Student student) {
            String outputPath = "assets/OutputFile/" + student.getId() + "-" + student.getName() + ".txt";
            File outputFile = new File(outputPath);
            writeResultAtFile(outputFile, student);
    }

    private void writeResultAtFile(File file, Student student) {
        BufferedWriter bufferedWriter = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            FormatToDisplay(student, bufferedWriter);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void FormatToDisplay(final Student student,BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("Name: " + student.getName() + "  Student Roll: " + student.getId() + "\n");
        bufferedWriter.write("-------------------------------------------\n");
        String heading = String.format("%-8s | %6s  | %8s | %6s |", "Subject", "Marks", "Grade Point", "Grade");
        bufferedWriter.write(heading + "\n");
        for (SubjectMarks subjectMarks : student.getMarkSheets().getSubjectMarks()) {
            bufferedWriter.write("-------------------------------------------\n");
            String marks = String.format("%-8s | %5s %3s %8s %4s %4s %3s", subjectMarks.getSubjectName(), String.valueOf(subjectMarks.getMarks()), "|", subjectMarks.getSubjectGradePoint(), "|", subjectMarks.getSubjectGrade(), "|");
            bufferedWriter.write(marks + "\n");
        }
        bufferedWriter.write("-------------------------------------------\n");
        String totalGpaAndGrade = String.format("%17s  | %8s    | %4s   |", "GPA", this.gpa, this.grade);
        bufferedWriter.write(totalGpaAndGrade + "\n");
        bufferedWriter.write("-------------------------------------------\n");
    }

}
