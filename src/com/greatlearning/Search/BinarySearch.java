package com.greatlearning.Search;

public class BinarySearch {
	public int searchValue(double[] array, double searchValue) {
		int left, right, mid;
		left = 0;
		right = array.length - 1;
		mid = left + (right - left) / 2;

		while (left <= right) {
			if (searchValue < array[mid]) {
				right = mid - 1;
			} else if (searchValue > array[mid]) {
				left = mid + 1;
			} else {
				return mid;
			}
			mid = left + (right - left) / 2;
		}
		return -1;
	}
}
