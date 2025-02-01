// Implementation of Stack using Queue.

import java.util.Queue;
import java.util.LinkedList;
class StackIm{
	Queue<Integer> q = new LinkedList<>();

	void push(int x){
		q.add(x);
		for(int i = 0; i < q.size() - 1; i++){
			q.add(q.remove());
		}
	}

	int pop(){
		if(q.isEmpty()) return Integer.MIN_VALUE;
		return q.remove();
	}

	int peek(){
		if(q.isEmpty()) return Integer.MIN_VALUE;
		return q.peek();
	}
}

class Implementation{
	public static void main(String[] args){
		StackIm st = new StackIm();
		st.push(5);
		st.push(8);
		st.push(12);
		System.out.println("Top Element of Stack is: " + st.peek());
		System.out.println("Deleted Element is: " + st.pop());
		System.out.println("Top Element of Stack is: " + st.peek());
	}
	
}