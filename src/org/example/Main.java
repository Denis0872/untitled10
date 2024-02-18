package org.example;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        tenThreads();
      printThreads();
        oneHundredThreads();
        getNameThread();
    }


    private static void tenThreads() {
        System.out.println("Запуск 10 потоков");

        Runnable r = () -> {
            System.out.printf("%s поток старт: \n", Thread.currentThread().getName());
            System.out.printf("Статус потока: %s \n", Thread.currentThread().getState());
            for (int i = 0; i <= 100; i++) {
                System.out.println(i);
            }
            System.out.printf("%s поток стоп \n", Thread.currentThread().getName());
        };
        for (int j = 0; j <= 10; j++) {
            String nameThread = Integer.toString(j);
            Thread newThread = new Thread(r, nameThread);
            System.out.printf("Статус потока %d до запуска: %s \n", j, newThread.getState());
            newThread.start();
            System.out.printf("Статус потока %d после запуска: %s \n", j, newThread.getState());
        }
        System.out.println("Стоп поток");
    }

    private static void printThreads() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("состояние потока перед запуском: " + getState());
            }
        };
        System.out.println("состояние потока после запуска: " + thread.getState());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.printf("%s поток прерван", thread.getState());
        }
        System.out.println("состояние потока : " + thread.getState());
    }

    private static void oneHundredThreads() {
        System.out.println("Запуск 100 потоков");
        Counter counter = new Counter();

        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        for (int j = 0; j < 100; j++) {
            Thread oneHundredThreads = new Thread(r);
            oneHundredThreads.start();
            try {
                oneHundredThreads.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.printf("$s Поток прерван",oneHundredThreads.getState());
            }

        }
        System.out.printf("counter равно %d \n",counter.getCount());
        System.out.println("100 потоков стоп");
    }

    private static void getNameThread() {
        Name name = new Name();

        Runnable i = () -> {
            for (int k = 0; k < 3; k++)
                name.name1();
        };

        Runnable j = () -> {
            for (int k = 0; k < 3; k++)
                name.name2();
        };

        new Thread(i).start();
        new Thread(j).start();
    }
}

class Counter {
    int count = 0;

    public void increment() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }


}

class Name {
    public static boolean flag = false;

    synchronized void name1() {
        while (flag == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;
        System.out.println("Name " + Thread.currentThread().getName());
        notify();
    }

    synchronized void name2() {
        while (flag == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
        System.out.println("Name " + Thread.currentThread().getName());
        notify();
    }
}





