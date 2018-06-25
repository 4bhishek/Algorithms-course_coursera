import edu.princeton.cs.algs4.StdIn;

public class Permutation
{
	 
 public static void main(String[] args)
  {
    int count = Integer.parseInt(args[0]);
	int cnt = count;
   
  //Scanner sc=new Scanner(System.in);
  RandomizedQueue<String> rdq = new RandomizedQueue<String>();
  
  int i = 0;
  int j  = 0;
  
  while(j < cnt)
  {
    //System.out.println("Enter the value: ");
    String value = StdIn.readString();
	
	rdq.enqueue(value);
	
	cnt--;
  }
  
  while(i < count)
  {
    System.out.println(rdq.dequeue());
	
	count--;
  }
   
}
} 