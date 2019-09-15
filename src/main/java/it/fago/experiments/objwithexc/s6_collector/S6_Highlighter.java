package it.fago.experiments.objwithexc.s6_collector;

import static it.fago.experiments.objwithexc.s6_collector.OptionalAdapter.of;
import static it.fago.experiments.objwithexc.s6_collector.OptionalCollector.toValuesOr;

import java.util.List;

import it.fago.experiments.objwithexc.HighlightProcessor;

/**
 * 
 * @author Stefano
 *
 */
public class S6_Highlighter {

	public final static String VALUE_IF_EMPTY ="";
	
	public static List<String> highlight(List<String> arguments,HighlightProcessor processor){	    
	   return
		   arguments
		     .stream()
			    .map(of(processor::methodThatThrows))
			 .collect(toValuesOr(VALUE_IF_EMPTY ));	
	}
	
	
}//END

