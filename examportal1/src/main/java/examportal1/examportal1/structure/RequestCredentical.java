package examportal1.examportal1.structure;


public class RequestCredentical {

    String username;

    String password;

    public RequestCredentical(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RequestCredentical() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
