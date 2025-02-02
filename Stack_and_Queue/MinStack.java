import java.util.Stack;

class Pair{
	int val;
	int min;

	Pair(int val, int min){
		this.val = val;
		this.min = min;
	}
}

class MinStack{
	Stack<Pair> st;

	MinStack(){
		st = new Stack<>();
	}

	public void push(int x){
		int min;
		if(st.isEmpty()) min = x;
		else
			min = Math.min(st.peek().min, x);
		st.push(new Pair(x, min));
		System.out.println("Pushed value is: " + x);
	}

	public int pop(){
		return st.pop().val;
	}

	public int peek(){
		return st.peek().val;
	}

	public int getMin(){
		return st.peek().min;
	}
}

class Implementation{
	public static void main(String[] args){
		MinStack ms = new MinStack();
		ms.push(12);
		ms.push(15);
		ms.push(10);
		System.out.println("Min value is: " + ms.getMin());
		System.out.println("Deleted value is: " + ms.pop());
		System.out.println("Top Element is: " + ms.peek());
		System.out.println("Min value is: " + ms.getMin());
	}
}