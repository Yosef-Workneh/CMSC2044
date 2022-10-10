package application;

import java.util.ArrayList;

public class MyStack <T> implements StackInterface <T> {
	
	T [] Array;
	
	int topStack, stackSize;
	
	

	public MyStack (int size) {
		
		stackSize = size;
		topStack = -1;
		Array = (T[])new Object[stackSize];
	}
	
	public MyStack () {
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
	public T pop() throws StackUnderflowException {
        
		if (isEmpty()) {
			
			throw new StackUnderflowException();	
		}
		
		T x = Array[topStack];
		 topStack --;
		
		return x;
	}

	@Override
	public T top() throws StackUnderflowException {
         
		if (isEmpty()) {
			
			throw new StackUnderflowException();	
		}
		
		T x = Array[topStack];
		
		return x;
	}

	@Override
	public int size() {
		
		return topStack+1;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
	
	if (isFull()) {
			
			throw new StackOverflowException();	
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
