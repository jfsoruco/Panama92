package sr.core;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * General tool methods related to dates
 * Only static methods means helper class => make class final.
 * 
 * @author juan.soruco
 *
 */
public final class DateTools {

	/**
	 * Converts java.sql.Timestamp timestamp -> java.util.Date
	 * http://www.java2s.com/Tutorial/Java/0340__Database/
	 * ConvertajavasqlTimestampObjecttoajavautilDateObject.htm
	 * 
	 * @param timestamp
	 *            got usually from DB (SQL Server)
	 * @return Date based on timestamp
	 */
	public static java.util.Date toDate(java.sql.Timestamp timestamp) {
		long milliseconds = timestamp.getTime() + (timestamp.getNanos() / 1000000);
		return new java.util.Date(milliseconds);
	}

	/**
	 * Returns a Timestamp based on a date
	 * 
	 * @param date
	 *            Date to be converted
	 * @return Timestamp of the received Date
	 */
	public static Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * Formatter Used to build log exceptionId (ExceptionResponse)
	 * 
	 * @return
	 */
	public static String getDateForLog() {
		return new SimpleDateFormat("yyyyMMddHH").format(new Date());
	}

	public static String getStringFromDate(Date dateIn) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateIn);
	}

	public static Date getDateFromString(String stringDateIn) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDateIn);
	}

	/**
	 * Get Date received minus hours indicated as parameter
	 * 
	 * @param dateIn
	 * @param minusHours
	 * @return
	 */
	public static Date getDateMinusHours(Date dateIn, long minusHours) {
		return new Date(dateIn.getTime() - TimeUnit.HOURS.toMillis(minusHours));
	}

}
