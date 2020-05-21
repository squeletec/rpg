/*
 * BSD 2-Clause License
 *
 * Copyright (c) 2020, Ondrej Fischer
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package foundation.rpg.sample.language.ast;

/*

List1ListOfStatement1: {
	Program -> List1ListOfStatement • [End]
	List1ListOfStatement -> List1ListOfStatement • Statement [End, Identifier, LPar]
	Statement -> • Expression Dot [End, Identifier, LPar]
	Expression -> • P1Expression$ [Dot]
	P1Expression$ -> • P2Expression$$ [Dot, Plus]
	P1Expression$ -> • P1Expression$ Plus P2Expression$$ [Dot, Plus]
	P2Expression$$ -> • P3Expression$$$ [Dot, Times, Plus]
	P2Expression$$ -> • P2Expression$$ Times P3Expression$$$ [Dot, Times, Plus]
	P3Expression$$$ -> • Identifier [Dot, Times, Plus]
	P3Expression$$$ -> • LPar Expression RPar [Dot, Times, Plus]
	P3Expression$$$ -> • Identifier LPar List3ListOfExpression RPar [Dot, Times, Plus]
}

*/

import foundation.rpg.parser.UnexpectedInputException;

// Generated visitor pattern based state for grammar parser.
public class StateList1ListOfStatement1 extends StackState<java.util.List<foundation.rpg.sample.language.ast.Statement>, State> {

// NoStack:
// Stack:
    public StateList1ListOfStatement1(foundation.rpg.sample.language.ast.AstFactory factory, java.util.List<foundation.rpg.sample.language.ast.Statement> node, State prev) {
        super(factory, node, prev);
    }


// Reduce:
    @Override
    public State visitEnd(foundation.rpg.parser.End symbol) throws UnexpectedInputException {
        
		State stack1 = this.getPrev();
        return stack1.visitProgram(getFactory().is(this.getNode())).visitEnd(symbol);
    }


// Shift:
    @Override
    public State visitStatement(foundation.rpg.sample.language.ast.Statement symbol) {
        return new StateStatement1(getFactory(), symbol, this);
    }

    @Override
    public State visitExpression(foundation.rpg.sample.language.ast.Expression symbol) {
        return new StateExpression1(getFactory(), symbol, this);
    }

    @Override
    public State visitP1Expression$(foundation.rpg.sample.language.ast.Expression symbol) {
        return new StateP1Expression$1(getFactory(), symbol, this);
    }

    @Override
    public State visitP2Expression$$(foundation.rpg.sample.language.ast.Expression symbol) {
        return new StateP2Expression$$1(getFactory(), symbol, this);
    }

    @Override
    public State visitP3Expression$$$(foundation.rpg.sample.language.ast.Expression symbol) {
        return new StateP3Expression$$$1(getFactory(), symbol, this);
    }

    @Override
    public State visitIdentifier(foundation.rpg.sample.language.ast.Identifier symbol) {
        return new StateIdentifier1(getFactory(), symbol, this);
    }

    @Override
    public State visitLPar(foundation.rpg.common.LPar symbol) {
        return new StateLPar1(getFactory(), symbol, this);
    }


// Accept:
}