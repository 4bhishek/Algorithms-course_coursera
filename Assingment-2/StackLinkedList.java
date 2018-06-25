import java.util.Scanner;

class StackLnkedLst
{
 
 Node top=null;      //holds the topmost element of stack
 Node current;       //holds current node of stack(acts as temp var)
 
 private class Node
 {
	 String item;
	 Node next;
 }
 
 boolean isEmpty()       //checks if stack is null
 {
	 if(top==null)
	 {
		 return true;
	 }
	 else
		 return false;
 }
 
 public void push(String item)        //pushes an element in the stack
 {
	 current=new Node();
     current.item=item;
  	 if(isEmpty())
	 {
		 this.current.next=null;
	 }
	 else	 
	 {
		 this.current.next=top;
	 }
	 
	 top=current;
	 
 }
 
 public String pop()          //gives out the topmost element of stack
 {
	if(isEmpty())
	{
		throw new NullPointerException();
	}
	else
	{
		String value = top.item;
		top=top.next;
		return value;
	}

 }
 
 }
 
class StackLinkedList
{
	public static void main(String args[])
	{
		String chck="y";
		
		Scanner sc=new Scanner(System.in);
		
		StackLnkedLst stack=new StackLnkedLst();
		
		while(chck.equals("y"))
		{
		System.out.println("1.Push\n2.Pop");
		int select=sc.nextInt();
		sc.nextLine();
		switch(select)
		{
				case 1:
				{
					System.out.println("Enter value to push in stack");
					
					stack.push(sc.nextLine());
					System.out.println("Do you want to continue?(y/n)");
					chck=sc.nextLine();
					
					
					break;
				}
				case 2:
				{
					String value=stack.pop();
					System.out.println(value);
					System.out.println("Do you want to continue?(y/n)");
					chck=sc.nextLine();
					
					
					break;
				}
		}
		}
		
		
	}
} 