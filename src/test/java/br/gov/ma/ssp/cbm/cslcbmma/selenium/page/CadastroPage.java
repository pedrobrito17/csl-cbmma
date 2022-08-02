package br.gov.ma.ssp.cbm.cslcbmma.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroPage{

    private WebDriver driver;

    public CadastroPage(WebDriver driver){
        this.driver = driver;
    }

    public void abrirPage(){
        driver.get("http://localhost:8080/cadastro");
    }

    public CadastroPage preencherFormulario(){
        driver.findElement(By.name("nomeCompleto")).sendKeys("Pedro Ítalo Aragão Brito");
        driver.findElement(By.name("numIdFuncional")).sendKeys("2170");
        driver.findElement(By.name("matricula")).sendKeys("41-98720");

        new Select(driver.findElement(By.name("cargo"))).selectByVisibleText("Capitão");
        new Select(driver.findElement(By.name("quadro"))).selectByVisibleText("QOCBM");
        new Select(driver.findElement(By.name("localTrabalho"))).selectByVisibleText("Gabinete do comando");

        driver.findElement(By.name("nomeGuerra")).sendKeys("Aragão");
        driver.findElement(By.name("celular")).sendKeys("(98) 98204-5453");
        driver.findElement(By.name("email")).sendKeys("aragao@cbm.ma.gov.br");
        driver.findElement(By.name("confEmail")).sendKeys("aragao@cbm.ma.gov.br");
        driver.findElement(By.name("senha")).sendKeys("fsadu");
        driver.findElement(By.name("confSenha")).sendKeys("fsadu");
        return this;
    }

    public void cadastrar(){
        driver.findElement(By.className("my-button")).click();
    }

}