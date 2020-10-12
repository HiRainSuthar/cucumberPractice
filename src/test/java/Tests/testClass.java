package Tests;

import Util.driverUtil.PropertyUtil;

public class testClass {

    public static void main(String[] args) {
        PropertyUtil prop = new PropertyUtil();
        try {
            prop.getGlobalProperty("browser");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            e.getMessage();
        }
    }
}
