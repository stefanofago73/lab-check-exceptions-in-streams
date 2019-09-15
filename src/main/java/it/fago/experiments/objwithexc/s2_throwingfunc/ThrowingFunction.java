package it.fago.experiments.objwithexc.s2_throwingfunc;

import java.util.function.Function;

/**
 * 
 * @author Stefano
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface ThrowingFunction<T, R> {

	R call(T t1) throws Throwable;

	static <T, R> Function<T, R> of(ThrowingFunction<T, R> mapFunction) {
		return data -> {
			try {
				return mapFunction.call(data);
			} catch (Throwable err) {
				//
				// Here translate the Exception to a Stack-less Runtime Exception... 
				//
				throw OperationWrapException.from(err);
			}
		};
	}

}// END
