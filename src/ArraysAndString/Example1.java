/**
 * 
 */
package ArraysAndString;

import java.awt.peer.SystemTrayPeer;

/**
 * @author Piyush
 * Implement an algorithm to determine if a string has all unique characters
 * What if you can not use additional data structures? 
 *
 */
public class Example1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//if(hasUniqueChar("abcza"))
		if(isUniqueChar("abcza"))
			System.out.println("All characters are unique");
		else
			System.out.println("Characters are not unique");

	}
	
	public static boolean hasUniqueChar(String str){
		
		boolean charSet[] = new boolean[256];
		
		for(int i =0; i< str.length(); i++){
			
			int val = str.charAt(i);
			
			if(charSet[val])
				return false;
			
			else
				charSet[val] = true;
		}
		return true;
	}
	
	public static boolean isUniqueChar(String str){
		
		int checker = 0;
		
		for(int i=0; i< str.length(); ++i ){
			
			int value = str.charAt(i) - 'a';
			
			int flag = (1 << value); 
			//TODO
			// not clear what << implies 
			
			if((checker & (flag)) > 0 )
				return false;
			
			checker |= (1 << value); 
		}
			return true;
			
	}

}
