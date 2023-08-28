package service;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class User {

    private int id;
    private String name;

    public static List<User> users= new ArrayList<User>();

    public User(String name){
        this.id = (int)Math.random()*100;
        this.name = name;
    }

    public User(){

    }

    public void addUser(Scanner read) {
        System.out.println("Enter the name of user");
        String name = read.next();
        User.users.add(new User(name));
    }

    public void addUser(String name) {
        User.users.add(new User(name));
    }

    public void getAllUsers(Scanner read) {
        System.out.println("Below is the list of users");
        for(User u : User.users){
            System.out.println(u.name);
        }
    }

    public static User getUser(String name) {
        for(User u : User.users){
            if(u.getName().equals(name))
                return u;
        }
        System.out.println("User not present");
        return null;
    }
}
