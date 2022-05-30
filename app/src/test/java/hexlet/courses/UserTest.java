package hexlet.courses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
    @Test
    void testIsEqual1() {
        var user1 = new User(12, "Nick12");
        var user2 = new User(1, "Nick12");
        assertThat(user1.isEqual(user2)).isFalse();
    }

    @Test
    void testIsEqual2() {
        var user1 = new User(12, "Nick");
        var user2 = new User(1, "Nick12");
        assertThat(user1.isEqual(user2)).isFalse();
    }

    @Test
    void testIsEqual3() {
        var user1 = new User(1, "Nick");
        var user2 = new User(1, "Nick12");
        assertThat(user1.isEqual(user2)).isTrue();
    }

    @Test
    void testIsEqual4() {
        var user1 = new User(5, "Nick12");
        var user2 = new User(5, "Nick12");
        assertThat(user1.isEqual(user2)).isTrue();
    }
}
