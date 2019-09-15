package it.fago.experiments.objwithexc.s2_throwingfunc;

/**
 * 
 * @author Stefano Fago
 *
 *         This is a Stackless Exception that not use specific costructor from
 *         java7+: this class force stackless by overidding of
 *         fillInStackTraceMethod
 * 
 */
public class OperationWrapException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7651205180947561176L;

	public OperationWrapException() {
		super();
	}

	public OperationWrapException(String message) {
		super(message);
	}

	public Throwable fillInStackTrace() {
		return this;
	}

	/**
	 * 
	 * This factory method translate a Throwable in an OperationWrapException
	 * that is a Stackless Runtime Exception. The original stacktrace become the
	 * new exception stacktrace as the message.
	 * 
	 * 
	 * @param error
	 * @return OperationWrapException
	 */
	public static final OperationWrapException from(Throwable error) {
		OperationWrapException e = new OperationWrapException(String.valueOf(error.getMessage()));
		e.setStackTrace(error.getStackTrace());
		return e;
	}

}// END
