package it.fago.experiments.objwithexc.s3_sneakythrow_1;

import java.util.List;

import static it.fago.experiments.objwithexc.s3_sneakythrow_1.ThrowingFunction.of;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

import it.fago.experiments.objwithexc.HighlightProcessor;

/**
 * 
 * @author Stefano Fago
 *
 */
public class S3_Highlighter {

	public static List<String> highlight(List<String> arguments,HighlightProcessor processor) {
		return 
			arguments
			  .stream()
	             .map(of(processor::methodThatThrows))
	          .collect(toList());
	}
	
}//END

