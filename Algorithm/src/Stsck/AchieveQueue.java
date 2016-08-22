/*
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。 
 * 关键点是：在pop()中一定要判断stack2是否为空，如果为空才能将stack1的数据放入stack2中
 */

package Stsck;

import java.util.Stack;

public class AchieveQueue {
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();
	
	public static void push(int val){
		stack1.push(val);
	}
	
	public static int pop(){
		int temp = 0;
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				temp = stack1.pop();
				stack2.push(temp);
			}
		}
		return temp;
	}
}
