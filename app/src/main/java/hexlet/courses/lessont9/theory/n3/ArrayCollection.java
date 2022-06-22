package hexlet.courses.lessont9.theory.n3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollection<T> implements Collection<T> {
    private T[] array = (T[]) new Object[1];

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        T[] m = (T[]) toArray();
        for (T elem : m) {
            if (elem.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(array, 0, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) array;
    }

    @Override
    public boolean add(T t) {
        if (size == array.length) {
            T[] oldArray = array;
            array = (T[]) new Object[size * 2];
            System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        }
        array[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (var i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }

            // i == 0 ? size - 1 : size - i

            if (array[i].equals(o)) {
                System.arraycopy(
                    array,
                    size - 1 != i ? i + 1 : 0,
                    array, i,
                    i == 0 ? size - 1 : size - i
                );
                --size;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object elem : c) {
            if (!contains(elem)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T elem : (T[]) c.toArray()) {
            add(elem);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (T elem : (T[]) c.toArray()) {
            remove(elem);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (var i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    private class ArrayIterator implements Iterator<T> {
        private int size;

        @Override
        public boolean hasNext() {
            return ArrayCollection.this.size > size;
        }

        @Override
        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("There is not next element");
            }
            return ArrayCollection.this.array[size++];
        }
    }
}
