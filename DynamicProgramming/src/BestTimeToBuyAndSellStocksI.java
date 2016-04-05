import java.util.List;

/**
 * 
 */

/**
 * @author Piyush
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
 *
 */
public class BestTimeToBuyAndSellStocksI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int maxProfit(final List<Integer> a) {
	    
	    int minElem = Integer.MAX_VALUE;
	    int profit = 0;
	    
	    for(Integer in : a)
	    {
	        profit = Math.max(profit, in - minElem);
	        minElem = Math.min(minElem, in);
	    }
	    
	    return profit;
	}
	
	public int maxProfit(int[] prices) {
	    int profit = 0;
	    int minElement = Integer.MAX_VALUE;
	    for(int i=0; i<prices.length; i++){
	       profit = Math.max(profit, prices[i]-minElement);
	       minElement = Math.min(minElement, prices[i]);
	    }
	    return profit;
	}

}
