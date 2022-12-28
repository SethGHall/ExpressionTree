/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleantree;

/**
 *
 * @author Seth
 */
public class BoolOperatorNode extends BoolExpNode{

    public BoolOperatorNode(char value) {
        super(value);
    }

    @Override
    public boolean evaluate() {
        if(rightChild != null && symbol == '!')
            return !rightChild.evaluate();
        else if(rightChild != null && leftChild != null)
        {
           switch(symbol)
           {    case '|' : return rightChild.evaluate()|leftChild.evaluate();
                case '&' : return rightChild.evaluate()&leftChild.evaluate();
                case '^' : return rightChild.evaluate()^leftChild.evaluate();  
                default : throw new ArithmeticException(" UNKNOWN SYMBOL ");
           }  
        }
        else
            throw new ArithmeticException(" MISSING CHILDREN CANNOT EVALUATE ");
    }
    
    
}
