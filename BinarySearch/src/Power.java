import java.util.ArrayList;
import java.util.List;


public class Power {
	
public static void main(String[] args) {
		
		
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		pow(2,3,3);

	}

public static int pow(int x, int n, int d) {
    
	 long a = x;
	    long res = 1L;
	    
	    while (n > 0) {
	        
	        if (n % 2 == 1) {
	            res *= a;
	            res %= d;
	        }
	        
	        a *= a;
	        a %= d;
	        n = n >> 1;
	        
	    }
	    
	    res = (res + d) % d;
	    
	    return (int) res;
	}

}
