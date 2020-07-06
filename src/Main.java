import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("assets/InputFile/marks.txt");
        Map<Integer,Student> map = loadDataFormFile(inputFile);
        List<Student> students = new ArrayList<>(map.values());
        ResultManager resultManager = new MarksSheet();
        for (Student student: students){
                double gpa = resultManager.calculateGPA(student.getMarkSheets());
                resultManager.calculateTotalGrade(gpa);
                resultManager.printResultAtFile(student);
        }
    }

    public static Map<Integer, Student> loadDataFormFile(File file) {
        Map<Integer, Student> studentMap = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentInfo = line.split(",");
                Student student = loadData(studentInfo);
                studentMap.put(student.getId(), student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return studentMap;
    }
    private static Student loadData(String[] studentInfo) {
        List<SubjectMarks> marks = new ArrayList<>();
        Student student = new Student();
        student.setId(Integer.parseInt(studentInfo[0]));
        student.setName(studentInfo[1]);
        MarksSheet marksSheet = new MarksSheet();
        marks.add(new SubjectMarks(Subject.Bangla,Integer.parseInt(studentInfo[2])));
        marks.add(new SubjectMarks(Subject.English,Integer.parseInt(studentInfo[3])));
        marks.add(new SubjectMarks(Subject.Math,Integer.parseInt(studentInfo[4])));
        marks.add(new SubjectMarks(Subject.Religion,Integer.parseInt(studentInfo[5])));
        marksSheet.setSubjectMarks(marks);
        student.setMarkSheets(marksSheet);
        return student;
    }

}
