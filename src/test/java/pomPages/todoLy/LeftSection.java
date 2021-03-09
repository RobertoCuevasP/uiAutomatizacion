package pomPages.todoLy;

import controls.Button;
import controls.Control;
import controls.TextBox;
import org.openqa.selenium.By;

public class LeftSection {
    public Button addNewProjectButton= new Button(By.xpath("//td[contains(.,'Add New Project') and @class='ProjItemContent']"));
    public Button addButton= new Button(By.xpath("//input[@id='NewProjNameButton']"));
    public TextBox nameProjectTextBox= new TextBox(By.xpath("//input[@id='NewProjNameInput']"));

    //Update
    public Button selectProjectButton = new Button(By.xpath("//li[last()]//td[contains(.,'RCProject') and @class='ProjItemContent']"));
    public Button editButton = new Button(By.xpath("//ul[@id='projectContextMenu']//a[@href='#edit']"));
    public TextBox newNameProjectTextBox = new TextBox(By.id("ItemEditTextbox"));
    public Button submitNewNameProjectButton = new Button(By.xpath("//li//div[@id='ProjectEditDiv']/*[@id=\"ItemEditSubmit\"]"));
    public Control verificationNameProject = new Control(By.xpath("//div[@id='CurrentProjectTitle']"));

    //Delete

    public Button selectProjectButtonForDelete = new Button(By.xpath("//li[last()]//td[contains(.,'RCProjectForDelete') and @class='ProjItemContent']"));
    public Button dropdownButton = new Button(By.xpath("//div[@style='display: block;']/img[@src='/Images/dropdown.png']"));
    public Button deleteButton = new Button(By.xpath("//ul[@id='projectContextMenu']//a[@href='#delete']"));

    public Button verificationDeleteProject = new Button(By.xpath("//div[@id=\"ProjectListPlaceHolder\"]//li[last()]"));

    public LeftSection(){}

}