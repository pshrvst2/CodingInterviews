
public class IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		integerBreak(5);
	}
	
	public static int integerBreak(int n) 
    {
        int[] dp = new int[n+1];
        printDp(dp);
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
        {
        	System.out.println("i = "+i);
            for(int j = 1; j < i; j++)
            {
                dp[i] = Math.max(dp[i], (Math.max(j,dp[j]) * Math.max(i-j,dp[i-j])));printDp(dp);
            }
        }

        return dp[n];    
    }
	
	public static void printDp(int[] dp)
	{
		for(int in : dp)
			System.out.print("| "+in+ " ");
		System.out.print("|");
		System.out.println();
	}

}
