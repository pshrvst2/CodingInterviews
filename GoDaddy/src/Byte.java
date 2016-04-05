import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;


public class Byte {
	
	public static void main(String[] a)
	{
		for(byte b = java.lang.Byte.MIN_VALUE; b < java.lang.Byte.MAX_VALUE; b++)
		{
			if(b==0x90)
				System.out.println("dddd");
		}
		test();
	}
	
	public static void test()
	{
		Map<Integer, String> map = new HashMap<Integer, String>(5);
		
		map.put(1, "apple");
		map.put(2, null);
		map.put(3, "peach");
		map.put(new Integer(3), "orange");
		map.put(4, "peach");
		
		for(String str : map.values())
		{
			if("orange".equals(str))
				map.put(5, "banana");
		}
		
		//System.out.println(map.get(5));
		final List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 1,5,2,3,7,3,8,9);
		
		final Integer pos = Integer.valueOf(3);
		list.remove(pos);
		System.out.println(list);
	}
	
	
	
	
}
