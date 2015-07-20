package me.ravikanth.messenger.dao;

/**
 * Created by ragudipati on 7/19/15.
 */
public class User {
    private int id;
    private String nick;
    private String firstName;
    private String lastName;

    public User(){}

    public User(String nick, String firstName, String lastName) {
        this.nick = nick;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
