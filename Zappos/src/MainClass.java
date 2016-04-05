class A
{
    int i = 10;
    
    void print()
    {
    	System.out.println("A");
    }
}
 
class B extends A
{
	int i = 20;
	B(int j){
		super.i=j;
	}
    B(){
    	
    }
    void print()
    {
    	System.out.println("B");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new B(2);
        B b = new B();
        System.out.println(a.i);
        System.out.println(b.i);
        
        a.print();

    }
    
    
}
