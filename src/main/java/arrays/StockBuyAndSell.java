package arrays;

import java.util.Scanner;

/**
 * Given an array of non negative integers indicating stock prices. Find out the
 * max profit that can be obtained by buying and selling the stocks.
 * 
 * @author siddhartha.kumar
 *
 */

public class StockBuyAndSell {

	public int stockBuyAndSell(int[] stockPrice) {
		int maxProfit = 0;
		int buyPrice = stockPrice[0];
		int sellPrice = stockPrice[0];
		for (int i = 1; i < stockPrice.length; i++) {
			while (i < stockPrice.length && sellPrice < stockPrice[i]) {
				sellPrice = stockPrice[i++];
			}

			maxProfit = maxProfit + (sellPrice - buyPrice);
			if (i < stockPrice.length) {
				buyPrice = stockPrice[i++];
				sellPrice = buyPrice;
			}
		}

		return maxProfit;
	}

	/**
	 * The idea is to buy stock at the bottom price and selling at every peak.
	 * 
	 * @param stockPrice
	 * @return
	 */
	public int maxProfitEfficient(int[] stockPrice) {
		int maxProfit = 0;

		for (int i = 1; i < stockPrice.length; i++) {
			if (stockPrice[i - 1] < stockPrice[i]) {
				maxProfit = maxProfit + (stockPrice[i] - stockPrice[i - 1]);
			}
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {

			sc = new Scanner(System.in);
			System.out.println("Please enter the size of the integer array : ");
			int lengthOfArray = sc.nextInt();

			int[] arr = new int[lengthOfArray];

			System.out.println("Please enter the elements of the array : ");

			for (int i = 0; i < lengthOfArray; i++) {
				arr[i] = sc.nextInt();
			}

			StockBuyAndSell stockBuyAndSell = new StockBuyAndSell();
			int maxProfit = stockBuyAndSell.stockBuyAndSell(arr);
			int maxProfitEfficient = stockBuyAndSell.maxProfitEfficient(arr);
			System.out.println("The maxProfit : " + maxProfit);
			System.out.println("The maxProfitEfficient : " + maxProfitEfficient);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception raise in main : " + ex);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

}
