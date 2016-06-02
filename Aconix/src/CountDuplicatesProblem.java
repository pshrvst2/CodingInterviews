import java.util.HashMap;
import java.util.HashSet;


public class CountDuplicatesProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,2,3,4,5,7,90,1,1,2,1,1,2};
		System.out.println(countDuplicates(numbers));

	}
	
	public static int countDuplicates(int[] numbers)
	{	
		HashSet<Integer> countSet = new HashSet<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int nbr : numbers)
		{
			if(map.containsKey(nbr)){
				int cnt = map.get(nbr);
				map.put(nbr, ++cnt);
				if(!countSet.contains(nbr))
					countSet.add(nbr);
			}
			else
				map.put(nbr, 1);
		}
		return countSet.size();
	}

}
