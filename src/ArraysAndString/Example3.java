/**
 * 
 */
package ArraysAndString;

/**
 * @author Piyush Design an algorithm and write code to remove the duplicate
 *         characters in a string without using any additional buffer NOTE: One
 *         or two additional variables are fine An extra copy of the array is
 *         not FOLLOW UP Write the test cases for this method.
 * 
 *         First, ask yourself, what does the interviewer mean by an additional
 *         buffer? Can we use an additional array of constant size? Algorithm—No
 *         (Large) Additional Memory: 1 For each character, check if it is a
 *         duplicate of already found characters 2 Skip duplicate characters and
 *         update the non duplicate characters Time complexity is O(N2)
 * 
 */
public class Example3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = {'a', 'b', 'a', 'a'};
		removeDuplicates(str);
		
		char[] strin = {'a', 'b', 'a', 'b'};
		removeDuplicatesEff(strin);

	}
	
	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
	}
	
	public static void removeDuplicatesEff(char[] str) { 
		if(str == null){
			return;
		}
		
		if(str.length < 2){
			return;
		}
		
		boolean[] hit = new boolean[256];
		
		for(int i=0; i< 256; i++){
			hit[i] = false;
		}
		
		hit[str[0]] = true;
		int tail = 1;
		
		for(int i=1; i < str.length; ++i){
			if(!hit[str[i]]){
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail]	= 0;
	}

}
