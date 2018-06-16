package com.atguigu.survey.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class ExcelUtil {
	    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);
	    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
	    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

	    private ExcelUtil() {
	    }

	    public static List<Map<Integer, String>> readExcelXlsx(String excelFile, int sheetIndex) throws IOException {
	        InputStream is = new FileInputStream(excelFile);
	        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
	        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetIndex);
	        if (xssfSheet == null) {
	            return null;
	        } else {
	            List<Map<Integer, String>> list = new LinkedList();
	            int rowNum = 1;

	            for(int rows = xssfSheet.getLastRowNum(); rowNum <= rows; ++rowNum) {
	                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
	                if (xssfRow != null) {
	                    Map<Integer, String> rowMap = new HashMap();
	                    int col = 0;

	                    for(short cellIndex = xssfRow.getLastCellNum(); col <= cellIndex; ++col) {
	                        Cell cell = xssfRow.getCell(col);
	                        if (cell != null) {
	                            cell.setCellType(1);
	                            rowMap.put(col, cell == null ? "" : cell.getStringCellValue());
	                        }
	                    }

	                    list.add(rowMap);
	                }
	            }

	            return list;
	        }
	    }

	    public static List<Map<Integer, String>> readXls(String excelFile, int sheetIndex) {
	        throw new NullPointerException("unsupport operation");
	    }

	    public static List<Map<Integer, String>> readExcel(String excelFile, int sheetIndex) throws IOException {
	        if (StringUtils.isEmpty(excelFile)) {
	            log.error(" empty excel file");
	            return null;
	        } else {
	            String postfix = excelFile.substring(excelFile.lastIndexOf(".") + 1);
	            if (StringUtils.isNotEmpty(postfix)) {
	                if (StringUtils.equals("xls", postfix)) {
	                    return readXls(excelFile, sheetIndex);
	                }
	            } else if (StringUtils.equals("xls", postfix)) {
	                readExcelXlsx(excelFile, sheetIndex);
	            }

	            return null;
	        }
	    }
	}

