package org.example.comparation;

public class Man implements Comparable<Man>{

    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    private String username;
    private Integer id;

    public Man(String username, Integer id){
        this.username = username;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Man{" +
                "username='" + username + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Man user) {
        return this.id.compareTo(user.id);
    }
}
