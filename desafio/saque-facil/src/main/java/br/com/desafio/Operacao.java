package br.com.desafio;

import java.util.List;

import br.com.desafio.dto.SaqueDTO;
import br.com.desafio.service.OperacaoService;

public class Operacao {
	private OperacaoService service;

	public Operacao() {
		service = new OperacaoService();
	}

	public List<SaqueDTO> calcular(double valorInformado) {
		return service.validaValorSolicitado(valorInformado);
	}
}
