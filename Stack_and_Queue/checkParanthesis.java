// check for balanced paranthesis 

import java.util.Stack;

class Check{
	public static boolean checkParanthesis(String parn){
		Stack<Character> st = new Stack<>();

		for(char it: parn.toCharArray()){
			if(it == '(' || it == '{' || it == '[')
				st.push(it);
			else{
				if(st.empty()) return false;
				char top = st.pop();
				if(!((it == ']' && top =='[') || (it == '}' && top == '{') || (it == ')' && top == '(')))
					return false;
			}
		}
	
		return st.empty();
	}
}

class Paranthesis{
	public static void main(String[] args) {
		String parn = "{()[()]}";
		boolean yesORno = Check.checkParanthesis(parn);
		System.out.println(parn + " have balance Parnthesis: " + yesORno);
	}
}