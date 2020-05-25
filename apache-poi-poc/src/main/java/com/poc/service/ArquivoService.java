package com.poc.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.poc.entity.Aluno;
import com.poc.entity.Constantes;

public class ArquivoService {
	
	public static void criaNovoArquivo(HSSFWorkbook workbook) {
		try {
			FileOutputStream out = new FileOutputStream(new File(Constantes.FILE_NAME));
			workbook.write(out);
			out.close();
			System.out.println("Arquivo Excel criado com sucesso!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo nao encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edicao do arquivo!");
		}
	}

	public static void populaArquivo(HSSFSheet sheetAlunos, List<Aluno> listaAlunos) {
		int rownum = 0;
		for (Aluno aluno : listaAlunos) {
			Row row = sheetAlunos.createRow(rownum++);
			int cellnum = 0;
			Cell cellNome = row.createCell(cellnum++);
			cellNome.setCellValue(aluno.getNome());
			Cell cellRa = row.createCell(cellnum++);
			cellRa.setCellValue(aluno.getRa());
			Cell cellNota1 = row.createCell(cellnum++);
			cellNota1.setCellValue(aluno.getNota1());
			Cell cellNota2 = row.createCell(cellnum++);
			cellNota2.setCellValue(aluno.getNota2());
			Cell cellMedia = row.createCell(cellnum++);
			cellMedia.setCellValue((aluno.getNota1() + aluno.getNota2()) / 2);
			Cell cellAprovado = row.createCell(cellnum++);
			cellAprovado.setCellValue(cellMedia.getNumericCellValue() >= 6);
		}
	}	
	
	public static void AlteraArquivo(HSSFSheet sheetAlunos) {
		for (int i = 0; i < sheetAlunos.getPhysicalNumberOfRows(); i++) {
			Row row = sheetAlunos.getRow(i);
			Cell cellNota1 = row.getCell(2);
			if (cellNota1.getNumericCellValue() < 9) {
				cellNota1.setCellValue(cellNota1.getNumericCellValue() + 1);
			} else {
				cellNota1.setCellValue(10);
			}
			Cell cellNota2 = row.getCell(3);
			Cell cellMedia = row.getCell(4);
			cellMedia.setCellValue((cellNota1.getNumericCellValue() + cellNota2.getNumericCellValue()) / 2);
			Cell cellAprovado = row.getCell(5);
			cellAprovado.setCellValue(cellMedia.getNumericCellValue() >= 6);
		}
	}
}
