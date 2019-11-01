package com.epam;

import com.epam.logic.container.generic.GenericHolder;
import com.epam.logic.container.without_generic.SimpleHolder;
import com.epam.logic.container.without_generic.UserHolder;
import com.epam.model.ModernUser;
import com.epam.model.User;

public class Main {
    public static void main(String[] args) {
        checkGeneric();
        checkSimpleHolder();
        checkUserHolder();
    }

    private static void checkGeneric() {
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

//        main purpose of generic we can initialize the same generic class with different class
//        modern user
        GenericHolder<ModernUser> modUsers = new GenericHolder<>();
        modUsers.addElement(new ModernUser("test", "test", 3));
        System.out.println(modUsers.getElement(0));
    }

    private static void checkSimpleHolder() {
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

    private static void checkUserHolder() {
        UserHolder userHolder = new UserHolder(200);
        for (int i = 0; i < 10; i++) {
            userHolder.addElement(new User("user" + i, "user" + i, i));
        }
        for (int i = 0; i < userHolder.size(); i++) {
            System.out.println(userHolder.getElement(i));
        }
        System.out.println("Index of user " + userHolder.getIndex(new User("user2", "user2", 2)));
        System.out.println("Find user " + userHolder.findElement(new User("user2", "user2", 2)));
        for (Object user : userHolder) {
            System.out.println("foreach " + user);
        }

//        main purpose why we use generic
//        UserHolder testException = new UserHolder();
//        userHolder.addElement(new ModernUser("test", "test", 3));
    }
    public void EigthMarch() {}
    public void newMethod() {}
}
