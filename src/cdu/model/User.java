package cdu.model;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private int id;

    public User() {
    }

    public User(String username, int id, String password, String sex, String hobby) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.sex = sex;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String password;
    private String sex;
    private String hobby;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


}
