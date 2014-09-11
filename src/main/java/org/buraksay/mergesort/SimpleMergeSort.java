package org.buraksay.mergesort;

import java.util.LinkedList;
import java.util.List;

public class SimpleMergeSort<T extends Comparable<T>>  extends AbstractMergeSort<T>  {

    @Override
    protected List<T> sortList(List<T> unsorted) {
	int size = unsorted.size();
	if(size == 1) 
	    return unsorted;
	else {
	    List<T> part1, part2;
	    part1 = new LinkedList<T>();
	    part2 = new LinkedList<T>();
	    
	    int part1Size = size / 2;
	    
	    for(T element : unsorted) {
		if(part1Size > 0) {
		   part1.add(element);
		   part1Size--;
		} else {
		    part2.add(element);
		}
	    }
	    
	    return merge(sort(part1),sort(part2));
	}
    }

}
