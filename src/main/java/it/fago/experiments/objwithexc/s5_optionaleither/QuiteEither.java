package it.fago.experiments.objwithexc.s5_optionaleither;

/**
 * ...An incomplete Either abstraction made only to
 * demonstrate the concept...
 * 
 * @author Stefano
 *
 * @param <T>
 */
public class QuiteEither<T> {

	public static <T> QuiteEither<T> of(T some){
		return new QuiteEither<>(some,null);
	}
	
	public static <T> QuiteEither<T> of(Throwable error){
		return new QuiteEither<>(null,error);
	} 
	
	private final T value;
	private final Throwable error;
	
	public QuiteEither(T value, Throwable error){
		this.value = value;
		this.error= error;
	}
	
	
	public final boolean isValue(){
		return this.error==null;
	}
	
	public final T value(){
		return value;
	}
	
	
	public final <U extends Throwable> U error(){
		@SuppressWarnings("unchecked")
		final U toReturn = (U)error;
		return toReturn;
	}
	
	//
	// here, we are loosing or monadic methods needed to complete the abstraction...
	//
	
}//END