package org.example;

public class Animal implements Everything{
    @Override
    public String toString() {
        return "Animal{}";
    }

    @Override
    public void run() {
        System.out.println("это класс эномал");
    }
}
