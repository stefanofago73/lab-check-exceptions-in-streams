package it.fago.experiments.objwithexc.s7_spliterator;

import static it.fago.experiments.objwithexc.s7_spliterator.Throwing.sneakyThrow;
import static java.util.Spliterator.CONCURRENT;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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

	public static <T> Stream<T> define(Collection<T> coll) {
		Spliterator<T> spliterator = coll.spliterator();
		return StreamSupport.stream(new SplitDecorator<>(spliterator), spliterator.hasCharacteristics(CONCURRENT));
	}

	@SafeVarargs
	public static <T> Stream<T> define(T... args) {
		Spliterator<T> spliterator = Arrays.asList(args).spliterator();
		return StreamSupport.stream(new SplitDecorator<>(spliterator), spliterator.hasCharacteristics(CONCURRENT));
	}

	public static <T> Stream<T> defineSafe(Collection<T> coll) {
		Spliterator<T> spliterator = coll.spliterator();
		return StreamSupport.stream(new SplitDecorator<>(spliterator, true),
				spliterator.hasCharacteristics(CONCURRENT));
	}

	@SafeVarargs
	public static <T> Stream<T> defineSafe(T... args) {
		Spliterator<T> spliterator = Arrays.asList(args).spliterator();
		return StreamSupport.stream(new SplitDecorator<>(spliterator, true),
				spliterator.hasCharacteristics(CONCURRENT));
	}

}// END