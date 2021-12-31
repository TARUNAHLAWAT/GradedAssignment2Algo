package com.greatlearning.Operations;

import com.greatlearning.Search.BinarySearch;
import com.greatlearning.Search.MergeSort;

public class StockPriceOperations {
	private final double[] sortedStockPrices;
	private int noCompanyStockRose = 0;
	private int noCompanyStockDeclined = 0;

	public StockPriceOperations(double[] stockPrices, boolean[] stockStatus) {
		MergeSort sort = new MergeSort();
		sort.sortArray(stockPrices);

		sortedStockPrices = stockPrices;

		for (boolean status : stockStatus) {
			if (status) {
				noCompanyStockRose++;
			} else {
				noCompanyStockDeclined++;
			}
		}
	}

	public void showStocks(boolean isAscOrder) {
		if (isAscOrder) {
			System.out.println("Stock prices in ascending order are :");
			for (double sortedStockPrice : sortedStockPrices) {
				System.out.print(sortedStockPrice + " ");
			}
		} else {
			System.out.println("Stock prices in descending order are :");
			for (int i = (sortedStockPrices.length - 1); i >= 0; i--) {
				System.out.print(sortedStockPrices[i] + " ");
			}
		}
		System.out.println("");
	}

	public void showNoOfCompaniesStockRose() {
		System.out.println("Total no of companies whose stock price rose today : " + noCompanyStockRose);
	}

	public void showNoOfCompaniesStockDeclined() {
		System.out.println("Total no of companies whose stock price declined today : " + noCompanyStockDeclined);
	}

	public void searchStockPrice(double searchValue) {
		BinarySearch bs = new BinarySearch();
		var valueIndex = bs.searchValue(sortedStockPrices, searchValue);

		if (valueIndex == -1) {
			System.out.println("Value not found");
		} else {
			System.out.println("Stock of value " + searchValue + " is present");
		}
	}

}
