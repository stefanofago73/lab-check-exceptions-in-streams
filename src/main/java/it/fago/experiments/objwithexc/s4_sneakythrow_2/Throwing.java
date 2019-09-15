package it.fago.experiments.objwithexc.s4_sneakythrow_2;

/**
 * 
 * @author Stefano Fago
 *
 */
class Throwing {

		@SuppressWarnings("unchecked")
		static <T extends Throwable, T1, R> R operateAndSneakyThrow(ThrowingFunction<T1, R> operator, T1 data) throws T {
			try {
				return operator.call(data);
			} catch (Throwable t) {
				throw (T) t;
			}
		}
	
}//END
