
public class PrintFirstTenDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode p1= new ListNode(0);
		ListNode head = new ListNode(0);
		head.next = p1;
		
		for(int i = 1; i<11; i++)
		{
			p1.val = i;
			if(i==10) break;
				
			p1.next = new ListNode(0);
			p1 = p1.next;
		}

		printList(head.next);

	}
	
	public static void printList(ListNode head)
	{
		if(head == null)
		{
			System.out.println("Head is null");
			return;
		}
		
		while(head!=null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}
	
}
