package me.ludvikgalois.tower.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by probie on 9/11/16.
 * Probably not needed - just implemented for fun
 */
public class Counter implements Iterable <Integer>{
    private int count;

    public Counter(int count){
        this.count = count;
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

    }

    @Override
    public Iterator<Integer> iterator() {
        return new CounterIter(count);
    }


}
