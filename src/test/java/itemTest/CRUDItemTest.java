package itemTest;

import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.CenterSection;
import pomPages.todoLy.LeftSection;
import pomPages.todoLy.LoginModal;
import pomPages.todoLy.MainPage;

public class CRUDItemTest extends TestBaseTodoLy{
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    LeftSection leftSection= new LeftSection();
    CenterSection centerSection= new CenterSection();
    String user="upbui@upbui.com";
    String pwd="1234";

    @Test
    public void verify_CRUD_item_todoly() throws InterruptedException {
        String nameProject = "RCProject";
        String name="ItemTest";
        mainPage.loginImage.click();
        loginModal.loginAction(user,pwd);

        //Crear Item

        leftSection.clickOnProject(nameProject);
        centerSection.nameItemTextBox.set(name);
        centerSection.addItemButton.click();

        this.waitOnSecond(5);
        //Assert.assertEquals("ERROR !! Item No Creado",nameProject, centerSection.projectNameLabel.getText());

        //Update Item

        centerSection.dropdownItemMenuButton.click();
        centerSection.editItemOption.click();
        name="ItemTestUpdated";
        centerSection.editNameItemTextBox.clear();
        centerSection.editNameItemTextBox.set(name);
        centerSection.saveItemOption.click();

        this.waitOnSecond(2);
        //Assert.assertEquals("ERROR !!Item No Actualizado",name, centerSection.projectNameLabel.getText());

        //DeleteItem

        centerSection.dropdownItemMenuButton.click();
        centerSection.deleteOption.click();

        this.waitOnSecond(2);
        //Assert.assertFalse("Projecto No fue Borrado",name.equals(leftSection.lastProjectInListLabel.getText()));

    }
}
