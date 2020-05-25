package com.poc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.poc.entity.Aluno;
import com.poc.entity.Aluno.AlunoBuilder;
import com.poc.entity.Constantes;

public class AlunoService {

	private static List<Aluno> alunos = new ArrayList<>();

	public static List<Aluno> carregaListaAlunos() throws IOException {
		FileInputStream arquivo = new FileInputStream(new File(Constantes.FILE_NAME));
		Iterator<Row> rowIterator = new HSSFWorkbook(arquivo).getSheetAt(0).iterator();
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

	public static List<Aluno> criaListaAlunos() {
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		listaAlunos.add(new Aluno("Eduardo", "9876525", 7, 8, 0, false));
		listaAlunos.add(new Aluno("Luiz", "1234466", 5, 8, 0, false));
		listaAlunos.add(new Aluno("Bruna", "6545657", 7, 6, 0, false));
		listaAlunos.add(new Aluno("Carlos", "3456558", 10, 3, 0, false));
		listaAlunos.add(new Aluno("Sonia", "6544546", 7, 8, 0, false));
		listaAlunos.add(new Aluno("Brianda", "3234535", 6, 5, 0, false));
		listaAlunos.add(new Aluno("Pedro", "4234524", 7, 5, 0, false));
		listaAlunos.add(new Aluno("Julio", "5434513", 7, 2, 0, false));
		listaAlunos.add(new Aluno("Henrique", "6543452", 7, 8, 0, false));
		listaAlunos.add(new Aluno("Fernando", "4345651", 5, 8, 0, false));
		listaAlunos.add(new Aluno("Vitor", "4332341", 7, 9, 0, false));
		return listaAlunos;
	}

}
