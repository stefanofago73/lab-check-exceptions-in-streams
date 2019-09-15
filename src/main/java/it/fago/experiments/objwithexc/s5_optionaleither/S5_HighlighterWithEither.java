package it.fago.experiments.objwithexc.s5_optionaleither;

import java.util.List;

import static it.fago.experiments.objwithexc.s5_optionaleither.QuiteEitherAdapter.of;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

import it.fago.experiments.objwithexc.HighlightProcessor;


/**
 * 
 * @author Stefano Fago
 *
 */
public class S5_HighlighterWithEither {

	public static List<String> highlight(List<String> arguments,HighlightProcessor processor) {
	   return
		  arguments
		    .stream()
	           .map(of(processor::methodThatThrows))
	         .filter(QuiteEither::isValue)
	         .map(QuiteEither::value)
	     .collect(toList());	
	}
	
}//END

