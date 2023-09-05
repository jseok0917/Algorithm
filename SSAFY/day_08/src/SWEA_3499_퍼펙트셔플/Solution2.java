package SWEA_3499_퍼펙트셔플;

import java.util.ArrayList;

class Queue<T>  {
	//배열로 큐를 구현할 것이기 때문에 배열의 크기를 N으로 지정해준다
	//생성시에도 반드시 크기를 포함하여 생성하도록 클래스를 만든다.
	public T t;
	public ArrayList<T> arr;
	public int front = -1;
	public int rear = -1;
	
	public Queue() {
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return front - rear == arr.length;
	}
	
	
}


public class Solution2 {
	public static void main(String[] args) {
		
	}

}
