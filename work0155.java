package Leetcode.smart;

import java.util.Stack;

public class work0155 {
	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(0);
		m.push(1);
		m.push(0);
		m.getMin();
		m.pop();
		System.out.println(m.getMin());
	}
}
class MinStack {
	Stack<Integer> stack = new Stack<>();
	int min=Integer.MAX_VALUE;
    /** 标记法 */
    public MinStack() {

    }
    
    public void push(int x) {
    	if(min>=x) {
    		//将原来的最小值存入栈中
    		if(!stack.empty()) {
    			stack.push(min);
    		}
    		min = x; 
    	} 
    	stack.push(x);
    }
    
    public void pop() {
    	if(stack.empty()) return;
    	if(stack.size()==1) {
    		min=Integer.MAX_VALUE;
		} else if (min == stack.peek()) {
			stack.pop();
			min = stack.peek();
		}
    	stack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return min;
    }
}

 class MinStack2 {
	//双栈法
	Stack<Integer> datastack = new Stack<>();
	Stack<Integer> minstack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack2() {
    	
    }
    public void push(int x) {
    	datastack.push(x);
    	if(minstack.empty()||x<=minstack.peek()) {
    		minstack.push(x);
    	}else {
    		minstack.push(minstack.peek());
    	}
    }
    public void pop() {
    	datastack.pop();
    	minstack.pop();
    }
    
    public int top() {
    	return datastack.peek();
    }
    
    public int getMin() {
    	return minstack.peek();
    }
}