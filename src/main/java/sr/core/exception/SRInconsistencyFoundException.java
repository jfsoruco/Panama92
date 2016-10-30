package sr.core.exception;

/**
 * Excepcion para controlar inconsistencias encontradas
 * 
 * @author juan.soruco
 *
 */
public class SRInconsistencyFoundException extends SRException {
	private static final long serialVersionUID = 1629754925143534304L;

	private static final String MESSAGE_FORMAT = "Contact with id: '%d' do not correspond to property: '%d'";

	String developerInfo;

	/**
	 * Created an Exception with a message for the user related directly to the
	 * parameters received and the message format defined for this id:
	 * MESSAGE_FORMAT (Related to any Inconsistency..)
	 * 
	 * @param contactId
	 *            Assumed as a contactId
	 * @param propertyId
	 *            Property Id
	 * @param developerMessage
	 *            Technical information to help developer (Ui and backend to
	 *            manage the error)
	 */
	public SRInconsistencyFoundException(Integer contactId, Integer propertyId, String developerMessage) {
		super(String.format(MESSAGE_FORMAT, contactId, propertyId), developerMessage);
	}

	/**
	 * Create and exception with an specific message for the user defined by the
	 * developer (Related to any Inconsistency..)
	 * 
	 * @param message
	 *            Specific message to the User
	 * @param developerMessage
	 *            Technical information to help developer (Ui and backend to
	 *            manage the error)
	 */
	public SRInconsistencyFoundException(String message, String developerMessage) {
		super(message, developerMessage);
	}
}
