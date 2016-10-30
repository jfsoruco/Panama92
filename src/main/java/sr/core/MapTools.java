package sr.core;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utilitario para mapas
 * 
 * @author juan.soruco
 *
 */
public class MapTools {
	private static final Logger logger = LoggerFactory.getLogger(MapTools.class);
	
	public static String toStr(Map<String, String> map) {
		if (map== null){
			return "";
		}
		final StringBuilder result = new StringBuilder();
		logger.trace("map:"+map);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			result.append("[" + entry.getKey() + "/" + entry.getValue() + "]");
		}
		logger.trace("result.toString():"+result.toString());
		return result.toString();
	}
}
