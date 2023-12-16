package org.example;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Study phrase = new Study("Изучение Java - это просто!");
        System.out.println(phrase.printCourse());

        //Ex2
        Car first = new Car();
        first.color = "White";
        first.name = "VW";
        first.weight = 50;
        first.displayInfo();

        Car second = new Car();
        second.color = "Red";
        second.name = "Audi";
        second.weight = 100;
        second.displayInfo();

        //Ex3
        House newHouse = new House(13, 1994, "Marine");
        newHouse.setName("Anita");
        System.out.println(newHouse.getName());
        System.out.println(newHouse.toString());

        House newHouse2 = new House(14, 2015, "Legend");
        System.out.println(newHouse2.toString());

        //Ex4
        Tree aloe = new Tree();
        System.out.println(aloe);

        Tree cactus = new Tree(2,"Cactus");
        System.out.println(cactus.toString());

        Tree baobab = new Tree(14, true, "Baobab");
        System.out.println(baobab.toString());

    }
}

class Study{
    private String course;

    Study(String a){
        this.course = a;
    }

    public String printCourse(){
        return this.course;
    }

}

class Car{
    String color;
    String name;
    int weight;

    void displayInfo(){
        System.out.printf("Color: %s \tName: %s \tWeight: %d\n", color, name, weight);
    }

    public Car(){

    }

    public Car(String color){

        this.color = color;
    }
    public Car(String color, int weight){

        this.color = color;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return new String("Color: "+color+" Name: "+name+"Weight: "+weight+"]");
    }

}

class House{
    private int floors;
    private int year;
    private String name;

    public House(int floors, int year, String name) {
        this.floors = floors;
        this.year = year;
        this.name = name;
    }

    public int getFloors()
    {
        return floors;
    }

    public int getYear()
    {
        return year;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentAge = currentYear - this.year;
        return currentAge;
    }

    @Override
    public String toString()
    {
        return("Information about House: "+ this.getName()+
                ".\nHow many floors: " +
                this.getFloors()+"\nRelease year: " + this.getYear()+
                "\nHow old: "+getCurrentAge());
    }

}
class Tree {
    int age;
    boolean isAlive;
    String name;

    Tree(int age, String name){
        this.age = age;
        this.name = name;
    }

    Tree(int age,boolean isAlive, String name){
        this.age = age;
        this.isAlive = isAlive;
        this.name = name;
    }

    Tree(){

        System.out.println("Пустой конструктор без параметров сработал.");
    }

    public int getAge()
    {
        return age;
    }

    public boolean getIsAlive()
    {
        return isAlive;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return new String("This tree is: "+ getName()+", age:"+getAge()+
                ", the stage of lifecycle:"+getIsAlive());
    }
//       Everything animal=new Dog();
//        Everything animal2=new Animal();
//        Everything animal3=new Cat();
//        animal.run();
//        animal3.run();
//        animal2.run();

}

