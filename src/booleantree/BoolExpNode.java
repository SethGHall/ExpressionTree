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
public abstract class BoolExpNode {
    public BoolExpNode leftChild;
    public BoolExpNode rightChild;
 
    protected char symbol;
    
    public BoolExpNode(char value)
    {
        this.symbol = value;
    }
    @Override
    public String toString()
    {
        return ""+symbol;
    }
    public abstract boolean evaluate() throws ArithmeticException;
}
