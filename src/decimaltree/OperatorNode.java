/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decimaltree;

/**
 *
 * @author Seth
 */
public class OperatorNode extends ExpNode{

    public OperatorNode(String value) {
        super(value);
    }

    @Override
    public double evaluate() 
    {
        //if(rightChild != null && leftChild != null)
        {  
           switch(symbol)
           {    case "*" : return leftChild.evaluate()*rightChild.evaluate();
                case "+" : return leftChild.evaluate()+rightChild.evaluate();
                case "-" : return leftChild.evaluate()-rightChild.evaluate();  
                case "/" : return leftChild.evaluate()/rightChild.evaluate();
                case "~" : return 1.0 / rightChild.evaluate(); 
                default : throw new ArithmeticException(" UNKNOWN SYMBOL ");
           }  
        }
        //else
           // throw new ArithmeticException(" MISSING CHILDREN CANNOT EVALUATE ");
    }
    
    
}
