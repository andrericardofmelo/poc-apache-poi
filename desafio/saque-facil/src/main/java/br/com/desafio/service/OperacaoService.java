package br.com.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.desafio.dto.SaqueDTO;

public class OperacaoService {
	private static final Logger logger = LoggerFactory.getLogger(OperacaoService.class);

	public List<SaqueDTO> validaValorSolicitado(double valorInformado) {
		if (valorInformado == 0 || valorInformado % 10 != 0) {
			logger.info("Operação não realizada. O valor informado é insuficiente! \nNotas Disponíveis (10,20,50,100)");
		} else {
			return getQuantidadeNotas(valorInformado);
		}
		return new ArrayList<>();
	}

	protected List<SaqueDTO> getQuantidadeNotas(double valorInformado) {
		List<SaqueDTO> retorno = new ArrayList<>();
		int[] cedulas = { 100, 50, 20, 10 };
		for (int i = 0; i < cedulas.length; i++) {
			if (valorInformado >= cedulas[i] && valorInformado > 0) {
				retorno.add(SaqueDTO.builder().quantidade((int)valorInformado/cedulas[i]).cedula(cedulas[i]).build());
				valorInformado = valorInformado % cedulas[i];
			}
		}
		return retorno;
	}
	
	
}
