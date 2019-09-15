package it.fago.experiments.objwithexc.s4_sneakythrow_2;

import static it.fago.experiments.objwithexc.s4_sneakythrow_2.Throwing.operateAndSneakyThrow;

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

	static <T1, R> ThrowingFunction<T1, R> throwing(ThrowingFunction<T1, R> f) {
		return f;
	}

	R call(T1 t1) throws Throwable;

	default R apply(T1 t1) {
		return operateAndSneakyThrow(this, t1);

	}

	default <V> ThrowingFunction<V, R> compose(Function<? super V, ? extends T1> before) {
		Objects.requireNonNull(before);
		return (V v) -> call(before.apply(v));
	}

	default <V> ThrowingFunction<T1, V> andThen(Function<? super R, ? extends V> after) {
		Objects.requireNonNull(after);
		return (T1 t1) -> after.apply(call(t1));
	}

	static <T> ThrowingFunction<T, T> identity() {
		return t -> t;
	}


}// END