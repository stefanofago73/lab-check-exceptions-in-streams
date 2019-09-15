package it.fago.experiments.objwithexc.s1_translate;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import it.fago.experiments.objwithexc.HighlightProcessor;

/**
 * 
 * @author Stefano Fago
 *
 */
public class S1_Highlighter {

	public static List<String> highlight(List<String> arguments, HighlightProcessor processor) {
		return 
		    arguments
				.stream()
				  .map(protectedExecutionWith(processor))
				.collect(toList());
	}

	//
	// this become the commodity method used to have the reference method
	// that can be used with Stream in the specific case.
	//
	private static Function<String, String> protectedExecutionWith(HighlightProcessor processor) {
		return data -> {
			try {
				return processor.methodThatThrows(data);
			} catch (IOException e) {
				//
				// Here translate the Checked Exception to a Stack-less Runtime
				// Exception...
				//
				throw OperationWrapException.from(e);
			}
		};
	}

}// END