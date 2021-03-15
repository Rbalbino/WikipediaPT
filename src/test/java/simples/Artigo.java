package simples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class Artigo {
    String url;             //Endereço site alvo
    WebDriver driver;       //Objeto do Selenium Webdriver

    @Before                 //Antes do teste
    public void iniciar(){
        url = "https://pt.wikipedia.org/";
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/89/chromedriver.exe"); // Onde está o chromedriver
        driver = new ChromeDriver();  // Instanciasr o Selenium como Chrome Driver
        driver.manage().window().maximize(); // Maximizare a janela do navegador
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS); // oi Define uma espera implicida de 1 min, verificando o carregamento a cada milissegundo
    }

    @Test                           //Durante o teste
    public void consultarArtigo(){
        // Abrir o site
        driver.get(url);

        // Pesquisar por "Ovo de Páscoa"
        driver.findElement(By.id("searchInput")).sendKeys("Ovo de Páscoa");
        driver.findElement(By.id("searchButton")).click(); // Clicar na lupa

        // Validar o titulo da página de retorno
        //        assertEquals("Ovo de Páscoa - Wikipédia, a enciclopédia livre", driver.getTitle());
        assertTrue(driver.getTitle().contains("Ovo de Páscoa"));
    }

    @After                      //Depois do teste
    public void finalizar(){
        driver.quit();
    }
}