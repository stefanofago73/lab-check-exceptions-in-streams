package it.fago.experiments.objwithexc.s3_sneakythrow_1;

/**
 * 
 * Inner commodity used to manage Checked Exception like Runtime Exception
 * Not available outside this package!
 * 
 * @author Stefano
 *
 */
class Throwing {

	@SuppressWarnings("unchecked")
	static <T extends Throwable, R> R sneakyThrow(Throwable t) throws T {
		throw (T) t;
	}
	
}//END
