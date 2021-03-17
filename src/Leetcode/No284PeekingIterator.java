package Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No284PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer i = null;

    public No284PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(i == null)
            i = iterator.next();
        return i;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(i == null)
            return iterator.next();
        Integer r = i;
        i = null;
        return r;
    }

    @Override
    public boolean hasNext() {
        if(i == null)
            return iterator.hasNext();
        return true;
    }
}
