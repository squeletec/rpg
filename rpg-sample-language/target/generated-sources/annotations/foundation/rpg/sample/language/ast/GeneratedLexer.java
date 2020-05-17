package foundation.rpg.sample.language.ast;

import foundation.rpg.parser.Element;
import foundation.rpg.parser.Lexer;
import foundation.rpg.parser.Input;
import foundation.rpg.parser.Position;
import foundation.rpg.parser.End;
import java.io.IOException;
import foundation.rpg.parser.TokenBuilder;

public class GeneratedLexer implements Lexer<State> {
	public Element<State> next(Input input) throws IOException {
		int state = 0;
		int symbol = input.lookahead();
		TokenBuilder builder = new TokenBuilder(input);
		if(symbol < 0) return visitor -> visitor.visitEnd(new End(builder.build()));
		for(; true; symbol = builder.next()) {
			switch(state) {
				case 0:
					switch(symbol) {
						case '.': state = 1; break;
						case '+': state = 2; break;
						case '(': state = 3; break;
						case ')': state = 4; break;
						case ',': state = 5; break;
						default:
							if(matchesGroup("w", symbol)) { state = 6; break; }
							throw new IllegalStateException("");
					}
					break;
				case 1:
					return visitor -> visitor.visitDot(new foundation.rpg.common.Dot(builder.build()));
				case 2:
					return visitor -> visitor.visitPlus(new foundation.rpg.common.Plus(builder.build()));
				case 3:
					return visitor -> visitor.visitLPar(new foundation.rpg.common.LPar(builder.build()));
				case 4:
					return visitor -> visitor.visitRPar(new foundation.rpg.common.RPar(builder.build()));
				case 5:
					return visitor -> visitor.visitComma(new foundation.rpg.common.Comma(builder.build()));
				case 6:
					if(matchesGroup("a", symbol)) { state = 7; break; }
					return visitor -> visitor.visitIdentifier(new foundation.rpg.sample.language.ast.Identifier(builder.build().getContent()));
				case 7:
					if(matchesGroup("a", symbol)) { state = 7; break; }
					return visitor -> visitor.visitIdentifier(new foundation.rpg.sample.language.ast.Identifier(builder.build().getContent()));
			}
		}
	}
}