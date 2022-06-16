package hexlet.courses.lessont9.theory.t1;

import java.util.Arrays;
import java.util.Iterator;

public class University implements Iterable<Student> {
    private Student[] students;

    public University(Student[] students) {
        this.students = students;
    }

    @Override
    public Iterator<Student> iterator() {
        return Arrays.asList(this.students).iterator();
    }
}
