package com.epam.model;

public class ModernUser {
    private String name;
    private String surname;
    private int age;

    public ModernUser() {
    }

    public ModernUser(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModernUser)) return false;

        ModernUser modernUser = (ModernUser) o;

        if (getAge() != modernUser.getAge()) return false;
        if (getName() != null ? !getName().equals(modernUser.getName()) : modernUser.getName() != null) return false;
        return getSurname() != null ? getSurname().equals(modernUser.getSurname()) : modernUser.getSurname() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public String toString() {
        return "ModernUser{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
