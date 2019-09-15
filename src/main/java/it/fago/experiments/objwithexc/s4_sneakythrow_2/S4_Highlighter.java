package it.fago.experiments.objwithexc.s4_sneakythrow_2;

import static it.fago.experiments.objwithexc.s4_sneakythrow_2.ThrowingFunction.throwing;
import static java.util.stream.Collectors.toList;

import java.util.List;

import it.fago.experiments.objwithexc.HighlightProcessor;

/**
 * 
 * @author Stefano Fago
 *
 */
public class S4_Highlighter {

	public static List<String> highlight(List<String> arguments,HighlightProcessor processor) {
		return
		  arguments
		    .stream()
	          .map(throwing(processor::methodThatThrows))
	     .collect(toList());
	}
	
}//END

