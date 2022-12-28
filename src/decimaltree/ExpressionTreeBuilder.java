/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decimaltree;

import java.util.Stack;

/**
 *
 * @author Seth
 */
public class ExpressionTreeBuilder {
 
    public static ExpNode buildExpressionTree(String[] postfix) throws ArithmeticException
    {   
        Stack<ExpNode> stack = new Stack<ExpNode>();
       // ExpNode parent = null;
        for(int i=0;i<postfix.length;i++)
        {
            if(checkOperand(postfix[i]))
                stack.push(new OperandNode(postfix[i]));
            else if(checkOperator(postfix[i]))
            {   ExpNode parent = new OperatorNode(postfix[i]);
                parent.rightChild = stack.pop();
                if(postfix[i].charAt(0) != '~')
                   parent.leftChild = stack.pop();
                       
                stack.push(parent);
            }
        }
        if(stack.size() != 1)
            throw new ArithmeticException("POST FIX EXPRESSION NOT CORRECT ");
        return stack.pop();
    }
    private static boolean checkOperator(String value)
    {   return (value.equals("*") || value.equals("~") || value.equals("-")  || value.equals("/")  || value.equals("+"));
    }
    private static boolean checkOperand(String value)
    {  try
        {
           Double.parseDouble(value);
           return true;
        }
        catch(NumberFormatException e)
        {   return false;
        }
    }

    /*
    Algorithm infix (tree)
    
    */
    public static String toInfixString(ExpNode node)
    {   String exp = "";
        if(node == null)
            return "";
        String symbol = node.toString();
        if(node instanceof OperatorNode)
            exp += "(";
        exp += toInfixString(node.leftChild);
        exp += node.symbol;
        exp += toInfixString(node.rightChild);
        if(node instanceof OperatorNode)
            exp += ")";
        return exp;
    }
    
    public static int countNodes(ExpNode node){
       
       if(node == null)
           return 0;
       
       else return countNodes(node.leftChild) + 1 + countNodes(node.rightChild);
          
   }
    
    public static void main(String[] args)
    {
        String expression = "10 5 4 5 + - *";
        String[] regs = expression.split(" ");
        //String expression = "TF|!";
        ExpNode root = buildExpressionTree(regs);
        
        System.out.println(toInfixString(root));
        
        System.out.println("EVALUATION IS "+root.evaluate());
        
    }
}
