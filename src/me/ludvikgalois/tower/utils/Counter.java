package me.ludvikgalois.tower.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by probie on 9/11/16.
 * Probably not needed - just implemented for fun
 */
public class Counter implements Iterable <Integer>{
    private final int count;

    public Counter(int count){
        this.count = count;
    }

    public void doTimes(Runnable f) {
        new CounterIter(count).doTimes(f);
    }

    private class CounterIter implements Iterator <Integer> {

        private int count;
        private int index;

        public CounterIter(int count){
            this.count = count;
            this.index = 0;
        }

        public boolean hasNext() {
            return index < count;
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return index++;
        }

        public void doTimes(Runnable f) {
            for (; index < count; index++) f.run();
        }


    }

    @Override
    public Iterator<Integer> iterator() {
        return new CounterIter(count);
    }


}
