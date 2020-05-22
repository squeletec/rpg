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

package foundation.rpg.generator;

import foundation.rpg.grammar.Grammar;
import foundation.rpg.grammar.Symbol;
import foundation.rpg.automata.LrParserConstructor;
import foundation.rpg.automata.LrParserAutomata;
import org.testng.annotations.Test;

import static foundation.rpg.generator.GeneratorTest.Symbols.*;
import static foundation.rpg.grammar.Rule.Builder.setOf;
import static foundation.rpg.grammar.Rule.rule;
import static java.util.Collections.emptySet;

public class GeneratorTest {

    public enum Symbols implements Symbol { S, A, a }

    @Test
    public void testParser() {
        Grammar grammar = new Grammar(S, setOf(ε, a), setOf(S, A), setOf(
                rule(S).to(A, ε),
                rule(A).to(a, A)
        ), emptySet());
        LrParserAutomata parser = LrParserConstructor.generateParser(grammar);
        System.out.println(parser);
    }

}