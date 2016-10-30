package sr.core;

import java.text.SimpleDateFormat;

/**
 * Constantes
 * 
 * @author juan.soruco
 *
 */
public class K {
	public static final String TRANSACTION_DELETED_STATUS = "I";
	
	public static ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("ddMMyyyy HH:mm:ss,SSS");
		}
	};
}
