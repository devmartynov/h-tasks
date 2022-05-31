package hexlet.courses.lesson7.theory;

public class User {
    private int id;
    private String nick;

    User(int id, String nick) {
        this.id = id;
        this.nick = nick;
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public boolean isEqual(User user) {
        return this.id == user.id;
    }
}
