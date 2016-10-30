package sr.core.exception;

/**
 * Excepcion para controlar datos no encontrados
 * 
 * @author juan.soruco
 *
 */
public class SRNoDataFoundException extends SRException {

	private static final long serialVersionUID = -5175175756897667790L;

	/**
	 * Create and exception with an specific message for the user defined by the
	 * developer (Related to any Data not found..)
	 * 
	 * @param message
	 *            Specific message to the User
	 * @param developerCode
	 *            Some code generated and managed by developer for specific
	 *            error
	 * @param developerMessage
	 *            Technical information to help developer (Ui and backend to
	 *            manage the error)
	 */
	public SRNoDataFoundException(String message, String developerMessage) {
		super(message, developerMessage);
	}

}
