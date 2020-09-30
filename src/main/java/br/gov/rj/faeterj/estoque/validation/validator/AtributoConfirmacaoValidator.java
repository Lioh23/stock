package br.gov.rj.faeterj.estoque.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanUtils;

import br.gov.rj.faeterj.estoque.validation.AtributoSku;

public class AtributoConfirmacaoValidator implements ConstraintValidator<AtributoSku, Object>{

	private String atributo;
	
	@Override
	public void initialize(AtributoSku constraintAnnotation) {
		this.atributo = constraintAnnotation.atributo();
	}

	public boolean isValid(Class<?> object, ConstraintValidatorContext context) {
		boolean valido = false;
		try {
			Object valorAtributo = BeanUtils.getPropertyDescriptor(object, this.atributo);
			
			valido = validaSku(valorAtributo);
		} catch (Exception e){
			throw new RuntimeException("Erro recuperando valores dos atributos", e);
		}
		return false;
	}

	private boolean validaSku(Object valorAtributo) {
	
		return valorAtributo.equals("AA1111");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
	
		return false;
	}
}
