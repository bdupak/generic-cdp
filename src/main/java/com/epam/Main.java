package com.epam;

import com.epam.logic.container.generic.GenericHolder;
import com.epam.logic.container.without_generic.SimpleHolder;
import com.epam.model.User;

public class Main {
    public static void main(String[] args) {

//        for check generic

        GenericHolder<User> users = new GenericHolder<>();
        for (int i = 0; i < 100; i++) {
            users.addElement(new User("user" + i, "user" + i, i));
        }
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.getElement(i));
        }
        System.out.println("Index of user " + users.getIndex(new User("user1", "user1", 1)));
        System.out.println("Find user " + users.findElement(new User("user1", "user1", 1)));

        GenericHolder<User> holder = new GenericHolder<>(200);
        for (int i = 0; i < 100; i++) {
            holder.addElement(new User("user" + i, "user" + i, i));
        }
        for (int i = 0; i < holder.size(); i++) {
            System.out.println(holder.getElement(i));
        }
        System.out.println("Index of user " + holder.getIndex(new User("user1", "user1", 1)));
        System.out.println("Find user " + holder.findElement(new User("user1", "user1", 1)));


        for (User user : holder) {
            System.out.println("foreach " + user);
        }

//        for check simple object holder
        SimpleHolder simpleHolder = new SimpleHolder(200);
        for (int i = 0; i < 10; i++) {
            simpleHolder.addElement(new User("user" + i, "user" + i, i));
        }
        for (int i = 0; i < simpleHolder.size(); i++) {
            System.out.println(simpleHolder.getElement(i));
        }
        System.out.println("Index of user " + simpleHolder.getIndex(new User("user2", "user2", 2)));
        System.out.println("Find user " + simpleHolder.findElement(new User("user2", "user2", 2)));


        for (Object user : simpleHolder) {
            System.out.println("foreach " + user);
        }
    }
}
