package teste.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
* Classe base para ciração das novas PO.
* Todas as pages devem ser herdadas desta classe.
*/
public abstract class BasePO {
    /** Driver base que será usado pelas pages */
    protected WebDriver driver;

    //#region Construtor
    /**
     * Construtor base para criação da fábrica de elementos (PageFactory)
     * @param driver Driver da página atual
     */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //#endregion Construtor

    //#region Métodos
    /**
     * Método que retorna o título da página atual
     * @return
     */
    public String obterTituloPagina(){
        return driver.getTitle();
    }
    /**
     * Método que sabe escrever em qualquer WebElemente do tipo input e da um TAB ao final
     * @param input Input a qual será escrito
     * @param texto Texto que será escrito no input
     */
    public void escrever(WebElement input, String texto){

        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
    //#endregion Métodos
    
}
