package pomPages.todoLy;

import controls.Button;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;

public class CenterSection {
    public Label projectNameLabel= new Label(By.xpath("//div[@id='CurrentProjectTitle']"));

    //Item
    //Create
    public TextBox nameItemTextBox= new TextBox(By.xpath("//*[@id=\"NewItemContentInput\"]"));
    public Button addItemButton= new Button(By.xpath("//*[@id=\"NewItemAddButton\"]"));

    //Update
    public Button dropdownItemMenuButton = new Button(By.xpath("//li[last()]//div/img[@class='ItemMenu' and @src='/Images/dropdown.png']"));

    public Button editItemOption = new Button(By.xpath("//ul[@id='itemContextMenu']//a[contains(.,'Edit')] "));
    public TextBox editNameItemTextBox = new TextBox(By.id("ItemEditTextbox"));
    public Button saveItemOption = new Button(By.xpath("//a[contains(.,'0')] "));

    //Delete
    public Button deleteOption = new Button(By.xpath("//ul[@id='itemContextMenu']//a[contains(.,'Delete')]"));

    public CenterSection(){}
}