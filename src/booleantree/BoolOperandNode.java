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
public class BoolOperandNode extends BoolExpNode{

    public BoolOperandNode(char value) {
        super(Character.toUpperCase(value));
    }

    @Override
    public boolean evaluate() {
        return(symbol == 'T');
    }
}
