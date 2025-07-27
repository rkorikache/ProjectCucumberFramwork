package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {


    @FindBy(id="firstName")
    public WebElement firstNameLoc;

    @FindBy(id="middleName")
    public WebElement middleNameLoc;

    @FindBy(id="lastName")
    public WebElement lastNameLoc;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id="employeeId")
    public WebElement idLoc;

    @FindBy(xpath = "//span[@for='firstName']")
    public WebElement fnErrMsg;

    @FindBy(xpath = "//span[@for='lastName']")
    public WebElement lnErrMsg;



    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }

}
