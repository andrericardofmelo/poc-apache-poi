package com.poc.service;

import java.util.List;

import com.poc.domain.entity.Aluno;

public class ResultadoService {
	
	private static double soma = 0;
	private static double maior = 0;
	private static double menor = 0;
	private static int aprovados = 0;
	private static int reprovados = 0;

	public static void resultadoMedia(List<Aluno> alunos, Aluno aluno) {
		if (aluno.getMedia() < alunos.get(0).getMedia() && aluno.getMedia() < maior) {
			menor = aluno.getMedia();
		} else {
			maior = aluno.getMedia();
		}
	}

	public static void resultadoAprovacao(Aluno aluno) {
		if (aluno.getMedia() >= 6) {
			aprovados++;
		} else {
			reprovados++;
		}
	}

	public static void imprimeResultado(List<Aluno> alunos) {
		System.out.println("A media de notas e: " + soma / alunos.size());
		System.out.println("A maior nota e: " + maior);
		System.out.println("A menor nota e: " + menor);
		System.out.println("O numero de alunos aprovados e: " + aprovados);
		System.out.println("O numero de alunos reprovados e: " + reprovados);
		System.out.println("Numero total de alunos: " + alunos.size());
	}
}
