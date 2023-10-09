package org.example.streams;

import java.util.Objects;

public class Cat {
    private String name;
    private Integer age;


    private String catOwner;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCatOwner() {
        return catOwner;
    }

    public Integer getOwnerAge() {
        return ownerAge;
    }

    public String getLocation() {
        return location;
    }

    private Integer ownerAge;

    private String location;

    public Cat(String name, Integer age, String catOwner, Integer ownerAge, String location) {
        this.name = name;
        this.age = age;
        this.catOwner = catOwner;
        this.ownerAge = ownerAge;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", catOwner='" + catOwner + '\'' +
                ", ownerAge=" + ownerAge +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name) && Objects.equals(age, cat.age) && Objects.equals(catOwner, cat.catOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, catOwner);
    }
}
