package org.geektimes.rest.demo;

public class User{

    private User(){

    }

    private User(String name){
        this.name = name;
    }

    private static User user = new User("coderfocus");
    public static User getInstance(){
        return user;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
