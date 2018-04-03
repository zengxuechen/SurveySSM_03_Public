package com.atguigu.survey.utils;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIUtils {
	

	//public void exportExcel(HttpServletResponse response) throws IOException{
	public void exportExcel() throws IOException{
		
		//1.创建HSSFWorkbook对象
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//2.鍒涘缓宸ヤ綔鍖哄悕绉�
		String sheetname = "sheetName";
		
		//3.鍒涘缓宸ヤ綔鍖�
		HSSFSheet sheet = workbook.createSheet(sheetname);
		
		//4.鍒涘缓琛岋紝绗竴琛屼负鎵�鏈夐棶棰樺悕绉�
		HSSFRow firstRow = sheet.createRow(0);
		
		//5.杩唬闂闆嗗悎,璁剧疆绗竴琛屽崟鍏冩牸鏁版嵁
		for (int i=0; i<5; i++) {
			String questionName = "sss";
			
			HSSFCell cell = firstRow.createCell(i);
			cell.setCellValue(questionName);
		}
		
		
		//2.获取输出流
		//ServletOutputStream outputStream = response.getOutputStream();

		//3.准备文件名字符串
		String fileName = System.nanoTime() + ".xls";
		
		//4.设置响应的内容类型
		//response.setContentType("application/vnd.ms-excel");
		
		//5.设置浏览器下载文件时的文件名响应消息头
		//response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		
		//6.将HSSFWorkbook中数据写入输出流，返回给客户端
		//workbook.write(outputStream);
	}
	
}
