package testClean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.CenterSection;
import pomPages.todoLy.LeftSection;
import pomPages.todoLy.LoginModal;
import pomPages.todoLy.MainPage;
import singletonSession.Session;

public class DeleteProjectTest {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    LeftSection leftSection= new LeftSection();
    CenterSection centerSection= new CenterSection();
    String user="upbui@upbui.com";
    String pwd="1234";

    @Test
    public void verify_delete_project_todoly() throws InterruptedException {
        String name="RCProjectForDelete";
        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user,pwd);

        leftSection.selectProjectButtonForDelete.click();
        leftSection.dropdownButton.click();
        leftSection.deleteButton.click();
        Session.getSession().getDriver().switchTo().alert().accept();
        leftSection.verificationDeleteProject.click();


        Thread.sleep(2000);
        Assert.assertEquals("No borro el projecto",name, centerSection.projectNameLabel.getText());


    }

    @After
    public void close(){
        Session.getSession().closeSession();
    }
}
