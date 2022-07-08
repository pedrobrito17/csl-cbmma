package br.gov.ma.ssp.cbm.odonto.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import br.gov.ma.ssp.cbm.odonto.selenium.page.LoginPage;

public class LoginTest{

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/pedro/Github/odonto/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        loginPage = new LoginPage(driver);
        loginPage.abriPage();
    }

    @After
    public void finish(){
        driver.get("localhost:8080/cleanbd");
        driver.close();
    }

    @Test
    public void cadastrarBombeiro(){
        loginPage
            .clicarCadastrese()
            .preencherFormulario()
            .cadastrar();

        assertTrue(driver.getPageSource().contains("Cadastro realizado"));
    }

}