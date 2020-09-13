package br.gov.rj.faeterj.estoque.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Produto {

	@NotBlank
    private String sku;
	
	@Length(min = 3)
    private String nome;
	
	@Size(min=1, max = 50)
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
