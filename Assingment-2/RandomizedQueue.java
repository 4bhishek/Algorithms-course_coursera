//import java.util.*;
//import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item>
{

private Item randomQueue[];
private int first;
private int last;
private int current;
 
 public RandomizedQueue()          //default constructor to initialize variables
 {
   randomQueue=(Item[])new Object[1];
   
    first=last=current=0;
 }
 
 public boolean isEmpty()      // checks if the stack is empty or not
 {
   if(current == 0)
    return true;
   else
    return false;
 }
 
 public int size()          //returns the current size of stack
 {
   return current;
 }
 
 public void enqueue(Item item)     //adds element to the front of the stack
 {
  if(item != null)
  {
    if(randomQueue.length == current)
	{
		resize(2*randomQueue.length);
	}
	
	randomQueue[current]=item;
	
	first = current++;
	
  }
  else
  {
    throw new IllegalArgumentException();
  }
 }
 
 private void resize(int size)
 
 {
	 Item copy[] = (Item[])new Object[size];
	 
    for(int i=0;i<current;i++)
    {
      copy[i]=randomQueue[i];
	}
	
   randomQueue=copy;
 }
 
  
 public Item dequeue()          //removes element randomly from the stack
 {
   if(!isEmpty())
   {
     int rand = StdRandom.uniform(current);	   
     
	 Item val = randomQueue[rand];
	 
	 randomQueue[rand]=randomQueue[first];
	 randomQueue[first]=null;
	 
	 first--;
	 current--;
	 
	 if(current > 0 && current == (randomQueue.length/4))
     {
       resize((randomQueue.length/2));
	 }
	 
	 return val;
   }

   else{
     throw new NoSuchElementException();
     }
	 
 }
 
 public Item sample()          //removes element from the front of stack
 {
   if(!isEmpty())
   {
     int rand = StdRandom.uniform(current);	   
     Item val = randomQueue[rand];
	 
	 return val;
   }
   else
   {
	   throw new NoSuchElementException();
   }	 
 }
 
 public Iterator<Item> iterator()      // returns iterator object
 {
  return new ListIterator();  
 }
 
 private class ListIterator implements Iterator<Item>         //iterator class def
 {
   int i= current;
   Item itrQ[];
   
   ListIterator()
   {
     itrQ=(Item[])new Object[current];
	 
	 for(int j = (current -1);j >= 0; j--)
		 
	   itrQ[j]=randomQueue[j];
   }
  
  public boolean hasNext()                                   // returns boolean value whether next value is present or not
  {
    return (i > 0);
  }
  
  public Item next()                              //returns the current value and moves the pointer to next value
  {
    
if(hasNext()) 
  {
	int rand = StdRandom.uniform(current);	   
     
	 Item val = itrQ[rand];
	 
	 itrQ[rand]=itrQ[first];
	 itrQ[first]=null;
	 
	 i--;
	
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
 
}

