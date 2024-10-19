package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidCredentials")
    public static Object invalidUserCredentials(){
        Object[][] data = {
                {"fameloh253@chysir.com", "Pass&Pas", "Your email or password is incorrect!", ""},
                {"fameloh253@chys.com", "Pass&Pas", "Your email or password is incorrect!", ""},
                {"fameloh253@chys.com", "Pass&Pass!", "Your email or password is incorrect!", ""},
                {"", "", "", "Please fill out this field."},
                {"fameloh253@chysir.com", "", "","Please fill out this field."}
        };

        return  data;
    }
}
