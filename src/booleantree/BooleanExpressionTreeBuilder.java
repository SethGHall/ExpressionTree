/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleantree;

import java.util.Stack;

/**
 *
 * @author Seth
 */
public class BooleanExpressionTreeBuilder {
 
    public static BoolExpNode buildExpressionTree(char[] postfix) throws ArithmeticException
    {   Stack<BoolExpNode> stack = new Stack<>();
        for(int i=0;i<postfix.length;i++)
        {
            if(checkOperand(postfix[i]))
                stack.push(new BoolOperandNode(postfix[i]));
            else if(checkOperator(postfix[i]))
            {   BoolExpNode parent = new BoolOperatorNode(postfix[i]);
                parent.rightChild = stack.pop();
                if(postfix[i] != '!')
                {   parent.leftChild = stack.pop();
                }       
                stack.push(parent);
            }
        }
        if(stack.size() != 1)
            throw new ArithmeticException("POST FIX EXPRESSION NOT CORRECT ");
        return stack.pop();
    }
    private static boolean checkOperator(char value)
    {   return (value == '&' || value == '|' || value == '!' || value == '^');
    }
    private static boolean checkOperand(char value)
    {   return (value == 't' || value == 'T' || value == 'F' || value == 'f');
    }
    
    /*
    Algorithm infix (tree)
    
    */
    public static String toInfixString(BoolExpNode node)
    {   String exp = "";
        if(node == null)
            return "";
        char symbol = node.toString().charAt(0);
        if(checkOperator(symbol) && symbol != '!')
            exp += "(";
        exp += toInfixString(node.leftChild);
        exp += node.symbol;
        exp += toInfixString(node.rightChild);
        if(checkOperator(symbol) && symbol != '!')
            exp += ")";
        return exp;
    }
    
    public static int countNodes(BoolExpNode node){
       if(node == null)
           return 0;
       else return countNodes(node.leftChild) + 1 + countNodes(node.rightChild);
   }
    
    
    public static void main(String[] args)
    {   String expression = "FT^";
        //String expression = "TF|!";
        BoolExpNode root = BooleanExpressionTreeBuilder.buildExpressionTree(expression.toCharArray());
        
        System.out.println(BooleanExpressionTreeBuilder.toInfixString(root));
        
        System.out.println("EVALUATION IS "+root.evaluate());
        
    }
}
