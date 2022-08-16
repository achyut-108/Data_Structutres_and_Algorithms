package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class PairSearching {

	// to check if the current list has any adjacent pair.
	public boolean findPair(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) == list.get(i + 1)) {
				return true;
			}
		}
		return false;
	}

	// To break the number down and add its digits to the list
	public List<Integer> getList(int num) {
		List<Integer> list = new ArrayList<Integer>();
		while (num > 0) {
			int temp = num % 10;

			list.add(temp);

			num /= 10;
		}

		reverseTheList(list);

		return list;
	}

	public void reverseTheList(List<Integer> list) {
		int hi = list.size() - 1, lo = 0;
		while (lo < hi) {
			int temp = list.get(lo);
			list.set(lo, list.get(hi));
			list.set(hi, temp);
			lo++;
			hi--;
		}
	}

	public int pairSearching(int num) {
		List<Integer> startingList = new ArrayList<Integer>();
		List<Integer> values = new ArrayList<Integer>();

		values.add(num);
		values.add(0);
		int result = 0;

		Map<List<Integer>, List<Integer>> startingTable = new HashMap<List<Integer>, List<Integer>>();

		startingTable.put(startingList, values);

		Queue<Map<List<Integer>, List<Integer>>> listPair = new LinkedList<Map<List<Integer>, List<Integer>>>();
		listPair.offer(startingTable);

		// BFS Traversal
		while (!listPair.isEmpty()) {
			Map<List<Integer>, List<Integer>> tablePair = listPair.peek();
			List<Integer> currentList = new ArrayList<Integer>();
			// current number
			int currentTotal = 0;
			// multiplication Count
			 result = 0;

			for (Entry<List<Integer>, List<Integer>> entry : tablePair.entrySet()) {
				currentList = entry.getKey();
				currentTotal = entry.getValue().get(0);
				result = entry.getValue().get(1);
			}

			List<Integer> temp = getList(currentTotal);
			for (int x = 0; x < temp.size(); x++) {
				currentList.add(temp.get(x));
			}

			listPair.poll();

			// checking if current list of integers has adjacent pair
			if (findPair(currentList)) {
				return result;
			}

			// traverse the current list to analyze each path
			for (int x = 0; x < currentList.size(); x++)
			{
				Map<List<Integer>, List<Integer>> newTable = new HashMap<List<Integer>, List<Integer>>();
				List<Integer> newItems = new ArrayList<Integer>();

				// updating our multiplication count and number value
				newItems.add(currentTotal * currentList.get(x));
				newItems.add(result + 1);
				newTable.put(currentList, newItems);

				// adding new path to our queue
				listPair.offer(newTable);
			}
			
		}

		return result;
	}

	public static void main(String[] args) {
		
		PairSearching pairSum = new PairSearching();
		System.out.println("pair searching : " + pairSum.pairSearching(8));
		
	}
	
}
