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
public class OperandNode extends ExpNode{
    
    private double value;
    
    public OperandNode(String symbol) {
        super(symbol);
        value = Double.parseDouble(symbol);
        
    }

    @Override
    public double evaluate() {
        return value;
    }
}
