package hexlet.courses.lesson9.theory.t2;

import hexlet.courses.lessont9.theory.t2.Group;
import hexlet.courses.lessont9.theory.t2.Student;
import hexlet.courses.lessont9.theory.t2.University;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorTest {
    private static final int STUDENTS_COUNT = 10_000;

    private static Student[] students = new Student[STUDENTS_COUNT];

    @BeforeAll
    public static void generateStudents() {
        for (int i = 0; i < STUDENTS_COUNT; i++) {
            students[i] = new Student("Ivan");
        }
    }

    @Test
    public void testUniversityIterator() {
        final University univ = new University(students);
        checkThaIteratorReturnCorrectResults(univ, students);
        checkThatIteratorThrowsExceptions(univ.iterator());
    }

    @Test
    public void testGroupIterator() {
        final Group group = new Group(students);
        checkThaIteratorReturnCorrectResults(group, students);
        checkThatIteratorThrowsExceptions(group.iterator());
    }

    private static Executable checkThaIteratorReturnCorrectResults(
        final Iterable<Student> students,
        final Student[] studentsArray
    ) {
        int y = 0;
        for (Student stud : students) {
            if (studentsArray[y] != stud) {
                throw new RuntimeException(String.format("Iterator return incorrect element with index: %d", y));
            }
            y++;
        }
        if (y != studentsArray.length) {
            throw new RuntimeException(String.format("Iterator returns incorrect amount of Stundets: %d instead of: %d",
                y, studentsArray.length));
        }
        return null;
    }

    private static void checkThatIteratorThrowsExceptions(final Iterator<Student> students) {
        while (students.hasNext()) {
            students.next();
        }
        try {
            students.next();
            throw new RuntimeException("Iterator.next() do not throw the Exception when hasNext returns false");
        } catch (final NoSuchElementException e) {

        }
    }
}
