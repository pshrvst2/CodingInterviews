
public class ReverseList {

	public static void main(String[] args) {


		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		ListNode b = a.next;
		b.next = new ListNode(3);
		ListNode c = b.next;
		c.next = new ListNode(4);
		ListNode d = c.next;

		ListNode ret = reverseList(a);
		
	}
	
	public static ListNode reverseList(ListNode head) {
	    if(head==null || head.next == null) 
	        return head;
	 
	    ListNode p1 = head;
	    ListNode p2 = head.next;
	 
	    head.next = null;
	    while(p1!= null && p2!= null){
	        ListNode t = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        if (t!=null){
	            p2 = t;
	        }else{
	            break;
	        }
	    }
	 
	    return p2;
	}
	
	/*public static ListNode reverseList(ListNode head, int m, int n) {
	    if(head==null || head.next == null) 
	        return head;
	    
	    int i = 1;
	    ListNode first = null;
	    ListNode curr = head;
	    ListNode next;
	    ListNode prev = head;
	    
	    if(m>1)
	    	first = head;
	    
	    while(i<m)
	    {
	    	prev = curr;
	    	next = curr.next;
	    	curr = next;
	    	i++;
	    }
	    
	    ListNode p1 = currhead;
	    ListNode p2 = curr.nexthead.next;
	 
	    curr.next = null;
	    while(i<=np1!= null && p2!= null){
	        ListNode t = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        i++;
	        if (t!=null){
	            p2 = t;
	        }else{
	            break;
	        }
	    }
	    prev.next = p2;
	    return head;
	}*/

}
