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

package foundation.fluent.jast.parser.generator;

public interface LrAction {

    void accept(LrActionVisitor visitor);

    interface LrActionVisitor {
        void visitGoto(LrItemSet set);
        void visitReduction(LrItem item);
        void visitAccept(LrItem item);
    }

    class Goto implements LrAction {
        private final LrItemSet to;

        public Goto(LrItemSet to) {
            this.to = to;
        }

        @Override
        public String toString() {
            return "GOTO: " + to.getName();
        }

        @Override
        public void accept(LrActionVisitor visitor) {
            visitor.visitGoto(to);
        }
    }

    class Reduce implements LrAction {
        private final LrItem item;

        public Reduce(LrItem item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "REDUCE: " + item;
        }

        @Override
        public void accept(LrActionVisitor visitor) {
            visitor.visitReduction(item);
        }
    }

    class Accept implements LrAction {
        private final LrItem item;

        public Accept(LrItem item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "ACCEPT: " + item;
        }

        @Override
        public void accept(LrActionVisitor visitor) {
            visitor.visitAccept(item);
        }
    }
}
