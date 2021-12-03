package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        Thread unSafeThread1 = new Thread(unsafeCopier);
        Thread unSafeThread2 = new Thread(unsafeCopier);
        Thread unSafeThread3 = new Thread(unsafeCopier);
        Thread unSafeThread4 = new Thread(unsafeCopier);
        Thread unSafeThread5 = new Thread(unsafeCopier);
        List<Thread> unSafeThreadList = new ArrayList<>();
        unSafeThreadList.add(unSafeThread1);
        unSafeThreadList.add(unSafeThread2);
        unSafeThreadList.add(unSafeThread3);
        unSafeThreadList.add(unSafeThread4);
        unSafeThreadList.add(unSafeThread5);
        for (Thread t : unSafeThreadList){
            t.start();
        }



       SafeCopier safeCopier = new SafeCopier(introduction);
        Thread safeThread1 = new Thread(safeCopier);
        Thread safeThread2 = new Thread(safeCopier);
        Thread safeThread3 = new Thread(safeCopier);
        Thread safeThread4 = new Thread(safeCopier);
        Thread safeThread5 = new Thread(safeCopier);

        List<Thread> safeThreadList = new ArrayList<>();
        safeThreadList.add(safeThread1);
        safeThreadList.add(safeThread2);
        safeThreadList.add(safeThread3);
        safeThreadList.add(safeThread4);
        safeThreadList.add(safeThread5);
        for (Thread t : safeThreadList){
            t.start();

        }



        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println("UNSAFE COPIER");
        unsafeCopier.print();
        System.out.println("\nSAFE COPIER");
        safeCopier.print();
    }
}