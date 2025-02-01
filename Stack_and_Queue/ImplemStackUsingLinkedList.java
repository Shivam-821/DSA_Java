// Implementation of Stack using LinkedList.

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

class StackIm{
	Node top = null;

	boolean isEmpty(){
		if(top == null) return true;
		return false;
	}
	void push(int x){
			Node new_node = new Node(x);
			new_node.next = top;
			top = new_node;
			System.out.println("Element added to Stack is: " + x);
	}

	int pop(){
		if(isEmpty){
			System.out.println("Stack underflow!")
			 throw new RuntimeException("Stack Underflow");
		}
		int val = top.data;
		top = top.next;

		return val;
	}

	int peek(){
		if(isEmpty){
			System.out.println("Stack underflow!");
			throw new RuntimeException("Stack Underflow")
		}

		return top.data;
	}

}

class Implementation{
	public static void main(String[] args) {
		StackIm st = new StackIm();
		st.push(12);
		st.push(25);
		st.push(57);
		System.out.println("Top Element of Stack is: " + st.peek());
		System.out.println("Deleted Element of Stack is: " + st.pop());
		System.out.println("Top Element of Stack is: " + st.peek());	
	}
	
}