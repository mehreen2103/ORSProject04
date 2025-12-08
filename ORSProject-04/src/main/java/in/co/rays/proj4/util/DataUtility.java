package in.co.rays.proj4.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for data conversion operations such as String to Integer, Long,
 * Date, Timestamp and vice-versa.
 *
 * <p>
 * This class provides methods commonly used across the project to safely parse
 * and format data. All methods handle invalid values gracefully and avoid
 * runtime exceptions.
 * </p>
 * 
 * @author mehre
 * @version 1.0
 */
public class DataUtility {

	public static final String APP_DATE_FORMAT = "dd-MM-yyyy";
	public static final String APP_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";

	private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);
	private static final SimpleDateFormat timeFormatter = new SimpleDateFormat(APP_TIME_FORMAT);

	/**
	 * Returns trimmed string or original value if null.
	 *
	 * @param val input string
	 * @return trimmed string or null
	 */
	public static String getString(String val) {
		if (DataValidator.isNotNull(val)) {
			return val.trim();
		} else {
			return val;
		}
	}

	/**
	 * Converts an Object to String.
	 *
	 * @param val object value
	 * @return string value or empty string if null
	 */
	public static String getStringData(Object val) {
		if (val != null) {
			return val.toString();
		} else {
			return "";
		}
	}

	/**
	 * Converts String to int. Returns 0 if invalid.
	 *
	 * @param val numeric string
	 * @return integer value or 0
	 */
	public static int getInt(String val) {
		if (DataValidator.isInteger(val)) {
			return Integer.parseInt(val);
		} else {
			return 0;
		}
	}

	/**
	 * Converts String to long. Returns 0 if invalid.
	 *
	 * @param val numeric string
	 * @return long value or 0
	 */
	public static long getLong(String val) {
		if (DataValidator.isLong(val)) {
			return Long.parseLong(val);
		} else {
			return 0;
		}
	}

	/**
	 * Converts date string (dd-MM-yyyy) to Date object.
	 *
	 * @param val date string
	 * @return Date object or null if parsing fails
	 */
	public static Date getDate(String val) {
		Date date = null;
		try {
			date = formatter.parse(val);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * Converts Date object to string (dd-MM-yyyy).
	 *
	 * @param date Date object
	 * @return formatted date string or empty string if error
	 */
	public static String getDateString(Date date) {
		try {
			return formatter.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * Converts timestamp string (dd-MM-yyyy HH:mm:ss) to Timestamp.
	 *
	 * @param val timestamp string
	 * @return Timestamp or null if parsing fails
	 */
	public static Timestamp getTimestamp(String val) {
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp((timeFormatter.parse(val)).getTime());
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	/**
	 * Converts long milliseconds to Timestamp.
	 *
	 * @param l milliseconds
	 * @return Timestamp or null
	 */
	public static Timestamp getTimestamp(long l) {
		try {
			return new Timestamp(l);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Returns current system timestamp.
	 *
	 * @return current Timestamp
	 */
	public static Timestamp getCurrentTimestamp() {
		try {
			return new Timestamp(new Date().getTime());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Converts Timestamp to long value.
	 *
	 * @param tm Timestamp object
	 * @return time in milliseconds or 0
	 */
	public static long getTimestamp(Timestamp tm) {
		try {
			return tm.getTime();
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Main method for testing all utility functions.
	 */
	public static void main(String[] args) {

		System.out.println("getString Test:");
		System.out.println("Original: '  Hello World  ' -> Trimmed: '" + getString("  Hello World  ") + "'");
		System.out.println("Null input: " + getString(null));

		System.out.println("\ngetStringData Test:");
		System.out.println("Object to String: " + getStringData(1234));
		System.out.println("Null Object: '" + getStringData(null) + "'");

		System.out.println("\ngetInt Test:");
		System.out.println("Valid Integer String: '124' -> " + getInt("124"));
		System.out.println("Invalid Integer String: 'abc' -> " + getInt("abc"));
		System.out.println("Null String: -> " + getInt(null));

		System.out.println("\ngetLong Test:");
		System.out.println("Valid Long String: '123456789' -> " + getLong("123456789"));
		System.out.println("Invalid Long String: 'abc' -> " + getLong("abc"));

		System.out.println("\ngetDate Test:");
		String dateStr = "10/15/2024";
		Date date = getDate(dateStr);
		System.out.println("String to Date: '" + dateStr + "' -> " + date);

		System.out.println("\ngetDateString Test:");
		System.out.println("Date to String: '" + getDateString(new Date()) + "'");

		System.out.println("\ngetTimestamp(String) Test:");
		String timestampStr = "10/15/2024 10:30:45";
		Timestamp timestamp = getTimestamp(timestampStr);
		System.out.println("String to Timestamp: '" + timestampStr + "' -> " + timestamp);

		System.out.println("\ngetTimestamp(long) Test:");
		long currentTimeMillis = System.currentTimeMillis();
		Timestamp ts = getTimestamp(currentTimeMillis);
		System.out.println("Current Time Millis to Timestamp: '" + currentTimeMillis + "' -> " + ts);

		System.out.println("\ngetCurrentTimestamp Test:");
		Timestamp currentTimestamp = getCurrentTimestamp();
		System.out.println("Current Timestamp: " + currentTimestamp);

		System.out.println("\ngetTimestamp(Timestamp) Test:");
		System.out.println("Timestamp to long: " + getTimestamp(currentTimestamp));
	}
}
