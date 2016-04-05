
public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("onethreeabs " +decodeStr("onethreeabs"));
		System.out.println();
		System.out.println("onesixthreeabsfourxx " +decodeStr("onesixthreeabsfourxx"));
		System.out.println();
		System.out.println("one@onenine " +decodeStr("one@onenine"));
		System.out.println();
		System.out.println("twoathreebfourc " +decodeStr("twoathreebfourc"));
		System.out.println();
		System.out.println("oneonex " +decodeStr("oneonex"));

	}
	
	public static String decodeStr(String input)
	{
		String result ="";
	     input = input.toLowerCase();
	     if(input.length()==0){
	         return result;
	     }
	     StringBuilder sb = new StringBuilder();
	    
	     boolean found = false;
	     int length = 3;
	     String temp ="";
	     int num = -1;
	     for(int i =0; i<input.length(); i++){
	           found = false;
	         if(input.charAt(i)=='@'){
	             sb.append("@");
	         }
	         else{
	             while(length<=5&& i+length<input.length()){
	                 num = -1;
	                 num=findInt(input.substring(i,i+length));
	                 if(num!=-1){
	                     sb.append(String.valueOf(num));
	                     i=i+length-1;
	                     num=-1;
	                     found = true;
	                     break;
	                 }
	                 length++;
	             }
	             length =3;
	             if(num==-1 && !found){
	                 sb.append(String.valueOf(input.charAt(i)));
	             }         
	         }
	     }
	    
	     StringBuilder sb2 = new StringBuilder();
	     String format = sb.toString();
	     int start =0;
	     int end = format.length();
	     while(start<end){
	         if(format.charAt(start)=='@'){
	             int j =1;
	             while(Character.isDigit(format.charAt(start+j))){
	                 j++;
	             }
	             sb2.append(format.substring(start+1, start+j));
	             start=start+j;
	         }
	         if(Character.isDigit(format.charAt(start))){
	         int next =1;
	         int last = format.charAt(start)-'0';
	         while(start+next<end){
	         if(Character.isDigit(format.charAt(start+next)))
	         {
	         last = last*10+(format.charAt(start+next)-'0');
	         next++;
	         }
	         else{
	         break;
	         }
	         }
	             
	             if(start!=end){
	                 for(int i=0; i<last; i++){
	                     sb2.append(String.valueOf(format.charAt(start+next)));
	                 }
	                 start =start+2;
	             }
	             else{
	                 break;
	             }
	         }
	         else
	         {
	           sb2.append(String.valueOf(format.charAt(start)));
	           start++;
	         }
	     }
	     result = sb2.toString();
	     return result;
	}
	
	public static int findInt(String s)
	{
        int r =-1;
        switch(s)
        {
            case "zero": r=0;break;
            case "one" : r = 1; break;
            case "two": r =2; break;
            case "three": r= 3; break;
            case"four": r=4; break;
            case "five": r=5;break;
            case"six": r=6; break;
            case "seven": r=7; break;
            case "eight": r=8; break;
            case "nine": r =9; break;
        }
        return r;
    }
	                          

}
