package com.poc.service;

import java.util.List;

import com.poc.entity.Aluno;

public class AvaliacaoService {

	private static double soma = 0;
	
	public static void verificaStatusAprovacao(List<Aluno> alunos) {
		alunos.stream().forEach(aluno -> {
			soma = soma + aluno.getMedia();
			ResultadoService.resultadoMedia(alunos, aluno);
			ResultadoService.resultadoAprovacao(aluno);
		});
	}
}
