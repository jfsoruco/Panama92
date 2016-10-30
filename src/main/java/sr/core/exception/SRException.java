package sr.core.exception;

import java.util.Map;

/**
 * Generico de excepciones
 * 
 * @author juan.soruco
 *
 */
public class SRException extends RuntimeException {
	private static final long serialVersionUID = -9938293934448282L;
	
	private String developerMessage;
	private String exceptionClassName;
	private Map<String,String> allPathVariables;
	private Object requestBody;
	private String userName;
	
	public SRException() {
		super();
	}
	public SRException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public SRException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public SRException(String message) {
		super(message);
	}
	
	public SRException(String message, String developerMessage) {
		super(message);
		this.developerMessage = developerMessage;
	}
	public SRException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public String getDeveloperMessage() {
		return developerMessage;
	}
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	public String getExceptionClassName() {
		return exceptionClassName;
	}
	public void setExceptionClassName(String exceptionClassName) {
		this.exceptionClassName = exceptionClassName;
	}
	public Map<String, String> getAllPathVariables() {
		return allPathVariables;
	}
	public void setAllPathVariables(Map<String, String> allPathVariables) {
		this.allPathVariables = allPathVariables;
	}
	public Object getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(Object requestBody) {
		this.requestBody = requestBody;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
