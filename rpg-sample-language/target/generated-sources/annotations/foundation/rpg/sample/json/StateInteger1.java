package foundation.rpg.sample.json;

import foundation.rpg.parser.UnexpectedInputException;
import foundation.rpg.parser.Named;

import java.util.Arrays;
import java.util.List;

// Generated visitor pattern based state for grammar parser.
public class StateInteger1 extends StackState<java.lang.Integer, State> {

// NoStack:
// Stack:
    public StateInteger1(foundation.rpg.sample.json.JsonFactory factory, java.lang.Integer node, State prev) {
        super(factory, node, prev);
    }


// Reduce:
    @Override
    public State visitEnd(foundation.rpg.parser.End symbol) throws UnexpectedInputException {
        State stack1 = this.getPrev();
        return stack1.visitObject(getFactory().is(this.getNode())).visitEnd(symbol);
    }


// Shift:
// Accept:
    @Override
    public List<Object> stack() {
        State stack1 = this.getPrev();
        return Arrays.asList(this.getNode());
    }

}
