
public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindromeDP("ACDCA"));

	}
	
	public static String longestPalindromeDP(String s) {
		  int n = s.length();
		  int longestBegin = 0;
		  int maxLen = 1;
		  boolean[][] table = new boolean[1000][1000];
		  
		  for (int i = 0; i < n; i++) {
		    table[i][i] = true;
		  }
		  for (int i = 0; i < n-1; i++) 
		  {
		    if (s.charAt(i) == s.charAt(i+1)) 
		    {
		      table[i][i+1] = true;
		      longestBegin = i;
		      maxLen = 2;
		    }
		  }
		  for (int len = 3; len <= n; len++) {
		    for (int i = 0; i < n-len+1; i++) {
		      int j = i+len-1;
		      if (s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
		        table[i][j] = true;
		        longestBegin = i;
		        maxLen = len;
		      }
		    }
		  }
		  return s.substring(longestBegin, longestBegin+maxLen);
		}

}
