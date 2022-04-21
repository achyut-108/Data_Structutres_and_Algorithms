package dynamicProgramming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import exceptions.DSAlgoException;

public class FibonacciSeries {

	private static List<BigInteger> fbList = new ArrayList<>();

	static {
		fbList.add(BigInteger.ZERO);
		fbList.add(BigInteger.ONE);
	}

	public static BigInteger findFibonacci(int number) {
		try {

			if(fbList.size() > number && fbList.get(number)!=null) return fbList.get(number);
			
			IntStream.rangeClosed(2, number).forEach(integer -> {
				fbList.add(fbList.get(integer - 1).add(fbList.get(integer - 2)));
			});
			
			return fbList.get(number);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DSAlgoException(
					ex != null || !ex.getMessage().isEmpty() ? ex.getMessage() : "Invalid Argument passed!!");
		}
	}

	public static void main(String[] args) {
		
		System.out.println("fibonacci of 900 : " + findFibonacci(153000));
		System.out.println("fibonacci of 6:  " + findFibonacci(6));
		
	}
	
}
