package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {
ReentrantLock safe = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    @Override
    public void run() {
      safe.lock();

      while (stringIterator.hasNext()){
       this.copied += stringIterator.next();
       this.copied += " ";
      }
      safe.unlock();
    }

    public void print(){
        System.out.println(this.copied);
    }
}
