package it.fago.experiments.objwithexc.s0_basic;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;

import it.fago.experiments.objwithexc.HighlightProcessor;

/**
 * 
 * @author Stefano Fago
 *
 */
public class S0_Highlighter {

	public static List<String> highlight(List<String> arguments,HighlightProcessor processor) {
		return 
		  arguments
		      .stream()
			      //
			      // map take a Function<R,T> that not support throwing Exception
			      // ...so I'm forced to do as follow...
			      //
			      .map(t -> {
					 try {
						return processor.methodThatThrows(t);
					 } catch (IOException e) {
						throw new RuntimeException("Problem during stream processing!",e);
				      }
			    })
			  .collect(toList());
   }

}// END