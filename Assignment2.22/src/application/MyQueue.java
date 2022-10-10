package application;

import java.util.ArrayList;

public class MyQueue <T>  implements QueueInterface <T>{

	T [] Array;	
	int topStack, stackSize, bottomStack;
	
	public MyQueue (int size) {
		
		stackSize = size;
		topStack = -1;
		bottomStack = 0;
		Array = (T[])new Object[stackSize];
	}
    
	public MyQueue () {
		
		stackSize = 0;
	}
	
	@Override
	public boolean isEmpty() {
       
		if (topStack == -1) {
			
			return true;
		}
		

		return false;
	}

	@Override
	public boolean isFull() {
		if (topStack == stackSize-1) {
			
			return true;
		}
		
		return false;
	}


	@Override
	public T dequeue() throws QueueUnderflowException {
		 
		if (isEmpty()) {
			
			throw new QueueUnderflowException();	
		}
		T y = Array[bottomStack];
		
		for( int x = 0; x < topStack+1; x++) {
			Array[x] = Array[x+1];
		}
		
		 topStack --;
		
		return y;
	}

	@Override
	public int size() {
		
		return topStack+1;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
	
		if (isFull()) {
			
			throw new QueueOverflowException();	
		}
		
		 Array[topStack+1] = e;
		 topStack ++;
		 
		return true;
	}
	@Override
	public String toString() {
		String y = "";
		
		for (int i=0; i< topStack+1; i++) {
			y += Array[i];
			
		}
		return y;
	}
		
	@Override
	public String toString(String delimiter) {
		
		String y = "";
		
		for (int i=0; i< topStack+1; i++) {
			
			y += Array[i];
			y+= delimiter;
			
		}
		y = y.substring(0, y.length()-1);
		
		return y;
	}
	

	@Override
	public void fill(ArrayList<T> list) {
		
		for( T y: list) {
			
			Array[++topStack] = y;
		}
		
		
	}

}
