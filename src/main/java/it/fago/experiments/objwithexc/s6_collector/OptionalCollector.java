package it.fago.experiments.objwithexc.s6_collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 
 * @author Stefano Fago
 *
 */
public interface OptionalCollector {

	static <T> Collector<Optional<T>, List<T>, List<T>> toValuesOr(T defaultValue){
		final Supplier<List<T>> supplier = ArrayList::new;
		final BiConsumer<List<T>, Optional<T>> accumulator = (list,value)->list.add(value.orElse(defaultValue));
		final BinaryOperator<List<T>> combiner = (l,r)->{
			l.addAll(r);
			return l;
		};
		return Collector.of(supplier,accumulator,combiner);
	}

}
