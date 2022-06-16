package hexlet.courses.lessont9.theory.t2;

import java.util.Iterator;

public class University implements Iterable<Student> {
    private Student[] students;

    public University(Student[] students) {
        this.students = students;
    }

    @Override
    public Iterator<Student> iterator() {
        return new UniversityIterator();
    }

    private class UniversityIterator implements Iterator<Student> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return University.this.students.length > index;
        }

        @Override
        public Student next() {
            return University.this.students[index++];
        }
    }
}
