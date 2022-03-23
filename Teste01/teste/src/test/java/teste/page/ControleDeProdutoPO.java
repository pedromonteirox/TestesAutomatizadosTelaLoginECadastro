package teste.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ControleDeProdutoPO extends BasePO {

   //#region Webelement
    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;

    @FindBy(css = "div.modal-header>h4")
    public WebElement tituloModal;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "mensagem")
    public WebElement spamMesangem;

    @FindBy(css = "body > nav > a")
    public WebElement logoControle;

    @FindBy(css = "#collapsibleNavbar > ul > li > a")
    public  WebElement opcaoVoltar;

    @FindBy(css = "body > div > div:nth-child(2) > table > tbody > tr")
    public  WebElement tabelaProduto;

    @FindBy(css =  "body > div > div:nth-child(2) > table > thead > tr > th:nth-child(1)")
    public  WebElement textoCodigo;

    @FindBy(css =  "body > div > div:nth-child(2) > table > thead > tr > th:nth-child(2)")
    public  WebElement textoNome;

    @FindBy(css =  "body > div > div:nth-child(2) > table > thead > tr > th:nth-child(3)")
    public  WebElement textoQuantidade;

    @FindBy(css =  "body > div > div:nth-child(2) > table > thead > tr > th:nth-child(4)")
    public  WebElement textoValor;

    @FindBy(css =  "body > div > div:nth-child(2) > table > thead > tr > th:nth-child(5)")
    public  WebElement textoData;

    @FindBy(css ="#cadastro-produto > div > div > div.modal-header > button")
    public WebElement buttonFecharModal;

    @FindBy(css ="#cadastro-produto > div > div > div.modal-body > div.alert.alert-danger.text-center.alert-dismissible > button")
    public WebElement buttonFecharMensagemCampoObrigatorio;




    //#endregion Webelement

    //#region Construtor
    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }
    //#endregion Construtor
    
}
