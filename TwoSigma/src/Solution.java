
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {

		try
		{
		// REad the input
		Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();
		String[] clusAndMach = firstLine.split("\\s");
		String clustersStr = clusAndMach[0];
		String machinesStr = clusAndMach[1];
		Integer clusters = Integer.valueOf(clustersStr);
		Integer machines = Integer.valueOf(machinesStr);
		
		// Main logic begins here. Firstly assign one machine to each cluster as that mandatory.
		// Add the clusters in a priority queue.
		PriorityQueue<Cluster> pq = new PriorityQueue<Cluster>(new ClusterComparator());
		while(clusters > 0)
		{
			Cluster cluster = new Cluster();
			cluster.setUtil(sc.nextInt());
			cluster.addMachine();
			cluster.setCurrUtil();
			clusters--;
			machines--;
			pq.add(cluster);
		}
		sc.close();
		assignMachines(pq, machines);
		
		//Display the final max util
		Cluster maxUtilCluster = pq.peek();
		System.out.println(maxUtilCluster.getCurrUtil());
		}
		catch(NumberFormatException nfe)
		{
			System.out.println(0);
		}

	}
	
	public static void assignMachines(PriorityQueue<Cluster> pq, int machinesPending)
	{
		while(machinesPending > 0)
		{
			Cluster c = pq.poll();
			c.addMachine();
			c.setCurrUtil();
			pq.add(c);
			machinesPending--;
		}
	}

}

class Cluster
{
	int util = 0;
	int machines = 0;
	int currUtil = 0;
	
	public int getUtil() {
		return util;
	}
	public void addMachine() {
		this.machines++;
	}
	public void setUtil(int util) {
		this.util = util;
	}
	public int getCurrUtil() {
		return currUtil;
	}
	public void setCurrUtil() {
		this.currUtil = (int) Math.ceil((double)this.util/(double)this.machines);
	}
}

class ClusterComparator implements Comparator<Cluster>{

	public int compare(Cluster c1, Cluster c2) 
	{
		if(c1.getCurrUtil() < c2.getCurrUtil())
			return 1;
		else if(c1.getCurrUtil() > c2.getCurrUtil())
			return -1;
		else
		{
			// tricky case, you can't just return 0. Compare between the cluster task/min. The largest one should
			// be at the front of the queue.
			if(c1.getUtil() < c2.getUtil())
				return 1;
			else if(c1.getUtil() > c2.getUtil())
				return -1;
			else
				return 0;
			
			//return 0;
		}
	}
	
}

