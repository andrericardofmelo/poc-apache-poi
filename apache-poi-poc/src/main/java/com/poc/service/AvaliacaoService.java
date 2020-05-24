package com.poc.service;

import java.io.IOException;
import java.util.List;

import com.poc.entity.Aluno;

public class AvaliacaoService {

	private static double soma = 0;

	public static void main(String[] args) throws IOException {
		List<Aluno> alunos = AlunoService.carregaListaAlunos();
		verificaStatusAprovacao(alunos);
		ResultadoService.imprimeResultado(alunos);
	}

	private static void verificaStatusAprovacao(List<Aluno> alunos) {
		alunos.stream().forEach(aluno -> {
			soma = soma + aluno.getMedia();
			ResultadoService.resultadoMedia(alunos, aluno);
			ResultadoService.resultadoAprovacao(aluno);
		});
	}
}
