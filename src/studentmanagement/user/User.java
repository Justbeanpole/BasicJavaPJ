package studentmanagement.user;

public abstract class User {
    protected String id;
    protected String password;
    protected String name;

    public String getId() {
        return id;
    }
    public String getPw() { return password; }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public void setPw(String pw) {
        this.password = pw;
    }
    public String getInfo(){
        return String.format("ID: %s | Password: %s | Name: %s", id, password, name);
    }
}
