package teste.test;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import teste.page.LoginPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTeste{
    private static LoginPO loginPage;

    //#region Preparar teste
    /**
     * Método que Prepara o teste
     */
    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }
    //#endregion Preparar teste
    
    //#region Testes
    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){
        

        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();
        String mensagemEsperada = "Informe usuário e senha, os campos não podem ser brancos.";
        
        assertEquals(mensagem, mensagemEsperada);
    }
    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailInvalidoESenhaVazios(){
        
        loginPage.executarAcaoDeLogar("Teste", "");

        String mensagem = loginPage.obterMensagem();
        String mensagemEsperada = "Informe usuário e senha, os campos não podem ser brancos.";
        
        assertEquals(mensagem, mensagemEsperada);
    }
    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIvalida(){
        
        loginPage.executarAcaoDeLogar("", "123");

        String mensagem = loginPage.obterMensagem();
        String mensagemEsperada = "Informe usuário e senha, os campos não podem ser brancos.";
        
        assertEquals(mensagem, mensagemEsperada);
    }
    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailESenhaInvalidos(){
        
        loginPage.executarAcaoDeLogar("teste", "teste");

        String mensagem = loginPage.obterMensagem();
        String mensagemEsperada = "E-mail ou senha inválidos";
        
        assertEquals(mensagem, mensagemEsperada);
    }
    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailValidoESenhaInvalida(){
        
        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");

        String mensagem = loginPage.obterMensagem();
        String mensagemEsperada = "E-mail ou senha inválidos";
        
        assertEquals(mensagem, mensagemEsperada);
    }
    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailInvalidoESenhaValida(){
        
        loginPage.executarAcaoDeLogar("Aadmin@admin.com", "admin@123");

        String mensagem = loginPage.obterMensagem();
        String mensagemEsperada = "E-mail ou senha inválidos";
        
        assertEquals(mensagem, mensagemEsperada);
    }
    @Test
    public void TC007_DeveLogarNoSistemaComEmailESenhaValidos(){
        
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
    }
    //#endregion Testes
}
