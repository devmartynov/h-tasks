package hexlet.courses.lessont9.theory.t2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Group implements Iterable<Student> {

    private Student[] students;

    public Group(final Student[] students) {
        this.students = students;
    }

    public final Iterator<Student> iterator() {
        return new StudentsIterator(students);
    }

    private static class StudentsIterator implements Iterator<Student> {
        // BEGIN (write your solution here)
        private int index = 0;
        private Student[] students;

        StudentsIterator(Student[] students) {
            this.students = students;
        }

        @Override
        public boolean hasNext() {
            return students.length > index;
        }

        @Override
        public Student next() throws NoSuchElementException {
            if (!this.hasNext()) {
                throw new NoSuchElementException("No element found");
            }
            return students[index++];
        }
    }
}