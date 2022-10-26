package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	 
	Node head;
	 Node tail;
     int capacity;
	
    public class Node{
		Node next;
		Node prev;
		T data;
		
		public Node(T data, Node next ,Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
			
		}
	}
	
	public BasicDoubleLinkedList(){
		this.head = null;
		this.tail = null;
		this.capacity = 0;
	}
	
	 public BasicDoubleLinkedList<T> addToEnd (T data){
		 
		 Node node = new Node(data , null ,tail);
		 if(tail != null) {
			 tail.next =  node;
		 } 
		 tail = node;
			
		 
	 if( head == null) {
		  head = node;
	 }
	 capacity++;
		
	 return this;
		
	}
	
	public BasicDoubleLinkedList<T> addToFront(T data){
		
		Node list = new  Node(data, head, null);
		
		if(!( head == null)) {
			head.prev = list;
		}
		
		head = list;
		if(tail == null) {
			tail = list;
		}
		
		capacity++;
		return this;
	}
	public T getFirst() {
		
		return head.data;
	}
	public T getLast() {
	
		return tail.data;
	}
	public ListIterator<T> iterator()
            
			throws UnsupportedOperationException, NoSuchElementException{
		
		return new Basiciterators();
	}
	 
		
	public BasicDoubleLinkedList<T> remove(T data, Comparator<T> comparator){
		
		
		  Node prev = null, node = head;
		 
		  while (!(node == null)) {
		 
		 if (comparator.compare(node.data, data) == 0) {
		  
		 if (node == head) {
		  head = head.next;
		  node = head;
		  } 
		 else if (node == tail) {
		  
			 node = null;
		  tail = prev;
		  prev.next = null;
		  } else {
		  prev.next = node.next;
		  node = node.next;
		  }
		  capacity--;
		  } else {
		  prev = node;
		  node = node.next;
		  }
		  }
		  return this;
	}
	public T retrieveFirstElement() {
		if (capacity == 0) {
			  throw new NoSuchElementException("Linked list is empty");
			  }
		  Node node = head;
		  head = head.next;
		  head.prev = null;
		  capacity--;
		return node.data;
	}
	
	public T retrieveLastElement() {
		if (capacity == 0) {
			  throw new NoSuchElementException("Linked list is empty");
			  }
		Node node = head;
		 Node prev = null;

		  while (node != null) {
		  if (node.equals(tail)) {
		  tail = prev;
		  break;
		  }
		  prev = node;
		  node = node.next;
		  }
		  capacity--;
		  return node.data;
	}

	public int getSize() {
		
		return capacity;
	}
	
	public ArrayList<T> toArrayList(){
		 
		ArrayList<T> list  = new ArrayList<T>();
		ListIterator<T> iterator = new Basiciterators();
			
		while(iterator.hasNext()) {
				list.add(iterator.next());
			}
		 	
		return list;
	}
	public class Basiciterators implements ListIterator<T>{	
		
		Node node = head, FinalList = null;
		
		public T next() {
		 
		if(node != null)
		  {
		  T val = node.data;
		 
		  FinalList = node;
		  node = node.next;
		  
		  if(node != null) {
			 
			 node.prev = FinalList;
			  }
		  return val;
		  }
		  else
		  throw new NoSuchElementException();
		  }
		  
		
	public boolean hasNext() {
		  
		return node!=null;
		  }
	
    public T previous() {
		  
    	if(!(FinalList == null))
		  {
		   node = FinalList;
		   FinalList= node.prev;
		  
		   T data = node.data;
		   return data;
		  }
		  else
		  
			  throw new NoSuchElementException();
		  }
		 
    public boolean hasPrevious(){
		  
			  return FinalList!=null;
		  }
		  
			 
		
		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
			
		}
	}
		

	
}
	

		

