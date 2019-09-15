package it.fago.experiments.objwithexc.s7_spliterator;

import static it.fago.experiments.objwithexc.s7_spliterator.ThrowingFunction.define;
import static it.fago.experiments.objwithexc.s7_spliterator.ThrowingFunction.defineSafe;
import static it.fago.experiments.objwithexc.s7_spliterator.ThrowingFunction.of;
import static java.util.stream.Collectors.toList;

import java.util.List;

import it.fago.experiments.objwithexc.HighlightProcessor;

/**
 * 
 * @author Stefano Fago
 *
 */
public class S7_Highlighter {

	//
	//  You can use:
	//
	//   defineSafe(...) that suppress the exception
	//
	//   define(...) that throws exception 
	//
	
	/**
	 * 
	 * @param arguments
	 * @param processor
	 * @return
	 */
	public static List<String> highlight(List<String> arguments,HighlightProcessor processor){
		return
		   define(arguments)
		      .map(of(processor::methodThatThrows))
		 .collect(toList());
	}

	/**
	 * 
	 * @param arguments
	 * @param processor
	 * @return
	 */
	public static List<String> highlightSafe(List<String> arguments,HighlightProcessor processor){
		return
		   defineSafe(arguments)
		      .map(of(processor::methodThatThrows))
		 .collect(toList());
	}
	
}// END