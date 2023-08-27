 import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class University {

        private final static String UNIVERSITY_NAME = "Московский государственный университет";

        private final StudentValueGenerator studentValueGenerator;

        private Map allStudents = new HashMap<>();
        private int countId = 1;

        public University(StudentValueGenerator studentValueGenerator) {
            this.studentValueGenerator = studentValueGenerator;
        }

        public void addStudent(Student student) {
            if(allStudents == null) {
                allStudents = new HashMap<>();
            }
            student.setId(countId);
            studentValueGenerator.generateAge();
            student.setAge(studentValueGenerator.generateAge());
            allStudents.put(countId, student);
            countId++;
        }

        public Student getStudentByName(String name) {
            for(Student student : allStudents.values()) {
                if(student.getName().equals(name)) {
                    return student;
                }
            }
            return null;
        }

        public void addStudentInRange(Student student, int minYear, int maxYear) {
            if(allStudents == null) {
                allStudents = new HashMap<>();
            }
            student.setId(countId);
            studentValueGenerator.generateAge();
            studentValueGenerator.generateAge();
            student.setAge(studentValueGenerator.generateAgeInRange(minYear, maxYear));
            allStudents.put(countId, student);
            countId++;
        }

        public List getAllStudents() {
            return new ArrayList<>(allStudents.values());
        }

        public static String getUniversityName() {
            return UNIVERSITY_NAME;
        }
    }
}
