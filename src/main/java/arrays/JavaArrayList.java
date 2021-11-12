package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JavaArrayList {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		List<Integer> listInitialSize = new ArrayList<Integer>(2); // initial capacity
		
		listInitialSize.add(1);
		listInitialSize.add(2);
		listInitialSize.add(3);
		
		listInitialSize.forEach(System.out::println);
		System.out.println("---------------------------");
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		hashSet.add(1);
		hashSet.add(2);
		
		List<Integer> listFromCollection = new ArrayList<Integer>(hashSet);
		
		
		listFromCollection.forEach(System.out::println);
	}

}
