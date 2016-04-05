
public class SwapTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		ListNode b = a.next;
		b.next = new ListNode(3);
		ListNode c = b.next;
		c.next = new ListNode(4);
		ListNode d = c.next;

		ListNode ret = swapPairs1(a);

	}
	
	public static ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;

		ListNode start = new ListNode(0); //make head no longer a special case
        start.next = head;

        ListNode cur = start;
        
        while (cur.next != null & cur.next.next != null) 
        {
            //cur->next = swap(cur->next, cur->next->next);
            //cur = cur->next->next;
        	
        	cur.next = swap(cur.next, cur.next.next);
        	cur = cur.next.next;
        }
        return start.next;
	}
	
	public static ListNode swap(ListNode a, ListNode b)
	{
		a.next = b.next;
        b.next = a;
        return b;
	}
	
	public static ListNode swapPairs1(ListNode a) {
		if (a == null)
			return null;

		a = rec(a);
		return a;

	}
		
		public static ListNode rec(ListNode node) {
		    
		    ListNode nextNode;
		    ListNode firstNode;
		    firstNode = node;
		    ListNode prevNode = null;
		    
		    if (node.next != null)
		        firstNode = node.next;
		    
		    while (!(node == null || node.next == null)) {
		        nextNode = node.next;
		        node.next = nextNode.next;
		        nextNode.next = node;
		        if (prevNode != null)
		            prevNode.next = nextNode;
	            prevNode = node;
		        node = node.next;
		    }
		    
	        return firstNode;
		}

}
