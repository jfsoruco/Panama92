package sr.core.sec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Utilitarios de seguridad. Debe complementarse al implementar la capa de seguridad
 * 
 * @author juan.soruco
 *
 */
public class SecTools {
	private static final Logger logger = LoggerFactory.getLogger(SecTools.class);

//	public static Authentication getAuthentication() {
//		return null;
//	}

	public static String getUser() {
return null;	}

	/**
	 * @return Role Name of the current user
	 */
	public static String getUserRole() {
		return null;
	}

	public static Integer getMJUserId() {
		return null;
	}

	/**
	 * @return Whole User info (name, lastname, role, department..)
	 */
	public static String getMJUserInfoPOJO() {
		return null;
	}

	public static String logAuthUser(String path) {
		// logger.trace(getAuthentication().toString());

		String username = null;
		logger.debug(username + " " + path);
		return username;
	}

}
