package app.entities;

import java.util.Objects;

public class User {
    private String name;
    private String password;

    public User() {

    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 42 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

}
