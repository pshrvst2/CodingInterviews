
public class SumOfIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {4, 1, 2, 3, 4};
		System.out.println(sumOfIntegers(arr));

	}
	
	static long sumOfIntegers(int[] arr) {

        long ret = 0l;
        
        int len = arr[0];
        
        if(len>arr.length)
            return 0;
        
        for(int i = 1; i <= len; i++)
        {
            ret = (long) ret + arr[i];
            
        }
        
        return ret;
    }

}
