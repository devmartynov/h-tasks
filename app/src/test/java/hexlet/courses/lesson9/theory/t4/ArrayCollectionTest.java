package hexlet.courses.lesson9.theory.t4;

import hexlet.courses.lessont9.theory.t4.ArrayCollection;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Collection;

public class ArrayCollectionTest {

    @Test
    public void testHasNext() {
        final Collection<String> testInstance = new ArrayCollection<>();
        testInstance.add("One");

        final Iterator<String> iter = testInstance.iterator();

        assertThat(iter.hasNext())
            .as("Call hasNext() method in a non-empty collection should return true!")
            .isTrue();

        testInstance.remove("One");

        assertThat(iter.hasNext())
            .as("In an empty collection, the hasNext() method must return false!")
            .isFalse();
    }

    @Test
    public void testHasNextWhenNextWasCalled() {
        final Collection<String> testInstance = new ArrayCollection<>();
        testInstance.add("One");
        testInstance.add("Two");

        final Iterator<String> iter = testInstance.iterator();

        assertThat(iter.hasNext())
            .as("Call hasNext() method in a non-empty collection should return true!")
            .isTrue();

        iter.next();

        assertThat(iter.hasNext())
            .as("Call hasNext() method in a non-empty collection should return true!")
            .isTrue();

        iter.next();

        assertThat(iter.hasNext())
            .as("Call hasNext() method in the end of iteration should return false!")
            .isFalse();
    }

    @Test
    public void testNextOnEmptyCollection() {
        final Collection<Integer> testInstance = new ArrayCollection<>();

        final Iterator<Integer> iter = testInstance.iterator();

        assertThatThrownBy(() -> iter.next()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void testNextNonEmptyCollection() {
        final Collection<Integer> testInstance = new ArrayCollection<>();

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        final Iterator<Integer> iter = testInstance.iterator();

        assertThat(iter.next()).isEqualTo(1);
        assertThat(iter.next()).isEqualTo(2);
        assertThat(iter.next()).isEqualTo(3);

        assertThatThrownBy(() -> iter.next()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void testRemoveBeforeNext() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(2);

        final Iterator<Integer> iter = testInstance.iterator();
        assertThatThrownBy(() -> iter.remove()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void testRemoveTwoTimeInTheRow() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(4);
        testInstance.add(5);

        final Iterator<Integer> iter = testInstance.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.remove();

        assertThat(testInstance.size())
            .as("The expected collection size, after remove() is 4")
            .isEqualTo(4);

        assertThatThrownBy(() -> iter.remove())
            .as("The remove() method does not throw an exception when it is called twice after next")
            .isInstanceOf(IllegalStateException.class);

        assertThat(testInstance.size())
            .as("The expected collection size, after remove() is 4")
            .isEqualTo(4);
    }

    @Test
    public void testNextAfterRemove() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(4);

        final Iterator<Integer> iter = testInstance.iterator();
        iter.next();
        iter.remove();
        iter.next();
        iter.remove();
        iter.next();
        iter.remove();
        iter.next();
        iter.remove();

        assertThatThrownBy(() -> iter.next())
            .as("The next() method does not throw an exception when there are no more elements")
            .isInstanceOf(NoSuchElementException.class);
    }
}