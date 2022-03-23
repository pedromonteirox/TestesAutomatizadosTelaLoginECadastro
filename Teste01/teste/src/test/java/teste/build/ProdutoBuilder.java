package teste.build;

import teste.page.ControleDeProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela
 */
public class ProdutoBuilder {
    
    private String codigo = "0001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "07/05/2005";

    private ControleDeProdutoPO controleDeProdutoPO;

    /** Construtor do Produto Builder que recebe a página de controle de produtos*/
    public ProdutoBuilder( ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;

    }

    /**
     * Métodod que sabe adicionar um códido ao nuilder
     * @param codigo código que será adicionado
     * @return Retorna a própria classe Product Builder
     */
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

     /**
     * Métodod que sabe adicionar um nome ao builder
     * @param nome nome que será adicionado
     * @return Retorna a própria classe Product Builder
     */   

    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    /**
     * Método que sabe adicionar uma quantidade ao builder
     * @param quantidade quantidade que será adicionada
     * @return Retorna a própria classe Product Builder
     */   

    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    /**
     * Método que sabe adicionar um valor ao builder
     * @param valor valor que será adicionado
     * @return Retorna a própria classe Product Builder
     */   

    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    /**
     * Método que sabe adicionar uma data ao builder
     * @param data data que será adicionada
     * @return Retorna a própria classe Product Builder
     */   

    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /**
     * Método que constroui o produto, ou seja, adiciona o produto pela tela de cadastro do produto
     */
    public void builder(){
        
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo,codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade  != null ) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);

        controleDeProdutoPO.buttonSalvar.click();

    }
}
