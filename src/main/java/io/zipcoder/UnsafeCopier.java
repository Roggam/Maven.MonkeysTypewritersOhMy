package io.zipcoder;

import java.util.Random;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {
    Thread thread = new Thread();
    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while (stringIterator.hasNext()){
            this.copied += stringIterator.next();
            thread.start();
            this.copied += " ";
        }
    }

    public void print(){
        System.out.println(this.copied);
    }
}
