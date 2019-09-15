package it.fago.experiments.objwithexc.s3_sneakythrow_1;

import static it.fago.experiments.objwithexc.s3_sneakythrow_1.Throwing.sneakyThrow;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Function;

/**
 * 
 * @author Stefano Fago
 *
 * @param <T1>
 * @param <R>
 */
@FunctionalInterface
interface ThrowingFunction<T1, R> extends Serializable, Function<T1, R> {

	static <T1, R> ThrowingFunction<T1, R> of(ThrowingFunction<T1, R> f) {
		return f;
	}

	R call(T1 t1) throws Throwable;

	default R apply(T1 t1) {
		try {
			return call(t1);
		} catch (Throwable x) {
			return sneakyThrow(x);
		}
	}

//========================================================================================
//  ...Maybe you want a complete support for this Functional Interface so you define
//  the composition and chaining relate methods... 	
//========================================================================================
//	
//	default <V> ThrowingFunction<V, R> compose(Function<? super V, ? extends T1> before) {
//		Objects.requireNonNull(before);
//		return (V v) -> call(before.apply(v));
//	}
//
//	default <V> ThrowingFunction<T1, V> andThen(Function<? super R, ? extends V> after) {
//		Objects.requireNonNull(after);
//		return (T1 t1) -> after.apply(call(t1));
//	}
//
//	static <T> ThrowingFunction<T, T> identity() {
//		return t -> t;
//	}
//
//========================================================================================	
	
}//END