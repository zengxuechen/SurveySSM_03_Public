package com.atguigu.survey.utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.apache.poi.util.IOUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PdfUtil {

    /**
     * 重写 字符设置方法，解决中文乱码问题
     * 
     */
    public static class MyFontsProvider extends XMLWorkerFontProvider {

        public MyFontsProvider(){
            super(null, null);
        }

        @Override
        public Font getFont(final String fontname, String encoding, float size, final int style) {
            String fntname = fontname;
            if (fntname == null) {
                fntname = "宋体";
                //fntname = "fontFile/simsun.ttf";
            }
            if (size == 0) {
                size = 4;
            }
            return super.getFont(fntname, encoding, size, style);
        }
    }

    private static Logger  logger  = LoggerFactory.getLogger(PdfUtil.class);

    /**
     * PDF生成路径
     */
    public static final String PDF_DOWNLOAD_PATH = "D:\\";

    /**
     * 导出PDF文件
     * @param content
     * @param response
     */
    //public void exportPdf(String fileName, String content, HttpServletResponse response) {
    public static void exportPdf(String fileName, String htmlFileName) {
        FileOutputStream fos = null;
        FileInputStream in = null;
        OutputStream out = null;
        Document document = new Document();
        File newPath = null;
        try {
            fileName = "文件名.pdf";
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            String dicPath = new File(".").getCanonicalPath();
            String srcPath = dicPath + PDF_DOWNLOAD_PATH + fileName;

            newPath = new File(dicPath + PDF_DOWNLOAD_PATH);
            newPath.mkdirs();
            // 删除临时文件
            boolean success = fileDelete(newPath);

            if (success) {
                newPath.mkdirs();
                File file = new File(srcPath);
                fos = new FileOutputStream(file);

                PdfWriter writer = PdfWriter.getInstance(document, fos);

                document.open();
                // 使用我们的字体提供器，并将其设置为unicode字体样式
               /* MyFontsProvider fontProvider = new MyFontsProvider();
                fontProvider.addFontSubstitute("lowagie", "garamond");
                fontProvider.setUseUnicode(true);
                CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
                HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
                htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());*/
                XMLWorkerHelper.getInstance().getDefaultCssResolver(true);

                XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(htmlFileName), Charset.forName("UTF-8"));

                document.close();
                writer.close();
                // 设置文件ContentType类型，这样设置，会自动判断下载文件类型
                //response.setContentType("multipart/form-data");
                // 设置响应头，控制浏览器下载该文件
                //response.setHeader("content-disposition", "attachment;filename=" + fileName);
                // 读取要下载的文件，保存到文件输入流
                in = new FileInputStream(srcPath);
                // 创建输出流
                //out = response.getOutputStream();
                // 创建缓冲区
                byte buffer[] = new byte[1024];
                int len = 0;
                // 循环将输入流中的内容读取到缓冲区当中
                /*while ((len = in.read(buffer)) > 0) {
                    // 输出缓冲区的内容到浏览器，实现文件下载
                    out.write(buffer, 0, len);
                }*/
            }
        } catch (DocumentException e) {
            throw new RuntimeException("Export PDF error : ", e);
        } catch (IOException e) {
            throw new RuntimeException("Export PDF error : ", e);
        } catch (Exception e) {
            throw new RuntimeException("Export PDF error : ", e);
        } finally {
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
            if (newPath != null) {
                fileDelete(newPath);
            }
        }
    }

    /**
     * 删除文件
     *
     * @param file
     * @return
     */
    private static boolean fileDelete(File file) {
        if (file.isDirectory()) {
            String[] children = file.list();
            // 递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = fileDelete(new File(file, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return file.delete();
    }
    
    public static void main111(String[] args) {
    	exportPdf("D:\\hahah.pdf", "D:\\1121.html");
    }
    
    
    public static final String HTML = "D:\\040211280056.html";
    public static final String DEST = "D:\\hhh.pdf";
 
    /**
     * Creates a PDF with the words "Hello World"
     * @param file
     * @throws IOException
     * @throws DocumentException
     */
    public static void createPdf(String file) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        // step 3
        document.open();
        BaseFont baseFont = BaseFont.createFont("STSong-Light",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);    
        Font font = new Font(baseFont); 
        document.add(new Paragraph("解决中文问题了！",font));
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(HTML), Charset.forName("UTF-8"));
        // step 5
        document.close();
    }
 
    /**
     * Main method
     */
    public static void main1(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        createPdf(DEST);
    }
    
    public static void main(String[] args) {
    	try {  
    	Document document = new Document();  
    	PdfWriter mPdfWriter = PdfWriter. getInstance(document, new FileOutputStream("D:\\fff222.pdf" ));  
    	document.open();  
    	String s=getHtml();  
    	ByteArrayInputStream bin = new ByteArrayInputStream(s.getBytes());  
    	   XMLWorkerHelper.getInstance().parseXHtml(mPdfWriter, document, bin, null,new ChinaFontProvide());  
    	document.close();  
    	} catch (FileNotFoundException e) {  
    	e.printStackTrace();  
    	} catch (DocumentException e) {  
    	e.printStackTrace();  
    	}catch (Exception e) {  
    	e.printStackTrace();  
    	}  
    	}  
    	  
    	public static String getHtml(){  
    	 StringBuffer html = new StringBuffer();  
    	 html.append("<html>\r\n" + 
    	 		"\r\n" + 
    	 		"	<head>\r\n" + 
    	 		"		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
    	 		"		<meta http-equiv=\"Content-Style-Type\" content=\"text/css\" />\r\n" + 
    	 		"		<meta name=\"description\" content=\"allpku\" />\r\n" + 
    	 		"		<meta name=\"generator\" content=\"Aspose.Words for .NET 15.1.0.0\" />\r\n" + 
    	 		"		<title>人才测评报告模板</title>\r\n" + 
    	 		"		<style>\r\n" + 
    	 		"			body {\r\n" + 
    	 		"				font-family: 楷体;\r\n" + 
    	 		"				font-family: KaiTi;\r\n" + 
    	 		"			}\r\n" + 
    	 		"			\r\n" + 
    	 		"			.font_size26 {\r\n" + 
    	 		"				font-size: 26pt;\r\n" + 
    	 		"			}\r\n" + 
    	 		"			\r\n" + 
    	 		"			.color_red {\r\n" + 
    	 		"				color: red;\r\n" + 
    	 		"			}\r\n" + 
    	 		"			\r\n" + 
    	 		"			.bold {\r\n" + 
    	 		"				font-weight: bold;\r\n" + 
    	 		"			}\r\n" + 
    	 		"			\r\n" + 
    	 		"			table {\r\n" + 
    	 		"				border-collapse: collapse;\r\n" + 
    	 		"				margin-left: 0pt;\r\n" + 
    	 		"				width: 100%;\r\n" + 
    	 		"			}\r\n" + 
    	 		"			\r\n" + 
    	 		"			td {\r\n" + 
    	 		"				border-bottom-color: #000000;\r\n" + 
    	 		"				border-bottom-style: solid;\r\n" + 
    	 		"				border-bottom-width: 0.75pt;\r\n" + 
    	 		"				border-left-color: #000000;\r\n" + 
    	 		"				border-left-style: solid;\r\n" + 
    	 		"				border-left-width: 0.75pt;\r\n" + 
    	 		"				border-right-color: #000000;\r\n" + 
    	 		"				border-right-style: solid;\r\n" + 
    	 		"				border-right-width: 0.75pt;\r\n" + 
    	 		"				border-top-color: #000000;\r\n" + 
    	 		"				border-top-style: solid;\r\n" + 
    	 		"				border-top-width: 0.75pt;\r\n" + 
    	 		"				padding-left: 5.03pt;\r\n" + 
    	 		"				padding-right: 5.03pt;\r\n" + 
    	 		"				vertical-align: middle;\r\n" + 
    	 		"				font-size: 10pt;\r\n" + 
    	 		"			}\r\n" + 
    	 		"			\r\n" + 
    	 		"			ol {\r\n" + 
    	 		"				margin: 0pt;\r\n" + 
    	 		"				padding-left: 0pt;\r\n" + 
    	 		"			}\r\n" + 
    	 		"			\r\n" + 
    	 		"			li {\r\n" + 
    	 		"				color: #f00;\r\n" + 
    	 		"				font-size: 10pt;\r\n" + 
    	 		"				line-height: 20pt;\r\n" + 
    	 		"				list-style-position: inside;\r\n" + 
    	 		"				margin: 0pt;\r\n" + 
    	 		"				text-indent: 0pt\r\n" + 
    	 		"			}\r\n" + 
    	 		"			\r\n" + 
    	 		"			.pStart {\r\n" + 
    	 		"				line-height: 28pt;\r\n" + 
    	 		"				margin: 0pt;\r\n" + 
    	 		"				text-indent: 21.2pt;\r\n" + 
    	 		"				widows: 0;\r\n" + 
    	 		"			}\r\n" + 
    	 		"		</style>\r\n" + 
    	 		"	</head>\r\n" + 
    	 		"\r\n" + 
    	 		"	<body>\r\n" + 
    	 		"		<div>\r\n" + 
    	 		"			<p style=\"margin:78pt 0pt 0pt; text-align:center; widows:0\"><span class=\"color_redfont_size26 bold\">${companyName}公司</span></p>\r\n" + 
    	 		"			<p style=\"margin:31.2pt 0pt 0pt; text-align:center; widows:0\"><span class=\"font_size26 bold\">员工心理测评报告</span></p>\r\n" + 
    	 		"			<p style=\"margin:62.4pt 0pt 0pt; text-align:center; widows:0\"><span class=\"color_redfont_size26 bold\"><img width=50 height=50 src=\"${companyLogo}\" /></span></p>\r\n" + 
    	 		"			<p>&#xa0;</p>\r\n" + 
    	 		"			<table cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>被测评者：</td>\r\n" + 
    	 		"					<td><span class=\"color_red\">${userName}</span></td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>\r\n" + 
    	 		"						<p><span>部门:</span></p>\r\n" + 
    	 		"						<p><span>岗位/职称：</span></p>\r\n" + 
    	 		"					</td>\r\n" + 
    	 		"					<td>\r\n" + 
    	 		"						<p><span class=\"color_red\">${departmentName}</span><span>部</span></p>\r\n" + 
    	 		"						<p><span class=\"color_red\">${positionName}</span></p>\r\n" + 
    	 		"					</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>\r\n" + 
    	 		"						<p><span>报告日期：</span></p>\r\n" + 
    	 		"					</td>\r\n" + 
    	 		"					<td>\r\n" + 
    	 		"						<p><span class=\"color_red\">${year}</span><span>年</span><span class=\"color_red\">${month}</span><span>月</span><span class=\"color_red\">${date}</span><span>日</span></p>\r\n" + 
    	 		"					</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"			</table>\r\n" + 
    	 		"		</div>\r\n" + 
    	 		"		<br style=\"clear:both; mso-break-type:section-break; page-break-before:always\" />\r\n" + 
    	 		"		<div>\r\n" + 
    	 		"			<h1 style=\"font-size:18pt;text-align:center; line-height:200%; margin:15.6pt 0pt; page-break-after:avoid; page-break-inside:avoid; widows:0\"><span style=\" font-size:18pt; bold\">心理测评结果分析</span></h1>\r\n" + 
    	 		"			<p class=\"pStart\">本次测评旨在通过科学、客观、标准的测量手段，对个体的心理特征和特定素质进行数量化测量、分析和评价，从职业性格、心理健康、情绪能力和职业价值观四个方面对个体进行全面的描述。帮助被测评者了解真实的自己，指导大家如何在生活当中来调节自己的心态，从而提高生活和工作的质量!</p>\r\n" + 
    	 		"		</div>\r\n" + 
    	 		"		<br style=\"clear:both; mso-break-type:section-break; page-break-before:always\" />\r\n" + 
    	 		"		<div>\r\n" + 
    	 		"			<h2 style=\"margin:7.8pt 0pt;text-align:center; page-break-after:avoid; page-break-inside:avoid; widows:0\"><span style=\" font-size:15pt; bold\">一</span><span style=\" font-size:15pt; bold\">、</span><span style=\" font-size:15pt; bold\">职业性格测评</span></h2>\r\n" + 
    	 		"			<p class=\"pStart\">“职业性格测评”是以经典的人格类型学理论MBTI为基础，从纷繁复杂的个性特征中，归纳提炼出4个关键要素，进行分析判断，从而把不同性格类型的人区别开来，是当前国际最为流行的职业性格评估工具。不同性格类型之间没有优劣之分，每一种性格类型都具有独特的行为表现和价值取向，了解性格类型是寻求个人发展、探索人际关系的重要开端。MBTI把性格分为4个维度，每个维度上的包含相互对立的2种偏好：</p>\r\n" + 
    	 		"			<br/>\r\n" + 
    	 		"			<table cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>4个维度</td>\r\n" + 
    	 		"					<td colspan=\"2\">2种偏好</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>态度倾向</td>\r\n" + 
    	 		"					<td>Extraversion（E）外倾</td>\r\n" + 
    	 		"					<td>Introversion（I）内倾</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>接受信息</td>\r\n" + 
    	 		"					<td>Sensing（S）感觉</td>\r\n" + 
    	 		"					<td>iNtuition（N）直觉</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>处理信息</td>\r\n" + 
    	 		"					<td>Thinking（T）思考</td>\r\n" + 
    	 		"					<td>Feeling（F）情感</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>行动方式</td>\r\n" + 
    	 		"					<td>Judging（J）判断</td>\r\n" + 
    	 		"					<td>Perceiving（P）知觉</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"			</table>\r\n" + 
    	 		"			<p class=\"pStart\">4个维度上特定偏好的组合就构成一种特定的性格，共16种类型：</p>\r\n" + 
    	 		"			<br/>\r\n" + 
    	 		"			<table cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>ESTP</td>\r\n" + 
    	 		"					<td>创业者</td>\r\n" + 
    	 		"					<td>ISTP</td>\r\n" + 
    	 		"					<td>手艺者</td>\r\n" + 
    	 		"					<td>ESFP</td>\r\n" + 
    	 		"					<td>表演者</td>\r\n" + 
    	 		"					<td>ISFP</td>\r\n" + 
    	 		"					<td>创作者</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>ESTJ</td>\r\n" + 
    	 		"					<td>监督者</td>\r\n" + 
    	 		"					<td>ISTJ</td>\r\n" + 
    	 		"					<td>检查者</td>\r\n" + 
    	 		"					<td>ESFJ</td>\r\n" + 
    	 		"					<td>供应者</td>\r\n" + 
    	 		"					<td>ISFJ</td>\r\n" + 
    	 		"					<td>保护者</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>ENFJ</td>\r\n" + 
    	 		"					<td>领导者</td>\r\n" + 
    	 		"					<td>INFJ</td>\r\n" + 
    	 		"					<td>劝告者</td>\r\n" + 
    	 		"					<td>ENFP</td>\r\n" + 
    	 		"					<td>奋斗者</td>\r\n" + 
    	 		"					<td>INFP</td>\r\n" + 
    	 		"					<td>化解者</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>ENTJ</td>\r\n" + 
    	 		"					<td>领袖者</td>\r\n" + 
    	 		"					<td>INTJ</td>\r\n" + 
    	 		"					<td>策划者</td>\r\n" + 
    	 		"					<td>ENTP</td>\r\n" + 
    	 		"					<td>发明家</td>\r\n" + 
    	 		"					<td>INTP</td>\r\n" + 
    	 		"					<td>思想家</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"			</table>\r\n" + 
    	 		"			<p class=\"pStart\">备注：MBTI相信，个人所认为的自己的类型往往是最符合其自己的判断，受测者也可以基于自己对MBTI四维度两分法的理解，初步形成其自己假设的整体类型，并和报告的类型相比较，通过比对，可以帮助受测者确定自己的最佳拟合。</p>\r\n" + 
    	 		"			<br/>\r\n" + 
    	 		"			<table cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>行为风格类型</td>\r\n" + 
    	 		"					<td>${styleTypeCode}${styleTypeTendency}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>主要特征</td>\r\n" + 
    	 		"					<td>${styleTypeName}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>特点描述</td>\r\n" + 
    	 		"					<td>\r\n" + 
    	 		"						${styleTypeDesc}\r\n" + 
    	 		"						<!--<ol type=\"1\">\r\n" + 
    	 		"							<li>具有创造性的思想，目光远大，可以清楚地看到未来的可能性和组织，对外部事件能够迅速找到有意义的模式，构想好各种战略，并竭力去实施自己的想法和目标。</li>\r\n" + 
    	 		"							<li>在实现自己的想法、达成自己的目标或在自己感兴趣的领域，有创新的想法和非凡的动力</li>\r\n" + 
    	 		"							<li>不轻信、具批判性、独立性，有决心。</li>\r\n" + 
    	 		"							<li>喜欢来自多方面的挑战，愿意做综合理论性和抽象化的复杂事物的工作。</li>\r\n" + 
    	 		"							<li>高度重视知识，对于自己和他人能力和表现的要求都非常高。</li>\r\n" + 
    	 		"							<li>尤其讨厌不知所指、混乱和低效率。</li>\r\n" + 
    	 		"						</ol>-->\r\n" + 
    	 		"					</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>盲点提示</td>\r\n" + 
    	 		"					<td>\r\n" + 
    	 		"						${blindSpotTips}\r\n" + 
    	 		"						<!--<ol type=\"1\">\r\n" + 
    	 		"							<li>常常只注重自己，很少去理解他人，自以为是，对他人没有耐心，总是想当然的把自己的观点强加给别人，制定不切实际的高标准。建议发自内心地多关注、理解和欣赏他人，对自己和他人都需要多一些耐心，循序渐进。</li>\r\n" + 
    	 		"							<li>过分独立的个性和工作习惯，使得你总是“拒绝”别人的参与和帮助，难以发现自己计划中的缺陷。建议多参与集体活动，学会与他人分享，尝试与不同类型的人合作，取长补短。</li>\r\n" + 
    	 		"							<li>过于注重远见卓识，很容易忽略细节，没有注意到周围环境的变化；过于理论化而不考虑实际情况，易受愿景规划的诱惑，难以具体落实。建议在规划未来的同时，不要忘了着眼于实际，尊重过往经验，留心细节。</li>\r\n" + 
    	 		"						</ol>-->\r\n" + 
    	 		"					</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>适合职业</td>\r\n" + 
    	 		"					<td>${suitedCareer}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"			</table>\r\n" + 
    	 		"		</div>\r\n" + 
    	 		"		<br style=\"clear:both; mso-break-type:section-break; page-break-before:always\" />\r\n" + 
    	 		"		<div>\r\n" + 
    	 		"			<h2 style=\"margin:7.8pt 0pt; text-align:center; page-break-after:avoid; page-break-inside:avoid; widows:0\"><span style=\" font-size:15pt; bold\">二、心理健康测评</span></h2>\r\n" + 
    	 		"			<p class=\"pStart\">心理健康症状自评量表是为了评定个体在感觉、情绪、思维、行为直至生活习惯、人际关系、饮食睡眠等方面的心理健康症状而设计的。SCL-90的统计指标主要为两项，即总分和因子分。</p>\r\n" + 
    	 		"			<p class=\"pStart\">总分项目：</p>\r\n" + 
    	 		"			<p class=\"pStart\">（1）总均分：总分/90，表示从总体情况看，该受检者的自我感觉位于1-5级间的哪一个分值程度上。</p>\r\n" + 
    	 		"			<p class=\"pStart\">（2）阳性项目数：单项分≥2的项目数，表示受检者在多少项目上呈有“病状”。</p>\r\n" + 
    	 		"			<p class=\"pStart\">（3）阳性症状均分：（总分－阴性项目数的总分）/阳性项目数，表示受检者在“有症状”项目中的平均得分。反映受检者自我感觉不佳的项目，其严重程度究竟介于哪个范围。</p>\r\n" + 
    	 		"			<p class=\"pStart\">该量表包括9个因子，即躯体化、强迫症状、人际关系敏感、抑郁、焦虑、敌对、恐怖、偏执和精神病性。通过因子分可反映出个体某方面的症状情况。当个体在某一因子的得分大于2时，即超出正常均分，则个体在该方面就很有可能有心理健康风险。</p>\r\n" + 
    	 		"			<br/>\r\n" + 
    	 		"			<table cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td colspan=\"2\">症状</td>\r\n" + 
    	 		"					<td style=\"width:50pt\">标准值</td>\r\n" + 
    	 		"					<td style=\"width:50pt\">测评值</td>\r\n" + 
    	 		"					<td>症状描述</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td rowspan=\"3\" style=\"width:16pt\">总症状</td>\r\n" + 
    	 		"					<td>总均分</td>\r\n" + 
    	 		"					<td>1.5分</td>\r\n" + 
    	 		"					<td>${score_ALL_AVERAGE}分</td>\r\n" + 
    	 		"					<td>${desc_ALL_AVERAGE}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>阳性项目数</td>\r\n" + 
    	 		"					<td>43个</td>\r\n" + 
    	 		"					<td>${count_ALL_POSITIVENUM}个</td>\r\n" + 
    	 		"					<td rowspan=\"2\">${symptomDesc_ALL_POSITIVEAVERAGE}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>阳性症状均分</td>\r\n" + 
    	 		"					<td>2分</td>\r\n" + 
    	 		"					<td>${score_ALL_POSITIVEAVERAGE}分</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td rowspan=\"10\" style=\"width:16pt\">分症状均分</td>\r\n" + 
    	 		"					<td>躯体化</td>\r\n" + 
    	 		"					<td rowspan=\"10\">2分</td>\r\n" + 
    	 		"					<td style=\"background-color:#bfbfbf;\">${score_PART_SOMATIZATION}分</td>\r\n" + 
    	 		"					<td>${symptomDesc_PART_SOMATIZATION}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>强迫症状</td>\r\n" + 
    	 		"					<td style=\"background-color:#bfbfbf;\">${score_PART_OBSESSION}分</td>\r\n" + 
    	 		"					<td>${symptomDesc_PART_OBSESSION}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>人际关系敏感</td>\r\n" + 
    	 		"					<td style=\"background-color:#bfbfbf;\">${score_PART_INTERPERSONAL}分</td>\r\n" + 
    	 		"					<td>${symptomDesc_PART_INTERPERSONAL}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>抑郁</td>\r\n" + 
    	 		"					<td style=\"background-color:#bfbfbf;\">${score_PART_DEPRESSED}分</td>\r\n" + 
    	 		"					<td>${symptomDesc_PART_DEPRESSED}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>焦虑</td>\r\n" + 
    	 		"					<td>${score_PART_ANXIOUS}分</td>\r\n" + 
    	 		"					<td>${symptomDesc_PART_ANXIOUS}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>敌对</td>\r\n" + 
    	 		"					<td>${score_PART_HOSTILE}分</td>\r\n" + 
    	 		"					<td>${symptomDesc_PART_HOSTILE}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>恐怖</td>\r\n" + 
    	 		"					<td>${score_PART_TERROR}分</td>\r\n" + 
    	 		"					<td>${symptomDesc_PART_TERROR}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>偏执</td>\r\n" + 
    	 		"					<td>${score_PART_PARANOID}分</td>\r\n" + 
    	 		"					<td>${symptomDesc_PART_PARANOID}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>精神病性</td>\r\n" + 
    	 		"					<td>${score_PART_PSYCHOSIS}分</td>\r\n" + 
    	 		"					<td>${symptomDesc_PART_PSYCHOSIS}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>其他（睡眠及饮食情况）</td>\r\n" + 
    	 		"					<td style=\"background-color:#bfbfbf;\">${score_PART_OTHER}分</td>\r\n" + 
    	 		"					<td>${symptomDesc_PART_OTHER}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"			</table>\r\n" + 
    	 		"		</div>\r\n" + 
    	 		"		<br style=\"clear:both; mso-break-type:section-break; page-break-before:always\" />\r\n" + 
    	 		"		<div>\r\n" + 
    	 		"			<h2 style=\"margin:7.8pt 0pt; text-align:center; page-break-after:avoid; page-break-inside:avoid; widows:0\"><span style=\" font-size:15pt; bold\">三、情绪能力测评</span></h2>\r\n" + 
    	 		"			<p class=\"pStart\">情绪能力测评是以国际标准情商测试为基础，是一组欧洲流行的测试题可口可乐公司、麦当劳公司、诺基亚分司等世界500强众多企业，曾以此为员工EQ测试的模板，帮助员工了解自己的EQ状况。</p>\r\n" + 
    	 		"			<p class=\"pStart\">情商测评从自我觉知、自我激励、自我调控、社会觉知和社会技能五个维度全面地考察受测者的表现。</p>\r\n" + 
    	 		"			<p class=\"pStart\">（1）自我觉知：对自我情绪、价值的觉知、认可和接纳</p>\r\n" + 
    	 		"			<p class=\"pStart\">（2）自我激励：激发利于工作完成的情绪状态，以更好地完成工作</p>\r\n" + 
    	 		"			<p class=\"pStart\">（3）自我调控：自主的调解自身情绪状态和行为以适应任务和目标的要求</p>\r\n" + 
    	 		"			<p class=\"pStart\">（4）社会觉知：通过各种信息感知他人的情绪和内心感受，站在组织或他人的角度思考问题</p>\r\n" + 
    	 		"			<p class=\"pStart\">（5）社会技能：理解和读懂他人，利用情绪技巧在人际关系中有效行动，获得他人的接纳和欢迎</p>\r\n" + 
    	 		"			<br/>\r\n" + 
    	 		"			<table cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>测评得分</td>\r\n" + 
    	 		"					<td>${pa_ec_score}分</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>特点描述</td>\r\n" + 
    	 		"					<td>${sectionDesc}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"			</table>\r\n" + 
    	 		"		</div>\r\n" + 
    	 		"		<br style=\"clear:both; mso-break-type:section-break; page-break-before:always\" />\r\n" + 
    	 		"		<div>\r\n" + 
    	 		"			<h2 style=\"margin:7.8pt 0pt; text-align:center; page-break-after:avoid; page-break-inside:avoid; widows:0\"><span style=\" font-size:15pt; bold\">四、职业价值观测评</span></h2>\r\n" + 
    	 		"			<p class=\"pStart\">职业价值观测评是以职业锚测验为基础，根据美国E.H.施恩的职业锚理论，测量的是员工内心深处价值观、能力和动机的整合体，指当一个人不得不做出选择的时候，无论如何都不会放弃的职业中的那种至关重要的东西。分为：技术/职能型、管理型、自主/独立型、安全/稳定型、创造/创业型、服务型、挑战性、生活型8种职业锚类型</p>。\r\n" + 
    	 		"			<br/>\r\n" + 
    	 		"			<table cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td rowspan=\"2\">职业锚类型</td>\r\n" + 
    	 		"					<td>技术/职能型TF</td>\r\n" + 
    	 		"					<td>管理型GM</td>\r\n" + 
    	 		"					<td>自主/独立型AU</td>\r\n" + 
    	 		"					<td>安全/稳定型SE</td>\r\n" + 
    	 		"					<td>创造/创业型EC</td>\r\n" + 
    	 		"					<td>服务型SV</td>\r\n" + 
    	 		"					<td>挑战型CH</td>\r\n" + 
    	 		"					<td>生活型LS</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>${star1}</td><td>${star2}</td><td>${star3}</td><td>${star4}</td><td>${star5}</td><td>${star6}</td><td>${star7}</td><td>${star8}</td>\r\n" +
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>特点概述</td>\r\n" + 
    	 		"					<td colspan=\"8\">${characterSummarize}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"				<tr>\r\n" + 
    	 		"					<td>特点描述</td>\r\n" + 
    	 		"					<td colspan=\"8\">${characterDesc}</td>\r\n" + 
    	 		"				</tr>\r\n" + 
    	 		"			</table>\r\n" + 
    	 		"		</div>\r\n" + 
    	 		"		<br style=\"clear:both; mso-break-type:section-break; page-break-before:always\" />\r\n" + 
    	 		"		<div>\r\n" + 
    	 		"			<h2 style=\"margin:7.8pt 0pt; text-align:center; page-break-after:avoid; page-break-inside:avoid; widows:0\"><span style=\" font-size:15pt; bold\">五、个人发展建议</span></h2>\r\n" + 
    	 		"			<p class=\"pStart\">现在您对自己的职业性格、心理健康、情绪能力和职业价值观已经有了一定的了解，但如何通过这些信息使您在工作和生活上变得更好才是关键所在，北大纵横基于多年人才测评咨询和职业生涯规划的心得体会和经验总结，给您提出如下几点个人发展建议：</p>\r\n" + 
    	 		"			<ol type=\"1\">\r\n" + 
    	 		"				<li>考虑实际情况，关注细节；</li>\r\n" + 
    	 		"				<li>学会理解人与人之间的差异，保持足够的耐心和包容心；</li>\r\n" + 
    	 		"				<li>学会倾听不同的声音，认同别人所提意见的价值；</li>\r\n" + 
    	 		"				<li>时刻有意识地管理自己的情绪；</li>\r\n" + 
    	 		"				<li>阳光心态，增强活力；</li>\r\n" + 
    	 		"				<li>放轻松，平衡你的工作和个人生活。</li>\r\n" + 
    	 		"			</ol>\r\n" + 
    	 		"			<p style=\"margin:50pt; text-align:center; widows:0\"><span class=\"font_size26 bold\">感谢您的参与！</span></p>\r\n" + 
    	 		"		</div>\r\n" + 
    	 		"	</body>\r\n" + 
    	 		"\r\n" + 
    	 		"</html>");  
    	     return html.toString();  
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
    	       e.printStackTrace();  
    	     }  
    	     Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);  
    	     return FontChinese;  
    	   }  
    	  
    	  
    	   public boolean isRegistered(String arg0) {  
    	     return false;  
    	   }  
    	 }   
}