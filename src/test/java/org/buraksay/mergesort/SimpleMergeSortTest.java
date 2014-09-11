package org.buraksay.mergesort;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class SimpleMergeSortTest {

    @Test
    public void testSort() {
	List<Integer> unsortedList, sortedList, resultList;
	Collections.addAll(unsortedList = new LinkedList<Integer>(), 11, 9, 8, 7, 6, 4, 2, 10, 9, 5, 3, 2, 1);
	Collections.addAll(sortedList = new LinkedList<Integer>(), 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10, 11);
	
	resultList = new SimpleMergeSort<Integer>().sort(unsortedList);
	assertEquals(sortedList, resultList);
    }
    
    @Test
    public void testSortRandomList() {
	List<Integer> unsortedList, resultList;
	unsortedList = new LinkedList<Integer>();
	
	long startTime = System.nanoTime(); 
	final int size = 1000000;//Integer.MAX_VALUE / 2;
	for(int i = 0; i < size; i++) {
	    unsortedList.add((int) (Math.random() * size));
	}
	long splitTime = System.nanoTime();
	long initTime = TimeUnit.MILLISECONDS.convert((splitTime - startTime), TimeUnit.NANOSECONDS);
	startTime = splitTime;
	
	resultList = new SimpleMergeSort<Integer>().sort(unsortedList);
	splitTime = System.nanoTime();
	long mergeSortTime = TimeUnit.MILLISECONDS.convert((splitTime - startTime), TimeUnit.NANOSECONDS);;
	startTime = splitTime;
	
	Collections.sort(unsortedList);
	splitTime = System.nanoTime();
	long quickSortTime = TimeUnit.MILLISECONDS.convert((splitTime - startTime), TimeUnit.NANOSECONDS);;
	startTime = splitTime;
	
	assertEquals(unsortedList, resultList);
	splitTime = System.nanoTime();
	long assertTime = TimeUnit.MILLISECONDS.convert((System.nanoTime() - startTime), TimeUnit.NANOSECONDS);
	
	
	String newline = System.lineSeparator();
	System.out.println(String.format("Stats:%sInit time: %4d%sMergesort time:%4d%sQuicksort time:%4d%sComparison time:%4d",
		newline,initTime,newline,mergeSortTime,newline,quickSortTime,newline,assertTime));
	
    }

}
