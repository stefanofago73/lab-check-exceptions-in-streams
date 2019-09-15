package it.fago.experiments.objwithexc.s5_optionaleither;

import java.util.function.Function;

@FunctionalInterface
public interface QuiteEitherAdapter<T, R> {

	R call(T t1) throws Throwable;

	static <T, R> Function<T,QuiteEither<R>> of(QuiteEitherAdapter<T, R> mapFunction) {
		return data->{
			try {
			return QuiteEither.of(mapFunction.call(data));
		  } catch (Throwable t) {
			return QuiteEither.of(t);
		  }
	  };
	}
	
}//END
