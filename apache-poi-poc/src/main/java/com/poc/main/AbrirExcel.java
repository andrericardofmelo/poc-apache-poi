package com.poc.main;

import java.io.IOException;
import java.util.List;

import com.poc.entity.Aluno;
import com.poc.service.AlunoService;
import com.poc.service.AvaliacaoService;
import com.poc.service.ResultadoService;

public class AbrirExcel {
	public static void main(String[] args) throws IOException {
		List<Aluno> alunos = AlunoService.carregaListaAlunos();
		AvaliacaoService.verificaStatusAprovacao(alunos);
		ResultadoService.imprimeResultado(alunos);
	}

}
