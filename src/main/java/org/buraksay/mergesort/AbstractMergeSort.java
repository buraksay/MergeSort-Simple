package org.buraksay.mergesort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;

public abstract class AbstractMergeSort<T extends Comparable<T>> implements IMergeSort<T> {

    protected static int callCount = 0;

    public List<T> sort(List<T> unsorted) {
	callCount++;
	return sortList(unsorted);
    }

    protected abstract List<T> sortList(List<T> unsorted);

    static int getCallCount() {
	return callCount;
    }

    static void resetCallCount() {
	callCount = 0;
    }

    protected List<T> merge(List<T> first, List<T> second) {
	List<T> mergedList = new LinkedList<T>();
	PeekingIterator<T> iterFirst = Iterators.peekingIterator(first.iterator());
	PeekingIterator<T> iterSecond = Iterators.peekingIterator(second.iterator());

	boolean firstHasNext, secondHasNext;

	while ((firstHasNext = iterFirst.hasNext()) || iterSecond.hasNext()) {
	    secondHasNext = iterSecond.hasNext();

	    if (firstHasNext) {
		if (secondHasNext) {
		    // both have more
		    T element1 = iterFirst.peek();
		    T element2 = iterSecond.peek();
		    if (element1.compareTo(element2) <= 0) {
			//element1 is lteqt element2
			mergedList.add(iterFirst.next());
		    } else {
			//element2 is lt element1
			mergedList.add(iterSecond.next());
		    }
		    
		} else {
		    // first has more, second is depleted
		    mergedList.add(iterFirst.next());
		}
	    } else {
		// first is depleted, second has more
		mergedList.add(iterSecond.next());
	    }
	}
	return mergedList;
    }

}