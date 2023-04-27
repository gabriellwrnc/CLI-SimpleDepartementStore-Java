package pa;

public class User {
    private String username;
    private String password;
    private String accessLevel;

    protected User(String username, String password, String accessLevel) {
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    protected String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }

    protected String getAccessLevel() {
        return accessLevel;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

}
