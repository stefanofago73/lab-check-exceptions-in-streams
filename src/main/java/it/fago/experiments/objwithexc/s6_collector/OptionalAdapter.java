package it.fago.experiments.objwithexc.s6_collector;

import java.util.Optional;
import java.util.function.Function;

@FunctionalInterface
public interface OptionalAdapter<T, R> {

	R call(T t1) throws Throwable;

	
	static <T, R> Function<T,Optional<R>> of(OptionalAdapter<T, R> mapFunction) {
		return data->{
			try {
			return Optional.ofNullable(mapFunction.call(data));
		  } catch (Throwable t) {
			return Optional.empty();
		  }
	  };
	}
	
}//END
