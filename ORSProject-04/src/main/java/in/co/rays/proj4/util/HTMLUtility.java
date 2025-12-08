package in.co.rays.proj4.util;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import in.co.rays.proj4.bean.DropDownListBean;
import in.co.rays.proj4.model.RoleModel;

/**
 * Utility class for generating HTML components dynamically.
 * 
 * <p>
 * Provides methods to create HTML <select> dropdown lists from either a
 * HashMap or a List of DropDownListBean objects.
 * </p>
 * 
 * <p>
 * @author mehre <br>
 * Version: 1.0
 * </p>
 */
public class HTMLUtility {

    /**
     * Generates an HTML select element using a HashMap as the data source.
     * 
     * @param name        The name attribute of the select element
     * @param selectedVal The value to be pre-selected in the dropdown
     * @param map         The HashMap containing key-value pairs to populate the
     *                    dropdown
     * @return A String containing the HTML select element
     */
    public static String getList(String name, String selectedVal, HashMap<String, String> map) {

        StringBuffer sb = new StringBuffer("<select class='form-control' name='" + name + "'>");
        sb.append("\n<option selected value=''>-------------Select-------------</option>");

        Set<String> keys = map.keySet();
        String val = null;

        for (String key : keys) {
            val = map.get(key);

            if (key.trim().equals(selectedVal)) {
                sb.append("\n<option selected value='" + key + "'>" + val + "</option>");
            } else {
                sb.append("\n<option value='" + key + "'>" + val + "</option>");
            }
        }

        sb.append("\n</select>");
        return sb.toString();
    }

    /**
     * Generates an HTML select element using a List of DropDownListBean objects as
     * the data source.
     * 
     * @param name        The name attribute of the select element
     * @param selectedVal The value to be pre-selected in the dropdown
     * @param list        The List containing DropDownListBean objects to populate
     *                    the dropdown
     * @return A String containing the HTML select element
     */
    public static String getList(String name, String selectedVal, List list) {

        // List of DropDownListBean objects
        List<DropDownListBean> dd = (List<DropDownListBean>) list;

        StringBuffer sb = new StringBuffer(
                "<select style=\"width: 169px;text-align-last: center;\" class='form-control' name='" + name + "'>");
        sb.append("\n<option selected value=''>-------------Select-------------</option>");

        String key = null;
        String val = null;

        for (DropDownListBean obj : dd) {

            key = obj.getKey();
            val = obj.getValue();

            if (key.trim().equals(selectedVal)) {
                sb.append("\n<option selected value='" + key + "'>" + val + "</option>");
            } else {
                sb.append("\n<option value='" + key + "'>" + val + "</option>");
            }
        }

        sb.append("\n</select>");
        return sb.toString();
    }

    /**
     * Test method to demonstrate generating an HTML select element from a
     * HashMap.
     */
    public static void testGetListByMap() {

        HashMap<String, String> map = new HashMap<>();
        map.put("male", "male");
        map.put("female", "female");

        String selectedValue = "male";
        String htmlSelectFromMap = HTMLUtility.getList("gender", selectedValue, map);

        System.out.println(htmlSelectFromMap);
    }

    /**
     * Test method to demonstrate generating an HTML select element from a List of
     * DropDownListBean objects.
     * 
     * @throws Exception if the model fails to fetch the list
     */
    public static void testGetListByList() throws Exception {

        RoleModel model = new RoleModel();

        List list = model.list();

        String selectedValue = "1";

        String htmlSelectFromList = HTMLUtility.getList("role", selectedValue, list);

        System.out.println(htmlSelectFromList);
    }

    /**
     * Main method for testing the HTMLUtility methods.
     * 
     * @param args Command line arguments
     * @throws Exception if any test method throws an exception
     */
    public static void main(String[] args) throws Exception {

        testGetListByMap();
        // testGetListByList();
    }

}
