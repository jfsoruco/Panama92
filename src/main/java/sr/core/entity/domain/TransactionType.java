package sr.core.entity.domain;

/**
 * types of transactions on MJ System
 * Type value should has max 10 chars 
 * 
 * @author juan.soruco
 *
 */
public enum TransactionType {
	//@off
	
	// REST Services
	
	// Data
	DATA_INSERT("addData"),
	DATA_UPDATE("updData"),
	DATA_DELETE("delData"),
	
	
	ERROR_LOG_CREATION("addErrorLog");
	//@on

	public String value;

	private TransactionType(String value) {
		this.value = value;
	}

}
