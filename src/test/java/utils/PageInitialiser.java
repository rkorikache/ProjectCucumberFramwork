package utils;

//import pages.AddEmployeePage;
//import pages.LoginPage;
//import pages.SearchEmployeePage;

import pages.AddEmployeePage;
import pages.LoginPage;

public class PageInitialiser {


    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;



    public static void initializePageObjects() {
        loginPage = new LoginPage();
        addEmployeePage = new AddEmployeePage();
    }

}
