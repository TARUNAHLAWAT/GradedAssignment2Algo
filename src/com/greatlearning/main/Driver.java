package com.greatlearning.main;

import com.greatlearning.Operations.StockPriceOperations;
import java.util.Scanner;
import com.greatlearning.Search.BinarySearch;
import com.greatlearning.Search.MergeSort;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the no of companies");
		int noOfCompanies = sc.nextInt();

		double[] stockPrices = new double[noOfCompanies];
		boolean[] stockPriceStatus = new boolean[noOfCompanies];
		for (int i = 0; i < noOfCompanies; i++) {

			System.out.println("Enter current stock price of the company " + (i + 1));
			stockPrices[i] = sc.nextDouble();

			System.out.println("Whether company's stock price rose today compare to yesterday?");
			stockPriceStatus[i] = sc.nextBoolean();
		}

		while (true) {

			System.out.println("""

					-----------------------------------------------
					Enter the operation that you want to perform
					1. Display the companies stock prices in ascending order
					2. Display the companies stock prices in descending order
					3. Display the total no of companies for which stock prices rose today
					4. Display the total no of companies for which stock prices declined today
					5. Search a specific stock price
					6. press 0 to exit
					-----------------------------------------------""");

			int operation = sc.nextInt();

			if (operation == 0) {

				break;
			}

			StockPriceOperations stockTracker = new StockPriceOperations(stockPrices, stockPriceStatus);
			switch (operation) {
			case 1 ->

				stockTracker.showStocks(true);
			case 2 ->

				stockTracker.showStocks(false);
			case 3 ->

				stockTracker.showNoOfCompaniesStockRose();
			case 4 ->

				stockTracker.showNoOfCompaniesStockDeclined();
			case 5 -> {
				System.out.println("enter the key value");
				var searchValue = sc.nextDouble();
				stockTracker.searchStockPrice(searchValue);
			}

			default -> System.out.println("Invalid operation input");
			}
		}
		System.out.println("Exited successfully");
	}
}
