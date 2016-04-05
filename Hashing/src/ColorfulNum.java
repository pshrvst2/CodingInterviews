import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class ColorfulNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(colorful(263));

	}

	public static int colorful(int A) {

		HashSet<Integer> hashSet = new HashSet<>();
	    ArrayList<Integer> numbers = new ArrayList<>();
	    
	    while (A != 0) {
	        int num = A % 10;
	        numbers.add(num);
	        A /= 10;
	    }
	    
	    Collections.reverse(numbers);
	    int n = numbers.size();
	    
	    for (int i = 0; i < n; i++) {
	        for (int j = i; j < n; j++) {
	            int prod = 1;
	            for (int k = i; k <= j; k++) {
	                prod *= numbers.get(k);
	            }
	            
	            if (hashSet.contains(prod))
	                return 0;
	                
	            hashSet.add(prod);
	        }
	    }
	    
	    return 1;
	}

}
