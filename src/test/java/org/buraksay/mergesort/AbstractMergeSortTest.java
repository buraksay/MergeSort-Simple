package org.buraksay.mergesort;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class AbstractMergeSortTest {

    private AbstractMergeSort<Integer> sort;
    

    @Before
    public void initSort() {
	sort = new AbstractMergeSort<Integer>() {

	    @Override
	    protected List<Integer> sortList(List<Integer> unsorted) {
		// TODO Auto-generated method stub
		return null;
	    }
	};
    }

    @Test
    public void testSortCountMetric() {
	List<Integer> emptyList = new LinkedList<Integer>();
	for (int i = 0; i < 100; i++) {
	    sort.sort(emptyList);
	}
	assertEquals(100, AbstractMergeSort.getCallCount());
	AbstractMergeSort.resetCallCount();
    }

    @Test
    public void testMerge() {
	List<Integer> list1, list2, mergedList;
	list1 = new LinkedList<Integer>();
	list2 = new LinkedList<Integer>();
	mergedList = new LinkedList<Integer>();
	Collections.addAll(list1, 1, 2, 3, 5, 9, 10);
	Collections.addAll(list2, 2, 4, 6, 7, 8, 9, 11);
	Collections.addAll(mergedList, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10, 11);
	
	List<Integer> resultList = sort.merge(list1, list2);
	assertEquals(mergedList, resultList);
    }

}
