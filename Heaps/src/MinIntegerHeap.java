import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinIntegerHeap {
   private List<Integer> heap;
 
   public MinIntegerHeap() {
      heap = new ArrayList<>();
      heap.add( 0 ); // set up trash slot
   }
 
   public MinIntegerHeap(MinIntegerHeap other) {
      heap = new ArrayList(other.heap);
   }
 
   public void add( Integer obj ) {
      /* to be completed by you */
   }
 
   private void reheapUp() {
      /* to be completed by you */
   }
 
   public Integer remove() {
      /* to be completed by you */
	   return null;
   }
 
   private void reheapDown() {
      /* to be completed by you */
   }
 
   public int size() {
      return heap.size() - 1;
   }
 
   public boolean isEmpty() {
      return size() == 0; // or heap.size() <= 1
   }
 
   public String toString() {
      return heap.subList(1, heap.size()).toString();
   }
 
   public void clear() {
      heap.clear();
      heap.add(0);
   }
 
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
 
   // Use this if you wish, but the trash slot will be more efficient for the computer
   private void swap( int index1, int index2 ) {
       Collections.swap( heap, index1, index2 );
   }
}
 