import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class IntComparator implements Comparator<Integer>{

	public int compare(Integer arg0, Integer arg1) {
		if(arg0.intValue()<arg1.intValue())
			return 1;
		else if((arg0.intValue()>arg1.intValue()))
			return -1;
		else
			return 0;
	}
}
public class MedianFinder {

	Comparator<Integer> c = (Comparator<Integer>) new IntComparator();
	PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	//static Queue<Integer> q = new LinkedList<Integer>();
	//static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	int len = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFinder mf = new MedianFinder();
		mf.addNum(10);
		//System.out.println(mf.findMedian());
		mf.addNum(-2);
		//System.out.println(mf.findMedian());
		mf.addNum(-3);
		mf.addNum(-7);
		//System.out.println(mf.findMedian());
		//System.out.println(mf.q);

	}

	// Adds a number into the data structure.
	public void addNum(int num) {
		q.offer(num);
		System.out.println(q);
		//map.put(len++, num);
	}
	public double findMedian1() 
	{
		double med = 0.0;
		
		return med;
	}
	// Returns the median of current data stream
	public double findMedian() 
	{
		double med = 0.0;
		int leng = q.size();
		if(leng==1)
			return q.peek();
		if(leng%2==0)
		{
			Iterator<Integer> iter = q.iterator();
			int i = 0;
			double[] a = new double[2];
			while (iter.hasNext() && i<=leng/2) 
			{
				int in = iter.next();
				if(i==(leng/2-1))
					a[0] = in;
				else if(i == leng/2)
					a[1] = in;
				i++;
			}
			med = (a[0]+a[1])/2;
		}
		else
		{
			Iterator<Integer> iter = q.iterator();
			int i = 0;
			double a = 0;
			while (iter.hasNext() && i<=leng/2) 
			{
				int in = iter.next();
				//int x = leng/2;
				if(i==(leng/2))
					a = in;
				i++;
			}
			med = a;
		}
		return med;

	}

}
