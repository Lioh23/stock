package br.gov.rj.faeterj.estoque.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.rj.faeterj.estoque.model.Produto;


@Controller
public class ProdutosController {

	// Método GET
	@RequestMapping("/produtos/novo")
	public String novo() {
		return "produto/CadastroProduto";
	}
	
	// Método POST
	@RequestMapping(value = "/produtos/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Produto produto, BindingResult result, 
			Model model, RedirectAttributes attributes) {
		if (result.hasFieldErrors("sku")) {
			model.addAttribute("mensagem", "O campo SKU não pode ficar em branco!");
			return "produto/CadastroProduto";
		} if (result.hasFieldErrors("nome")) {
			model.addAttribute("mensagem", "O campo Nome precisa conter três ou mais caracteres!");
			return "produto/CadastroProduto";
		} if(result.hasFieldErrors("descricao")) {
			model.addAttribute("mensagem", "A descrição não pode estar vazia, nem ultrapassar 50 caracteres!");
			return "produto/CadastroProduto";
		}
		
		//Salvar no banco de dados
		System.out.println(">>> sku: " + produto.getSku());
		System.out.println(">>> nome: " + produto.getNome());
		System.out.println(">>> descricao: " + produto.getDescricao());
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		return "redirect:/produtos/novo";
	}
	
}

