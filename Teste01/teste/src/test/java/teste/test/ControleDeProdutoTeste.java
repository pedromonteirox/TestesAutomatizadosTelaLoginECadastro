package teste.test;


import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import teste.build.ProdutoBuilder;
import teste.page.ControleDeProdutoPO;
import teste.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTeste extends BaseTeste {
   
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    //#region Preparar Teste
    /**
     * Método que prepara os testes e loga
     */
    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);       
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }
    //#endregion Preparar Teste

    //#region Teste

    @Test
    public void TC001_deveManterNaMesmaPaginaAoClicarNoLogoDeControleDeProdutos(){
    controleProdutoPage.logoControle.click();
    String controle = controleProdutoPage.logoControle.getText();
    assertEquals("Controle de produtos", controle);

    }

    @Test
    public void TC002_deveVoltarParaATelaDeLoginAoClicarNaopcaoDeVoltar(){
    controleProdutoPage.opcaoVoltar.click();
    String login = loginPage.textoLogin.getText();
    assertEquals("Login", login);

    }

    @Test
    public void TC003_deveTrazerNaTabelaOsUltimosProdutosCadastrados(){
    controleProdutoPage.tabelaProduto.getText();
    }

    @Test
    public void TC004_deveTerOsTitulosDaTabelaPadronizadosEmPortuguesTodosIniandoComLetrasMaisculas(){
    
    String codigo = controleProdutoPage.textoCodigo.getText();
    assertEquals("Código", codigo);

    String nome = controleProdutoPage.textoNome.getText();
    assertEquals("Nome", nome);

    String quantidade = controleProdutoPage.textoQuantidade.getText();
    assertEquals("Quantidade", quantidade);

    String valor = controleProdutoPage.textoValor.getText();
    assertEquals("Valor", valor);

    String data = controleProdutoPage.textoData.getText();
    assertEquals("Data", data);

    }

    @Test
    public void TC005_deveAbrirModalPAraCadastroAoClicarNoBotaoCriar(){
        controleProdutoPage.buttonAdicionar.click();
        
        String titulo = controleProdutoPage.tituloModal.getText();
        assertEquals("Produto",titulo);

        controleProdutoPage.buttonSair.click();

    }

    @Test
    public void TC006_deveFecharATelaDeCadastroDeProdutoAoClicarNoIconeDeFechar(){
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();

        String titulo = controleProdutoPage.tituloModal.getText();
        assertEquals("Produto",titulo);

        controleProdutoPage.buttonFecharModal.click();

        String controle = controleProdutoPage.logoControle.getText();
        assertEquals("Controle de produtos", controle);

    }


    @Test
    public void TC007_deveFecharATelaDeCadastroProdutoAoClicarNoBotaoSair(){
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();
        
        String titulo = controleProdutoPage.tituloModal.getText();
        assertEquals("Produto",titulo);

        controleProdutoPage.buttonSair.click();

        String controle = controleProdutoPage.logoControle.getText();
        assertEquals("Controle de produtos", controle);

    }

    @Test
    public void TC008_deveMostrarUmaMensagemInformandoQueOsCamposSãoObrigatóriosAoClicarEmSalvarSemPreencherOsCamposComAsInformações(){
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonSalvar.click();

        String camposObrigatorios = "Todos os campos são obrigatórios para o cadastro!";


        assertEquals("Todos os campos são obrigatórios para o cadastro!",camposObrigatorios);
    }

    @Test
    public void TC009_deveFecharMensagemDeCamposObrigatoriosAoClicarNoC(){
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonSalvar.click();

        String camposObrigatorios = "Todos os campos são obrigatórios para o cadastro!";
        assertEquals("Todos os campos são obrigatórios para o cadastro!",camposObrigatorios);

        controleProdutoPage.buttonFecharMensagemCampoObrigatorio.click();

        String controle = controleProdutoPage.logoControle.getText();
        assertEquals("Controle de produtos", controle);

    }
    

    @Test
    public void TC010_naoDeveSerPossivelCadastrarUmprodutoSemPreencherTodosOsCampos(){
        controleProdutoPage.buttonAdicionar.click();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        produtoBuilder
        .adicionarCodigo("")
        .builder();      
        assertEquals("Todos os campos são obrigatórios para o cadastro!",controleProdutoPage.spamMesangem.getText());

        produtoBuilder
        .adicionarNome("")
        .builder();
        assertEquals("Todos os campos são obrigatórios para o cadastro!",controleProdutoPage.spamMesangem.getText());

        produtoBuilder
        .adicionarQuantidade(null)
        .builder();
        assertEquals("Todos os campos são obrigatórios para o cadastro!",controleProdutoPage.spamMesangem.getText());

        produtoBuilder
        .adicionarValor(null)
        .builder();
        assertEquals("Todos os campos são obrigatórios para o cadastro!",controleProdutoPage.spamMesangem.getText());

        produtoBuilder
        .adicionarData("")
        .builder();
        assertEquals("Todos os campos são obrigatórios para o cadastro!",controleProdutoPage.spamMesangem.getText());
    }




    //#endregion Teste

}
