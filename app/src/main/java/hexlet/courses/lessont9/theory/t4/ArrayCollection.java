package hexlet.courses.lessont9.theory.t4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class ArrayCollection<T> implements Collection<T> {

    private T[] baseArray = (T[]) new Object[1];

    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        for (int i = 0; i < size; i++) {
            if (baseArray[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        final T[] newM = (T[]) new Object[this.size()];
        System.arraycopy(baseArray, 0, newM, 0, this.size());
        return newM;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) this.toArray();
    }

    @Override
    public boolean add(final T t) {
        if (baseArray.length == size) {
            final T[] oldM = baseArray;
            baseArray = (T[]) new Object[this.size() * 2];
            System.arraycopy(oldM, 0, baseArray, 0, oldM.length);
        }
        baseArray[size++] = t;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        for (int i = 0; i < size(); i++) {
            if (baseArray[i].equals(o)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    private void remove(final int index) {
        if (index != this.size() - 1) {
            System.arraycopy(baseArray, index + 1, baseArray, index, this.size() - index - 1);
        }
        if (this.size() != 0) {
            size--;
        }
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (final T item : this) {
            if (!c.contains(item)) {
                this.remove(item);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        baseArray = (T[]) new Object[1];
        size = 0;
    }

    private class ElementsIterator implements Iterator<T> {
        private int size;
        private int nextCallCounter;
        private int removeCallCounter;
        private T elemFromNextCall;


        @Override
        public boolean hasNext() {
            return ArrayCollection.this.size > size;
        }

        @Override
        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no next element!");
            }

            nextCallCounter = 1;
            removeCallCounter = 0;
            elemFromNextCall =  ArrayCollection.this.baseArray[size++];
            return elemFromNextCall;
        }

        @Override
        public void remove() throws IllegalStateException {
            if (removeCallCounter == 0 && nextCallCounter == 0) {
                throw new IllegalStateException("remove");
            }

            if (removeCallCounter == 1 && nextCallCounter == 0) {
                throw new IllegalStateException("remove");
            }

            ArrayCollection.this.remove(elemFromNextCall);
            elemFromNextCall = null;
            size--;
            nextCallCounter = 0;
            removeCallCounter = 1;
        }
    }
}
