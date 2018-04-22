package com.atguigu.survey.utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PdfUtil {

	private PdfUtil() {
	}
    
    /**
     * 根据传入的PDF模板文件內容生成相应的PDF临时文件
     * @param filename
     */
    public static void createTempPdf(String content, String fileName) {
    	try {  
    	Document document = new Document();  
    	PdfWriter mPdfWriter = PdfWriter. getInstance(document, new FileOutputStream(fileName));  
    	document.open();  
    	ByteArrayInputStream bin = new ByteArrayInputStream(content.getBytes());  
    	   XMLWorkerHelper.getInstance().parseXHtml(mPdfWriter, document, bin, null,new ChinaFontProvide());  
    	document.close();
    	} catch (FileNotFoundException e) {  
    	} catch (DocumentException e) {  
    	} catch (Exception e) {  
    	}  
    	}  
    	  
    	public static String getHtml(String fileName){
    	     return readToString(fileName);  
    	}  
    	/** 
    	*  提供中文 
    	*/  
    	public static final  class  ChinaFontProvide implements FontProvider{  
    	  
    	   public Font getFont(String arg0, String arg1, boolean arg2, float arg3,  
    	       int arg4, BaseColor arg5) {  
    	     BaseFont bfChinese =null;  
    	     try {  
    	       bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);  
    	     } catch (Exception e) {  
    	     }  
    	     return new Font(bfChinese, 12, Font.NORMAL);  
    	   }  
    	  
    	  
    	   public boolean isRegistered(String arg0) {  
    	     return false;  
    	   }  
    	 }   
    	
    	public static String readToString(String fileName) {
            String encoding = "UTF-8";  
            File file = new File(fileName);  
            Long filelength = file.length();  
            byte[] filecontent = new byte[filelength.intValue()];  
            try {
                FileInputStream in = new FileInputStream(file);  
                in.read(filecontent);  
                in.close();  
            } catch (FileNotFoundException e) {  
            } catch (IOException e) {  
            }  
            try {  
                return new String(filecontent, encoding);  
            } catch (UnsupportedEncodingException e) {  
                log.info("The OS does not support " + encoding);  
                return null;  
            }  
        }  	
    	
}