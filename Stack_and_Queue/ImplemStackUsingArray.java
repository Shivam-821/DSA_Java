// Implementation of Stack using Array. => Stack - LIFO

class StackImp{
	int size = 1000;
	int[] arr = new int[size];
	int top = -1;

	// pushing an element in stack
	int push(int x){
		if(top == size -1){
			System.out.println("Stack Overflow!");
			System.exit(1);
		}
		arr[++top] = x;
		return x;
	}

	// poping out element from the Stack
	int pop(){
		if(top == -1){
			System.out.println("Stack Underflow!");
			System.exit(1);
		}
		int x = arr[top];
		top--;

		return x;
	}

	// finding the top element of  Stack.
	int peek(){
		return arr[top];
	}

	// size of an Stack
	int size(){
		return top+1;
	}
}
class Implementation{
	public static void main(String[] args){
		StackImp st = new StackImp();
		System.out.println("Element added to Stack is: " + st.push(10));
		System.out.println("Element added to Stack is: " + st.push(12));
		System.out.println("Element added to Stack is: " + st.push(24));
		System.out.println("Top Element of Stack is: " + st.peek());
		System.out.println("Size of Stack is: " + st.size());
		System.out.println("Deleted Element of Stack is: " + st.pop());
		System.out.println("Element added to Stack is: " + st.push(8));
	}
}