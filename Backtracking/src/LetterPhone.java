import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class LetterPhone {

	static HashMap<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<String> letterCombinations(String A) {
		
		ArrayList<String> retList = new ArrayList<String>();
		
		if(A.isEmpty() || A==null)
			return retList;

		ArrayList<Character> digits[] = new ArrayList[10];
	    
	    for (int i = 0; i < 10; i++) 
	    {
	        digits[i] = new ArrayList<>();
	    }
	    
	    digits[0].add('0');
	    digits[1].add('1');
	    char c = 'a';
	    int k;
	    
	    for (int i = 2; i < 10; i++) 
	    {
	        k = 3;
	        if (i == 7 || i == 9)
	        {
	            k = 4;
	        }
	        
	        for (int j = 0; j < k; j++) 
	        {
	            digits[i].add(c);
	            c++;
	        }
	    }
	    
	    
	    int i = 0;
	    int n = A.length();
	    int dig;
	    ArrayList<String> res = new ArrayList<>();
	    ArrayList<String> temp = new ArrayList<>();
	    ArrayList<String> x;
	    
	    res.add("");
	    
	    while (i < n) 
	    {
	        dig = A.charAt(i) - '0';
	    
	        for (String str : res) 
	        {
	            for (char ch : digits[dig]) 
	            {
	                String st = str + ch;
	                temp.add(st);
	            }
	        }
	        
	        x = res;
	        res = temp;
	        temp = x;
	        temp.clear();
	        
            i++;	        
	    }
	    
	    return res;
	}
	
	public static void mapCreate()
	{
		List<Character> l0 = new ArrayList<Character>();
		l0.add('0');
		map.put(0, l0);
		
		List<Character> l1 = new ArrayList<Character>();
		l1.add('1');
		map.put(1, l1);
		
		List<Character> l2 = new ArrayList<Character>();
		l2.add('a');l2.add('b');l2.add('c');
		map.put(2, l2);
		
		List<Character> l3 = new ArrayList<Character>();
		l3.add('d');l3.add('e');l3.add('f');
		map.put(3, l3);
		
		List<Character> l4 = new ArrayList<Character>();
		l4.add('g');l4.add('h');l4.add('i');
		map.put(4, l4);
		
		List<Character> l5 = new ArrayList<Character>();
		l5.add('j');l5.add('k');l5.add('l');
		map.put(5, l5);
		
		List<Character> l6 = new ArrayList<Character>();
		l6.add('m');l6.add('n');l6.add('o');
		map.put(6, l6);
		
		List<Character> l7 = new ArrayList<Character>();
		l7.add('p');l7.add('q');l7.add('r');l7.add('s');
		map.put(7, l7);
		
		List<Character> l8 = new ArrayList<Character>();
		l8.add('t');l8.add('u');l8.add('v');
		map.put(8, l8);
		
		List<Character> l9 = new ArrayList<Character>();
		l9.add('w');l9.add('x');l9.add('y');l9.add('z');
		map.put(9, l9);
		
		//List<Character> digList = new ArrayList<Character>();
		
		/*for(char x : a.toCharArray())
		{
			digList.add(x);
		}
		
		Collections.sort(digList);*/
	}
}
