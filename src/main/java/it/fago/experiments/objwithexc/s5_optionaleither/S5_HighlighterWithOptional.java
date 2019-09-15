package it.fago.experiments.objwithexc.s5_optionaleither;

import static it.fago.experiments.objwithexc.s5_optionaleither.OptionalAdapter.of;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import it.fago.experiments.objwithexc.HighlightProcessor;

/**
 * 
 * @author Stefano Fago
 *
 */
public class S5_HighlighterWithOptional {

	public static List<String> highlight(List<String> arguments,HighlightProcessor processor) {
		return
		   arguments
		     .stream()
	            .map(of(processor::methodThatThrows))
	         .filter(Optional::isPresent)
	         .map(Optional::get)
	     .collect(toList());	
	}
	
	
}//END

