package basicSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicDeleteProjectTest {
    ChromeDriver driver;

    @Before
    public void before(){

        System.setProperty("webdriver.chrome.driver","D:\\Documents\\QA\\Postman\\src\\test\\resources\\chromeDriver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void loginTodoLy() throws InterruptedException {
        String myProject="TareaEliminar";

        driver.get("http://todo.ly/");

        //------ Login ------
        //1) Click Login Button
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        //2) Set Email
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("upbui@upbui.com");
        //3) Set Password
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxPassword']")).sendKeys("1234");
        //4) Click Login Button
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$ButtonLogin']")).click();

        // *) Verificar si estoy logueado
        Assert.assertTrue("Error, nose pudo hacer login",driver.findElement(By.xpath("//a[contains(.,'Logout')]")).isDisplayed());

        //5) Click Add New Project
        driver.findElement(By.xpath("//td[contains(.,'Add New Project') and @class='ProjItemContent']")).click();
        //6) Set NombrProject
        // limpiar la caja de texto
        //driver.findElement(By.xpath("//input[@id='NewProjNameInput']")).clear();
        driver.findElement(By.xpath("//input[@id='NewProjNameInput']")).sendKeys(myProject);
        //7) Click Add button
        driver.findElement(By.xpath("//input[@id='NewProjNameButton']")).click();
        //*) //verificacion del nuevo project
        Thread.sleep(3000);
        String expectedResult=myProject;
        String actualResult=driver.findElement(By.xpath("//div[@id='CurrentProjectTitle']")).getText();

        Assert.assertEquals("El projecto no fue creado",expectedResult,actualResult);

        // Delete de un project

        // click en el projecto que hemos creado
        driver.findElement(By.xpath("//li[last()]//td[contains(.,'"+myProject+"') and @class='ProjItemContent']")).click();

        // click en el dropdown button
        driver.findElement(By.xpath("//div[@style='display: block;']/img[@src='/Images/dropdown.png']")).click();

        //click en la opci??n eliminar
        driver.findElement(By.xpath("//ul[@id='projectContextMenu']//a[contains(.,'Delete')]")).click();

        //aceptar el mensaje
        driver.switchTo().alert().accept();

    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }
}
