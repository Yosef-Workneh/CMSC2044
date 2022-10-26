package application;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	
	 Comparator<T> comp;  
	
	 public SortedDoubleLinkedList(Comparator<T> comparator2) {
		 
		 comp = comparator2;	 
	}
	 
	public SortedDoubleLinkedList <T> add(T data){
	
		if (data == null) {
			return this;
			}

			Node list = new Node(data, null, null);
			
			if (head == null) {
			   head = tail = new Node(data, null, null);
			} 
			else {
			
				if (comp.compare(data, head.data) <= 0) {
			     list.next = head;
			     head = list;
			} 
			else if (comp.compare(data, tail.data) >= 0) {
			
				tail.next = list;
			    tail = list;
			}
			else {
			Node node2 = head.next;
			Node node1 = head;
			
			while (comp.compare(data, node2.data) > 0) {
			node1 = node2;
			node2 = node2.next;
			}
			node1.next = list;
			list.next = node2;
			}
			}
			capacity++;
			
			return this;
			
		
	}
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
					
		throw new UnsupportedOperationException("Invalid operation for sorted list");
				
	}
	public BasicDoubleLinkedList<T> addToFront(T data){
	
		throw new UnsupportedOperationException("Invalid operation for sorted list");
						
		
	}
	public ListIterator<T> iterator(){
		
		return new Basiciterators();
		
	}
	public SortedDoubleLinkedList<T> remove(T data, Comparator <T> comparator){
		
		Node node2 = head;
		Node node1 = null;
		
		while (node2 != null) {
		
			if (comparator.compare(node2.data, data) == 0) {
		
				capacity--;
		
			if (node1 != null) {
			  node1.next = node2.next;
			  
		} else {
		
			head = node2.next;
		}
		if (node2 == tail) {
		
			tail = node1;
		}
		
		}
			
		node1 = node2;
		node2 = node2.next;
		}

		return this;
	}

	}
	