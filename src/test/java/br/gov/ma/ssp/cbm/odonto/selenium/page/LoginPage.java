package br.gov.ma.ssp.cbm.odonto.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void abriPage(){
        this.driver.get("http://localhost:8080/login");
    }

    public CadastroPage clicarCadastrese(){
        this.driver.findElement(By.linkText("Cadastre-se")).click();;
        return new CadastroPage(this.driver);
    }

}