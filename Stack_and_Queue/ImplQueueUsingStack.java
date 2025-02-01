// Implementation of Queue using Stack

import java.util.Stack;
class QueueIm{
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	void enqueue(int x){
		System.out.println("Enqueued value is: " + x);
		if(s1.size() == 0){
			s1.push(x);
		}
		else{
			while(!s1.empty()){
				s2.push(s1.pop());
			}
			s1.push(x);
			while(!s2.empty()){
				s1.push(s2.pop());
			}
		}
	}

	int dequeue(){
		if(s1.empty()){
			System.out.println("Queue is Empty");
		}
		int x = s1.pop();

		return x;
	}

	int top(){
		if(s1.empty()) return Integer.MIN_VALUE;
		return s1.peek();
	}

	int size(){
		if(s1.empty()) return -1;
		return s1.size();
	}

}

class Implementation{
	public static void main(String[] args){
		QueueIm q = new QueueIm();
		q.enqueue(20);
		q.enqueue(14);
		q.enqueue(25);
		System.out.println("Size of Queue is: " + q.size());
		System.out.println("Top Element of Queue is: " + q.top());
		System.out.println("Dequeued Element of Queue is: " + q.dequeue());
		System.out.println("Size of Queue is: " + q.size());
	}
}