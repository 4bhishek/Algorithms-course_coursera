import java.util.Iterator;
import java.util.NoSuchElementException;
//mport java.util.Scanner;
//import java.lang.*;

public class Deque<Item> implements Iterable<Item>
{
 private Node first;
 private Node last;
 private Node current;
 private int count = 0;
 
 private class Node        //class to define custom data structure for stack
 {
  Item value;
  Node next;
  Node prev;
 }
 
 public Deque()          //default constructor to initialize variables
 {
  first = null;
  last = null;
  current = null;
 }
 
 public boolean isEmpty()      // checks if the stack is empty or not
 {
   if(first == last&&first == null)
    return true;

   else
    return false;
 }
 
 public int size()          //returns the current size of stack
 {
   return count;
 }
 
 public void addFirst(Item item)     //adds element to the front of the stack
 {
  if(item != null)
  {
   current = new Node();
   current.value = item;
   
   if(first == null)
   {
     current.next = null;
	 current.prev = null;
	 first = current;
	 last = current;
	 
	 count++;
   }
   else
   {
     current.next = first;
	 current.prev = null;
	 first.prev = current;
	 first = current;
	 
	 count++;
   }
  }
  else
  {
    throw new IllegalArgumentException();
  }
 }
 
 public void addLast(Item item)       //adds element to the end of the stack
 {
  if(item != null)
  {
   current = new Node();
   current.value = item;
   
   if(last == null)
   {
     current.next = null;
	 last = current;
	 first = last;
	 
	 count++;
   }
   else
   {
     current.next = null;
	 current.prev = last;
	 last.next = current;
	 last = current;
	 
	 count++;
   }
  }
  else
  {
   throw new IllegalArgumentException();
  }
 }
 
 public Item removeFirst()          //removes element from the front of stack
 {
   if(isEmpty())
   {
     throw new NoSuchElementException();
   }
	 Item val = first.value;
	 first.prev = null;
	 if(first == last)
     {
     last=first.next;
	 first = first.next;
	 }
	 else
     {
     first=first.next;
	 }
	 
	 count--;
	 
	 return val;
 }
 
 public Item removeLast()          //removes element from the front of stack
 {
   if(isEmpty())
   {
     throw new NoSuchElementException();
   }
	 Item val = last.value;
	 last.next = null;
	 if(first == last)
	 {
	  first=last.prev;
      last = last.prev;
	 }
	 else
     {
      last=last.prev;
	 }
	 
	 count--;
	 
	 return val;
 }
 
 public Iterator<Item> iterator()      // returns iterator object
 {
  return new ListIterator();  
 }
 
 private class ListIterator implements Iterator<Item>         //iterator class def
 {
  
  private Node currnt = first;
  public boolean hasNext()                                   // returns boolean value whether next value is present or not
  {
    return (currnt != null);
  }
  
  public Item next()                              //returns the current value and moves the pointer to next value
  {
    if(currnt != null)
    {
	Item val = currnt.value;
	currnt = currnt.next;
	
	return val;
	}
	else
    {
     throw new NoSuchElementException();
	}
  }
  
  public void remove()                           //obslete method
  {
   throw new UnsupportedOperationException();	  
  }
 }
 
 
 
/*public static void main(String[] args)
  {
   String cont="n";
   int ipvalue;

  Scanner sc=new Scanner(System.in);
  Deque<Integer> dq = new Deque<Integer>();
	  
	  do{
		  System.out.println("Select your choice: ");
	      System.out.println("1. Add First\n2.Add Last\n3.Remove First\n4.Remove Last\n5. View All\n6.Size of Stack"); 
	      int choice=sc.nextInt();
	      sc.nextLine();
	  
	  switch(choice)
	  {
		case 1:
		{
            System.out.println("enter the value to add: ");
            ipvalue = sc.nextInt();
            sc.nextLine();
			
            dq.addFirst(ipvalue);
			
			break;
		}

        case 2:
        {
           System.out.println("enter the value to add: ");
            ipvalue = sc.nextInt();
            sc.nextLine();
			
            dq.addLast(ipvalue);
			
			break;
		}

        case 3:
		{
           System.out.println("The first value of stack is: " + dq.removeFirst());
		   
		   break;
		}

       case 4:
	   {
         System.out.println("The Last value of stack is: " + dq.removeLast());
		 
		 break;
	   }

      case 5:
	  {
		   Iterator<Integer> itr=dq.iterator();
		  
		  while(itr.hasNext())
		  {
            System.out.println("Stack value: " + itr.next());
		  }
		  
		  break;
	  }

     case 6:
	 {
       System.out.println("The current size of stack is: " + dq.size());
	   
	   break;
	 }	 
	  }
	  
     System.out.println("Do you want to continue?(y/n)");
	 cont=sc.nextLine();
	 
  }while(cont.equals("y"));
}*/
}