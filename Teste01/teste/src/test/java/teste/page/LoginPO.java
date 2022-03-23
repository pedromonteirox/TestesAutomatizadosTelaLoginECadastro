package teste.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

    //#region Região dos WebElement
   @FindBy(id ="email")
   public WebElement inputEmail;

   @FindBy(id ="senha")
   public WebElement inputSenha;

   @FindBy(id ="btn-entrar")
   public WebElement buttonEntrar;

   @FindBy(id ="mensagem")
   public WebElement spamMensagem;

   @FindBy(css = "body > div > form > h1")
   public WebElement textoLogin;

   //#endregion Região dos WebElement

    //#region Construtor
    /**
     * Construtor padrão para criação de uma nova instância de login
     * @param driver página de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
    //#endregion Construtor

    //#region Métodos
    /**
     * Método que obteve a mensagem disparada na tela
     * @return  texto da mensagem
     */

    public String obterMensagem(){
        return this.spamMensagem.getText();
    }

    /**
     * Método que tenta executar a ação de logar no sistema
     * @param email Email para tentaiva de login
     * @param senha Senha para tentativa de login
     */
    
    public void executarAcaoDeLogar(String email, String senha){

        escrever(inputEmail, email);
        escrever(inputSenha, senha);

        buttonEntrar.click();
    }
    //#endregion Métodos
}

