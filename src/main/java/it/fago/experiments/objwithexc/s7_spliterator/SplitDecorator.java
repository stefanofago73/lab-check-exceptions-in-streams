package it.fago.experiments.objwithexc.s7_spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 
 *  A very simple decoration of a Spliterator...
 * 
 * @author Stefano Fago
 *
 * @param <T>
 */
public class SplitDecorator<T> implements Spliterator<T> {
	//
	private Spliterator<T> delegate;
	//
	private boolean isSafe;

	public SplitDecorator(Spliterator<T> delegate) {
		this(delegate, false);
	}

	public SplitDecorator(Spliterator<T> delegate, boolean isSafe) {
		this.delegate = delegate;
		this.isSafe = isSafe;
	}

	@Override
	public boolean tryAdvance(Consumer<? super T> action) {
		if (isSafe) {
			try {
				return delegate.tryAdvance(action);
			} catch (Exception exc) {
				return true;
			}
		}
		return delegate.tryAdvance(action);
	}

	@Override
	public Spliterator<T> trySplit() {
		Spliterator<T> trySplit = delegate.trySplit();
		return new SplitDecorator<>(trySplit);
	}

	@Override
	public long estimateSize() {
		return delegate.estimateSize();
	}

	@Override
	public int characteristics() {
		return delegate.characteristics();
	}

}// END