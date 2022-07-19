package it.progettogestionale.web.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import it.progettogestionale.web.model.Applicazione;

public class AppExcelExport {
	private XSSFWorkbook workbook;
	private XSSFSheet fogli;
	private List<Applicazione> listaApp;
	
	
	public AppExcelExport(List<Applicazione> listaApp) {
		this.listaApp = listaApp;
		workbook = new XSSFWorkbook();
	}
	
	
	private void createCell(Row righe, int colonne, Object valore, CellStyle stile) {
		fogli.autoSizeColumn(colonne);
		Cell cella = righe.createCell(colonne);
		if(valore instanceof Long) {
			cella.setCellValue((Long) valore);
		}else if(valore instanceof Integer) {
			cella.setCellValue((Integer) valore);
		}else if(valore instanceof Boolean) {
			cella.setCellValue((Boolean) valore);
		}else {
			cella.setCellValue((String) valore);
		}
		cella.setCellStyle(stile);
	}
	
	private void header() {
		fogli = workbook.createSheet("Applicazioni");
		
		Row righe = fogli.createRow(0);
		CellStyle stile = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(20);
		stile.setFont(font);
		stile.setAlignment(HorizontalAlignment.CENTER);
		createCell(righe, 0,"Info Applicazioni", stile);
		fogli.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
		font.setFontHeightInPoints((short)(10));
		
		righe = fogli.createRow(1);
		font.setBold(true);
		font.setFontHeight(16);
		stile.setFont(font);
		createCell(righe, 0, "Id Applicazione", stile);
		createCell(righe, 1, "Nome Applicazione", stile);
		createCell(righe, 2, "Apmcode", stile);
		createCell(righe, 3, "Ownerafp", stile);
		createCell(righe, 4, "Gdsunit", stile);
		createCell(righe, 5, "Tecnologia", stile);
		createCell(righe, 6, "Server Manager", stile);
		createCell(righe, 7, "Provider", stile);
	}
	
	private void scriviDati() {
		int rowCount = 2;
		
		CellStyle stile = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		stile.setFont(font);
		
		for(Applicazione a : listaApp) {
			Row row = fogli.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, a.getIdApplicazione(), stile);
			createCell(row, columnCount++, a.getNome_App(), stile);
			createCell(row, columnCount++, a.getApmCode(), stile);
			createCell(row, columnCount++, a.getOwnerAFP(), stile);
			createCell(row, columnCount++, a.getGdsUnit(), stile);
			createCell(row, columnCount++, a.getTecnologia(), stile);
			createCell(row, columnCount++, a.getServerManager(), stile);
			createCell(row, columnCount++, a.getProvider(), stile);
		}
	}
	
	public void export(HttpServletResponse response) throws IOException {
		header();
		scriviDati();
		
		ServletOutputStream output = response.getOutputStream();
		workbook.write(output);
		workbook.close();
		output.close();
	}
	
}
