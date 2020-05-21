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

RPar4: {
	AtomicExpression -> LPar Expression RPar • [RPar, Gt, Plus, Times, Comma]
}

*/

import foundation.rpg.parser.UnexpectedInputException;

// Generated visitor pattern based state for grammar parser.
public class StateRPar4 extends StackState<foundation.rpg.common.RPar, StackState<foundation.rpg.sample.language.ast.Expression, StackState<foundation.rpg.common.LPar, ? extends State>>> {

// NoStack:
// Stack:
    public StateRPar4(foundation.rpg.sample.language.ast.AstFactory factory, foundation.rpg.common.RPar node, StackState<foundation.rpg.sample.language.ast.Expression, StackState<foundation.rpg.common.LPar, ? extends State>> prev) {
        super(factory, node, prev);
    }


// Reduce:
    @Override
    public State visitRPar(foundation.rpg.common.RPar symbol) throws UnexpectedInputException {
        
		StackState<foundation.rpg.sample.language.ast.Expression, StackState<foundation.rpg.common.LPar, ? extends State>> stack1 = this.getPrev();
		StackState<foundation.rpg.common.LPar, ? extends State> stack2 = stack1.getPrev();
		State stack3 = stack2.getPrev();
        return stack3.visitAtomicExpression(getFactory().is(stack2.getNode(), stack1.getNode(), this.getNode())).visitRPar(symbol);
    }

    @Override
    public State visitGt(foundation.rpg.common.Gt symbol) throws UnexpectedInputException {
        
		StackState<foundation.rpg.sample.language.ast.Expression, StackState<foundation.rpg.common.LPar, ? extends State>> stack1 = this.getPrev();
		StackState<foundation.rpg.common.LPar, ? extends State> stack2 = stack1.getPrev();
		State stack3 = stack2.getPrev();
        return stack3.visitAtomicExpression(getFactory().is(stack2.getNode(), stack1.getNode(), this.getNode())).visitGt(symbol);
    }

    @Override
    public State visitPlus(foundation.rpg.common.Plus symbol) throws UnexpectedInputException {
        
		StackState<foundation.rpg.sample.language.ast.Expression, StackState<foundation.rpg.common.LPar, ? extends State>> stack1 = this.getPrev();
		StackState<foundation.rpg.common.LPar, ? extends State> stack2 = stack1.getPrev();
		State stack3 = stack2.getPrev();
        return stack3.visitAtomicExpression(getFactory().is(stack2.getNode(), stack1.getNode(), this.getNode())).visitPlus(symbol);
    }

    @Override
    public State visitTimes(foundation.rpg.common.Times symbol) throws UnexpectedInputException {
        
		StackState<foundation.rpg.sample.language.ast.Expression, StackState<foundation.rpg.common.LPar, ? extends State>> stack1 = this.getPrev();
		StackState<foundation.rpg.common.LPar, ? extends State> stack2 = stack1.getPrev();
		State stack3 = stack2.getPrev();
        return stack3.visitAtomicExpression(getFactory().is(stack2.getNode(), stack1.getNode(), this.getNode())).visitTimes(symbol);
    }

    @Override
    public State visitComma(foundation.rpg.common.Comma symbol) throws UnexpectedInputException {
        
		StackState<foundation.rpg.sample.language.ast.Expression, StackState<foundation.rpg.common.LPar, ? extends State>> stack1 = this.getPrev();
		StackState<foundation.rpg.common.LPar, ? extends State> stack2 = stack1.getPrev();
		State stack3 = stack2.getPrev();
        return stack3.visitAtomicExpression(getFactory().is(stack2.getNode(), stack1.getNode(), this.getNode())).visitComma(symbol);
    }


// Shift:
// Accept:
}
