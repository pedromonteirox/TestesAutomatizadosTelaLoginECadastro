package teste.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//#region Base herança
/**
 * classe base que serve de herança para todas as classes de teste
 */
public abstract class BaseTeste {
    /**Driver do navegador da página atual */
    protected static WebDriver driver;
    /**Caminho base da URLso distema ser testado */
    private static final String URL_BASE = "file:///C:/Users/Pedro/Desktop/Teste01/sistema/login.html";
    /**Caminho relativo do driver ao projeto referente ao path */
    private static final String CAMINHO_DRIVER ="C:/Users/Pedro/Desktop/Teste01/teste/src/test/java/teste/resource/chromedriver-v990484451.exe";
//#endregion Base herança

    //#region Métodos
   /**
    * Método para iniciar o driver do navegador antes de qualquer classe de teste
    */
    @BeforeClass    
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);

    }
    /**
     * Método para finalizar o diver do navegador depois de qualqer classe de teste
     */
    @AfterClass
    public static void finalizar(){
        driver.quit();
    }
    //#endregion Métodos

}
