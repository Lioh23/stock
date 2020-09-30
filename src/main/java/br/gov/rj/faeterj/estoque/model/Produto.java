package br.gov.rj.faeterj.estoque.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.gov.rj.faeterj.estoque.validation.AtributoSku;

//@AtributoSku(atributo = "sku", message = "SKU inválido")
public class Produto {

	@NotBlank(message = "SKU é obrigatório!")
    private String sku;
	
	@Length(min = 3, message = "O nome precisa possuir 3 ou mais caracteres!")
    private String nome;
	
	@Size(min=1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50 caracteres!")
	private String descricao;
    
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
		return descricao;
	}
    
    public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
}
