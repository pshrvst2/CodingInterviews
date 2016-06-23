/**
 * 
 */

/**
 * @author pshrivastava
 *
 */
public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {3,2,2,3};
		int val = 3;
		System.out.println(removeElement(arr1, val));

	}
	
public static int removeElement(int[] nums, int val) {
        
        if(nums==null || nums.length == 0)
            return 0;

      int len = 0;
      int start = 0;
      int end = nums.length-1;
      
      /*for(int in : nums){
    	  if(in!=val)
    		  len++;
      }*/
      
      while(start<=end){
          if(nums[end]!=val){
              int temp = nums[start];
              nums[start] = nums[end];
              nums[end] = temp;
              start++;
              len++;
          }
          else{
            end--;
            //len++;
          }
      }
     
      return len;
    }

}
