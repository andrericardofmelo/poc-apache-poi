package com.poc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.poc.entity.Aluno;
import com.poc.util.Constantes;

/***
 * 
 * @author andre.melo
 * @Date 14/12/2018
 * @description Classe responsável por abrir um arquivo excel, ler os dados,
 *              aplicar as regras de négocio do objeto aluno e imprimir no
 *              console.
 *
 */
@SuppressWarnings("resource")
public class AbreExcel {

	public static void main(String[] args) throws IOException {

		List<Aluno> listaAlunos = new ArrayList<Aluno>();

		try {
			// Abrindo o arquivo.
			FileInputStream arquivo = new FileInputStream(new File(Constantes.newFileName));

			// Validando se o arquivo é ou não um arquivo excel.
			HSSFWorkbook workbook = new HSSFWorkbook(arquivo);

			// Abrindo a planilha com índice 0.
			HSSFSheet sheetAlunos = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheetAlunos.iterator();

			// Trecho que faz a leitura linha a linha.
			while (rowIterator.hasNext()) {
				Aluno aluno = new Aluno();

				// Recupera a próxima linha.
				Row row = rowIterator.next();

				// Lê as celulas da linha.
				Iterator<Cell> cellIterator = row.cellIterator();

				// Percorre todas as células e popula o objeto aluno.
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getColumnIndex()) {
					case 0:
						aluno.setNome(cell.getStringCellValue());
						break;
					case 1:
						aluno.setRa(cell.getStringCellValue());
						break;
					case 2:
						aluno.setNota1(cell.getNumericCellValue());
						break;
					case 3:
						aluno.setNota2(cell.getNumericCellValue());
						break;
					case 4:
						aluno.setMedia(cell.getNumericCellValue());
						break;
					case 5:
						aluno.setAprovado(cell.getBooleanCellValue());
						break;
					}
				}
				listaAlunos.add(aluno);
			}
			arquivo.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!");
		}

		if (listaAlunos.size() == 0) {
			System.out.println("Nenhum aluno encontrado!");
		} else {
			double soma = 0;
			double maior = 0;
			double menor = listaAlunos.get(0).getMedia();
			int aprovados = 0;
			int reprovados = 0;

			// Percorre a lista de alunos e verifica a situação (APROVADO ou REPROVADO).
			for (Aluno aluno : listaAlunos) {
				System.out.println("Aluno: " + aluno.getNome() + " Média: " + aluno.getMedia());
				soma = soma + aluno.getMedia();
				if (aluno.getMedia() > maior) { // Refatorar esses If's.
					maior = aluno.getMedia();
				}
				if (aluno.getMedia() < menor) {
					menor = aluno.getMedia();
				}
				if (aluno.getMedia() >= 6) {
					aprovados++;
				}
				if (aluno.getMedia() < 6) {
					reprovados++;
				}
			}

			// Média de todos os alunos.
			double media = soma / listaAlunos.size();

			// Imprime as informações.
			System.out.println("A media de notas e: " + media);
			System.out.println("A maior nota e: " + maior);
			System.out.println("A menor nota e: " + menor);
			System.out.println("O numero de alunos aprovados e: " + aprovados);
			System.out.println("O numero de alunos reprovados e: " + reprovados);
			System.out.println("Número total de alunos: " + listaAlunos.size());
		}

	}

}
