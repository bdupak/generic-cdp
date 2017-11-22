package com.epam;

import com.epam.logic.container.generic.GenericHolder;
import com.epam.model.User;

public class Main {
    public static void main(String[] args) {

        GenericHolder<User> users = new GenericHolder<>();
        for(int i = 0; i < 100; i++) {
            users.addElement(new User("user" + i, "user" + 1, i));
        }
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.getElement(i));
        }
        System.out.println(users.getIndex(new User("user1", "user1", 1)));
        System.out.println(users.findElement(new User("user1", "user1", 1)));

        GenericHolder<User> holder = new GenericHolder<>(200);
        for(int i = 0; i < 100; i++) {
            holder.addElement(new User("user" + i, "user" + 1, i));
        }
        for(int i = 0; i < holder.size(); i++) {
            System.out.println(holder.getElement(i));
        }
        System.out.println(holder.getIndex(new User("user1", "user1", 1)));
        System.out.println(holder.findElement(new User("user1", "user1", 1)));


        for (User user : holder) {
            System.out.println("foreach " + user);
        }

    }
}
