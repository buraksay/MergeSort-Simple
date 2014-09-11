package org.buraksay.mergesort;

import java.util.List;

public interface IMergeSort<T extends Comparable<T>> {

    List<T> sort(List<T> unsorted);

}