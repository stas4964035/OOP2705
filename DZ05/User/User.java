package DZ05.User;

public class User {
    private String name;
    private String login;
    private String password;
    private boolean isAdmin = false;

    public User(String name, String login, String password) {
        this.name = name.trim();
        this.login = login.trim();
        this.password = password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return login + ": " + name;
    }
}
