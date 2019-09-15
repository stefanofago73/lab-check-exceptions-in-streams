package it.fago.experiments.objwithexc.s7_spliterator;

/**
 * 
 * @author Stefano Fago
 *
 */
class Throwing {

	@SuppressWarnings("unchecked")
	static <T extends Throwable, R> R sneakyThrow(Throwable t) throws T {
		throw (T) t;
	}
	
}//END
