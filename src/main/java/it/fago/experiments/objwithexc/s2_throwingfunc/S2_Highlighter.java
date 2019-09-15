package it.fago.experiments.objwithexc.s2_throwingfunc;

import static it.fago.experiments.objwithexc.s2_throwingfunc.ThrowingFunction.of;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import it.fago.experiments.objwithexc.HighlightProcessor;

/**
 * 
 * @author Stefano Fago
 *
 */
public class S2_Highlighter {

	public static List<String> highlight(List<String> arguments,HighlightProcessor processor) {
		return 
		    arguments
			    .stream()
				    .map(of(processor::methodThatThrows))
				.collect(toList());
	}

}// END
