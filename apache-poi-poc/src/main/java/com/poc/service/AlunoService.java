package com.poc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.poc.entity.Aluno;
import com.poc.entity.Aluno.AlunoBuilder;

public class AlunoService {

	private static List<Aluno> alunos = new ArrayList<>();

	public static List<Aluno> carregaListaAlunos() throws IOException {
		Iterator<Row> rowIterator = Excel.abreValidaArquivo().getSheetAt(0).iterator();
		while (rowIterator.hasNext()) {
			alunos.add(montaAluno(rowIterator.next().cellIterator()));
		}
		return alunos;
	}

	private static Aluno montaAluno(Iterator<Cell> cellIterator) {
		AlunoBuilder aluno = Aluno.builder();
		while (cellIterator.hasNext()) {
			switch (cellIterator.next().getColumnIndex()) {
			case 0:
				aluno.nome(cellIterator.next().getStringCellValue());
				break;
			case 1:
				aluno.ra(cellIterator.next().getStringCellValue());
				break;
			case 2:
				aluno.nota1(cellIterator.next().getNumericCellValue());
				break;
			case 3:
				aluno.nota2(cellIterator.next().getNumericCellValue());
				break;
			case 4:
				aluno.media(cellIterator.next().getNumericCellValue());
				break;
			case 5:
				aluno.aprovado(cellIterator.next().getBooleanCellValue());
				break;
			}
		}
		return aluno.build();
	}

}
