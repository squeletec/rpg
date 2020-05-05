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

Statement1: {
	ListOfStatement -> ListOfStatement Statement • [End, Identifier, LPar]
}

*/

import foundation.rpg.parser.UnexpectedInputException;
import javax.annotation.Generated;

@Generated("Generated visitor pattern based state for grammar parser.")
public class StateStatement1 extends StackState<foundation.rpg.sample.language.ast.Statement, StackState<java.util.List<foundation.rpg.sample.language.ast.Statement>, ? extends State>> {
    // Stack:
    public StateStatement1(foundation.rpg.sample.language.ast.Statement node, StackState<java.util.List<foundation.rpg.sample.language.ast.Statement>, ? extends State> prev) {
        super(node, prev);
    }


    // Reduce:
    @Override
    public State visitIdentifier(foundation.rpg.sample.language.ast.Identifier symbol) throws UnexpectedInputException {
        
		StackState<java.util.List<foundation.rpg.sample.language.ast.Statement>, ? extends State> stack1 = this.getPrev();
		State stack2 = stack1.getPrev();
        return stack2.visitListOfStatement(foundation.rpg.common.ListRules.isList1(stack1.getNode(), this.getNode())).visitIdentifier(symbol);
    }

    @Override
    public State visitLPar(foundation.rpg.common.LPar symbol) throws UnexpectedInputException {
        
		StackState<java.util.List<foundation.rpg.sample.language.ast.Statement>, ? extends State> stack1 = this.getPrev();
		State stack2 = stack1.getPrev();
        return stack2.visitListOfStatement(foundation.rpg.common.ListRules.isList1(stack1.getNode(), this.getNode())).visitLPar(symbol);
    }

    @Override
    public State visitEnd(foundation.rpg.common.End symbol) throws UnexpectedInputException {
        
		StackState<java.util.List<foundation.rpg.sample.language.ast.Statement>, ? extends State> stack1 = this.getPrev();
		State stack2 = stack1.getPrev();
        return stack2.visitListOfStatement(foundation.rpg.common.ListRules.isList1(stack1.getNode(), this.getNode())).visitEnd(symbol);
    }


    // Shift:
    // Accept:
}