package sr.core.exception;

/**
 * Excepcion para controlar parametros requeridos
 * 
 * @author juan.soruco
 *
 */
public class SREmptyRequiredParametersException extends SRException {

	private static final long serialVersionUID = 2345635452462716693L;
	
	private static final String USER_MESSAGE = "Existen parametros obligatorios vacios";
	private static final String DEVELOPER_MESSAGE = "Parametros obligatorios: %s";

	/**
	public SREmptyRequiredParametersException(String mandatoryParameters, OutputAsyncResponse outputAsyncResponse) {
		super(USER_MESSAGE, String.format(DEVELOPER_MESSAGE, mandatoryParameters));
		this.setOutputAsyncResponse(outputAsyncResponse);
	}
	*/
	
	public SREmptyRequiredParametersException(String mandatoryParameters) {
		super(USER_MESSAGE, String.format(DEVELOPER_MESSAGE, mandatoryParameters));
	}

}
