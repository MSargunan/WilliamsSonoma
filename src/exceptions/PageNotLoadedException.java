
package exceptions;

/**
 * Exception Class
 */
public class PageNotLoadedException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MSG = "Page did not load within the time out";

	public PageNotLoadedException() {
		super(DEFAULT_MSG);
	}

	public PageNotLoadedException(String reason) {
		super(reason);
	}

}
