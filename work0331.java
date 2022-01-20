package Leetcode.smart;

//331. 验证二叉树的前序序列化

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class work0331 {
    public static void main(String[] args) {
        work0331 w = new work0331();

        System.out.println(w.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));

    }

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        stack.push(1);
        while (i < nodes.length){
            if(stack.isEmpty()){
                return false;
            }
            Integer top = stack.pop()-1;
            if(nodes[i] .equals("#")){
                if(top > 0) stack.push(top);
            }else{
                if(top > 0) stack.push(top);
                stack.push(2);
            }
            i++;
        }
        return stack.isEmpty();
    }

}