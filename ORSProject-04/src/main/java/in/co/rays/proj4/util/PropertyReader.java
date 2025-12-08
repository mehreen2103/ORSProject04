package in.co.rays.proj4.util;

import java.util.ResourceBundle;

/**
 * Utility class to read property values from the system resource bundle.
 * 
 * <p>
 * Provides methods to fetch properties using keys, with optional support for
 * single or multiple parameter replacements.
 * </p>
 * 
 * <p>
 *@author mehre <br>
 * Version: 1.0
 * </p>
 */
public class PropertyReader {

    /** Resource bundle object to read system properties */
    private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.proj4.bundle.system");

    /**
     * Returns the value of a property for the given key.
     * 
     * @param key Property key
     * @return Property value as a String; if key not found, returns the key itself
     */
    public static String getValue(String key) {
        String val = null;
        try {
            val = rb.getString(key); // {0} is required
        } catch (Exception e) {
            val = key;
        }
        return val;
    }

    /**
     * Returns the property value for the given key and replaces {0} with the
     * provided parameter.
     * 
     * @param key   Property key
     * @param param Value to replace {0} in the property
     * @return Formatted property value
     */
    public static String getValue(String key, String param) {
        String msg = getValue(key); // {0} is required
        msg = msg.replace("{0}", param);
        return msg;
    }

    /**
     * Returns the property value for the given key and replaces placeholders
     * {0}, {1}, ... with the values in the provided params array.
     * 
     * @param key    Property key
     * @param params Array of values to replace placeholders
     * @return Formatted property value
     */
    public static String getValue(String key, String[] params) {
        String msg = getValue(key); // {0} and {1} are required.
        for (int i = 0; i < params.length; i++) {
            msg = msg.replace("{" + i + "}", params[i]);
        }
        return msg;
    }

    /**
     * Main method to test the PropertyReader utility.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("Single key example:");
        System.out.println(PropertyReader.getValue("error.require"));

        System.out.println("\nSingle parameter replacement example:");
        System.out.println(PropertyReader.getValue("error.require", "loginId"));

        System.out.println("\nMultiple parameter replacement example:");
        String[] params = { "Roll No", "Student Name" };
        System.out.println(PropertyReader.getValue("error.multipleFields", params));
    }
}
