import java.util.*;

/**
 * Creates the MinIntegerHeap class
 * 
 * @author asharma
 * @version 3.19.21
 *
 */
public class MinIntegerHeap {
	
   private List<Integer> heap;
 
   
   /**
    * Main method to test the class
    * 
    * @param args the main method
    */
   public static void main (String [] args) {
	   MinIntegerHeap testHeap = new MinIntegerHeap();
       Random rand = new Random();
       for ( int x = 0; x < 50000; x++ ) {
           testHeap.add( rand.nextInt(1000) - 500 );
       }
       
       Integer current = testHeap.remove();
       while ( !testHeap.isEmpty() ) {
           Integer next = testHeap.remove();
           if ( current > next ) {
               System.out.println("Failed.");
           }
           current = next;
       }
       System.out.println("Done.");
   }
   
   /**
    * Default constructor
    */
   public MinIntegerHeap() {
      heap = new ArrayList<>();
      heap.add(0); // set up trash slot
   }
 
   /**
    * Takes in another MinIntegerHeap
    * 
    * @param other the MinIntegerHeap to be based off of
    */
   public MinIntegerHeap(MinIntegerHeap other) {
      heap = new ArrayList(other.heap);
   }
 
   /**
    * Adds an integer to the end of the heap
    * Then reheaps up
    * 
    * @param obj the integer to be added
    */
   public void add( Integer obj ) {
	   heap.add(obj);
	   reheapUp();
   }
 
   /**
    * Sorts the heap after an add 
    * from smallest to greatest
    */
   private void reheapUp() {
	   int index = size();
	   while(index > 1 && (heap.get(index/2) > heap.get(index))) {
		   setTrash(index);
		   heap.set(index, heap.get(index/2));
		   heap.set(index/2, getTrash());
		   index/=2;
	   }
   }
   
   /**
    * Sets the trash from a specific index
    * 
    * @param index the location where 
    * the trash will recieve from
    */
   private void setTrash(int index) {
	   heap.set(0, heap.get(index));
   }
   
   /**
    * Returns the trash slot
    * 
    * @return the value in the trash slot
    */
   private int getTrash() {
	   return heap.get(0);
   }
 
   /**
    * Removes the head and then reheaps down
    * 
    * @return the head value
    */
   public Integer remove() {
	  Integer x = heap.get(1);
	  swap(1, this.size());
	  heap.remove(this.size());
	  reheapDown();
	  return x;
   }
 
   /**
    * Resorts the heap from smallest 
    * to greatest after removing the head value
    */
   private void reheapDown() {
      int index = 1;
      while ((index * 2 + 1) < heap.size() && 
    		  (heap.get(index * 2) < heap.get(index) || heap.get(index * 2 + 1) < heap.get(index))) {
    		  if (heap.get(index * 2) < heap.get(index * 2 + 1)) {
    			  this.swap(index, index * 2);
    			  index *= 2;
    		  } else {
    			  this.swap(index, index * 2 + 1);
    			  index = index * 2 + 1;
    		  }
      }
      if (index * 2 < heap.size() && heap.get(index) > heap.get(index * 2)) {
    	  this.swap(index, index * 2);
      }
   }
 
   /**
    * Returns the size of the heap
    * 
    * @return the size of the heap
    */
   public int size() {
      return heap.size() - 1;
   }
 
   /**
    * Checks to see if the heap is empty
    * 
    * @return if it is empty
    */
   public boolean isEmpty() {
      return size() == 0; 
   }
 
   /**
    * Converts the heap into a string
    * 
    * @return the string value of the heap
    */
   public String toString() {
      return heap.subList(1, heap.size()).toString();
   }
 
   /**
    * Clears the heap
    */
   public void clear() {
      heap.clear();
      heap.add(0);
   }
 
   /**
    * Checks to see if the heap is equal to 
    * another heap in the incoming parameter
    * 
    * @param other the heap to be checked
    * @return if it is equal to other
    */
   public boolean equals( MinIntegerHeap other ) {
      if ( this.size() != other.size() ) {
          return false;
      }
      MinIntegerHeap copyThis = new MinIntegerHeap(this);
      MinIntegerHeap copyOther = new MinIntegerHeap(other);
      while ( !copyThis.isEmpty() ) {
          if ( !copyThis.remove().equals( copyOther.remove() ) ) {
                return false;
          }
      }
      return true;
   }
 
   /**
    * Swaps two indexes
    * 
    * @param index1 the first index to be swapped
    * @param index2 the second index to be swapped
    */
   private void swap( int index1, int index2 ) {
       Collections.swap( heap, index1, index2 );
   }
}
 