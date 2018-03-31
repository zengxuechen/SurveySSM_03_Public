package com.atguigu.survey.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import com.atguigu.survey.entities.manager.Auth;
import com.atguigu.survey.entities.manager.Res;
import com.atguigu.survey.entities.manager.Role;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class DataProcessUtils {

	/**
	 * 深度赋值
	 * @param sourceObject 源对象
	 * @return 目标对象
	 */
	public static Serializable deeplyCopy(Serializable sourceObject){
		//深度赋值后的目标对象
		Serializable targetObject = null ;		
		
		//创建四个流的变量
		ObjectInputStream ois = null ;
		ObjectOutputStream oos = null ;
		ByteArrayInputStream bais = null ;
		ByteArrayOutputStream baos = null ;

		try {
			//创建流对象
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			
			//序列化
			oos.writeObject(sourceObject);
			
			byte[] byteArray = baos.toByteArray();
			
			bais = new ByteArrayInputStream(byteArray);			
			ois = new ObjectInputStream(bais);
			
			//反序列化
			targetObject = (Serializable)ois.readObject();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return targetObject ;
	}
	
	
	/**
	 * 验证包裹序号是否存在重复值
	 * @param bagOrderList
	 * @return false表示存在重复
	 */
	public static boolean checkBagOrderDuplicate(List<Integer> bagOrderList){
		
		Set<Integer> bagOrderSet = new HashSet<Integer>(bagOrderList);
		
		return bagOrderList.size() == bagOrderSet.size();
	}
	
	/**
	 * 将图片压缩按本来的长宽比例压缩为100宽度的jpg图片
	 * @param inputStream
	 * @param realPath /surveyLogos目录的真实路径，后面没有斜杠
	 * @return 将生成的文件路径返回 surveyLogos/4198393905112.jpg
	 */
	public static String resizeImages(InputStream inputStream, String realPath) {
		
		OutputStream out = null;
		
		try {
			//1.构造原始图片对应的Image对象
			BufferedImage sourceImage = ImageIO.read(inputStream);

			//2.获取原始图片的宽高值
			int sourceWidth = sourceImage.getWidth();
			int sourceHeight = sourceImage.getHeight();
			
			//3.计算目标图片的宽高值
			int targetWidth = sourceWidth;
			int targetHeight = sourceHeight;
			
			if(sourceWidth > 100) {
				//按比例压缩目标图片的尺寸
				targetWidth = 100;
				targetHeight = sourceHeight/(sourceWidth/100);
				
			}
			
			//4.创建压缩后的目标图片对应的Image对象
			BufferedImage targetImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
			
			//5.绘制目标图片
			targetImage.getGraphics().drawImage(sourceImage, 0, 0, targetWidth, targetHeight, null);
			
			//6.构造目标图片文件名
			String targetFileName = System.nanoTime() + ".jpg";
			
			//7.创建目标图片对应的输出流
			out = new FileOutputStream(realPath+"/"+targetFileName);
			
			//8.获取JPEG图片编码器
			
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			
			//9.JPEG编码 
			encoder.encode(targetImage);
			
			//10.返回文件名
			return "surveyLogos/"+targetFileName;
			
		} catch (Exception e) {
			
			return null;
		} finally {
			//10.关闭流
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
	/**
	 * MD5加密：将指定字符串加密后返回
	 * @param source 源字符串
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException 
	 */
	public static String md5(String source) {

		//检查源字符串是否为null
		if(source==null || source.length() == 0){
			return null ;
		}
		
		//获取源字符串的字节数组
		byte[] bytes = source.getBytes();	
		
		try {
			//获取MessageDigest对象
			MessageDigest instance = MessageDigest.getInstance("MD5");
			
			//将字节数组加密返回新的数组
			byte[] digest = instance.digest(bytes);
			
			return convertToString(digest);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null ;
	}

	private static String convertToString(byte[] digest) {
		
		StringBuilder builder = new StringBuilder();
		
		//定义字符数组
		char[] characters = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		for (int i = 0 ; i < digest.length; i++ ) {
			
			byte b = digest[i];
			
			//获取b字节的高四位和低四位的10进制数值
			int low = b & 15 ;
			int high = (b>>4) & 15 ;
			
			//根据高四位和低四位的值从字符数组中获取字符
			char lowChar = characters[low];
			char highChar = characters[high];
			
			//拼接高四位和低四位获取到的字符
			builder.append(highChar).append(lowChar);
		}
		
		return builder.toString();
	}


	/**
	 * 专业祛痘
	 * @param temp
	 * @return
	 */
	public static String removeComma(String temp,String operator) {
		if(temp==null || temp.length()==0){
			return temp ;
		}
		
		//判断当前字符串中是否以逗号开头
		if(temp.startsWith(operator)){
			temp = temp.substring(1);
		}
		
		//判断当前字符串中是否以逗号结尾
		if(temp.endsWith(operator)){
			temp = temp.substring(0, temp.length()-1);//半开，半闭
		}
		return temp;
	}

	/**
	 * 将[1,2,3]或[Good]形式的数组转换为对应的字符串
	 * @param paramValues 一个参数名称，对应多个参数值的数组
	 * @return 返回字符串
	 */
	public static String convertParamValues(String[] paramValues) {
		
		if(paramValues==null || paramValues.length == 0){
			return "";
		}
		
		StringBuilder builder = new StringBuilder();
		
		for (String value : paramValues) {
			builder.append(value).append(",");
		}
		
		return DataProcessUtils.removeComma(builder.toString(), ",");
	}


	/**
	  *  检查路径时，需要去掉占位符表示的参数
	  *  /guest/survey/removeSurvey
	  *  /guest/survey/removeSurvey/12
	  *  /guest/survey/rem oveSurvey/11/13
	  *  /guest/survey/removeSurvey/11/abc/22
	  *  只考虑前三节路径
	 */
	public static String cutPath(String servletPath) {
		
		//1.使用split()将servletPath分解
		String[] split = servletPath.split("/");
		
		//2.将数组下标为1,2,3拼接成一个字符串
		servletPath = "/" + split[1] + "/" + split[2] + "/" + split[3] ;
		
		return servletPath;
	}


	/**
	 * 不管是管理员还是普通员工都需要计算验证码数组，所以封装成一个工具方法
	 * @param roleSet
	 * @return
	 */
	public static String calculateCodeArr(Set<Role> roleSet,int maxPos) {
		
		//定义保存当前用户权限码的数组:数组长度=最大的权限位+1
		// maxPos++    ++maxPos   不要定义为Integer数组，默认值为null,不能直接做位运算
		int[] codeArr = new int[maxPos+1];  //数组元素默认值都是0，表示没有权限
		
		//逐层迭代
		for (Role role : roleSet) {
			Set<Auth> authSet = role.getAuthSet();
			for (Auth auth : authSet) {
				Set<Res> resSet = auth.getResSet();
				for (Res res : resSet) {
					Integer resCode = res.getResCode();
					Integer resPos = res.getResPos();
					
					int oldValue = codeArr[resPos];
					int newValue = oldValue | resCode ;
					
					codeArr[resPos] = newValue ;
				}
			}
		}
		
		//将数组转换为字符串
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < codeArr.length; i++) {
			builder.append(codeArr[i]).append(",");
		}
		
		//去掉默认逗号后返回用户 权限码 字符串
		return DataProcessUtils.removeComma(builder.toString(), ",");
	}
	
	
	/**
	 * 检查资源访问权限
	 * @param codeArrStr 用户权限码
	 * @param res 当前资源权限码
	 * @return true表示有权限访问；false表示没有权限访问
	 */
	public static boolean checkedAuthority(String codeArrStr,Res res){
		
		//将数据库中存储的字符串权限码，转换为字符串数组形式
		String[] codeArr = codeArrStr.split(",");
		
		//将字符串数组转换为int类型数组形式的权限码
		int[] codeArrInt = new int[codeArr.length];
		
		for (int i = 0; i < codeArrInt.length; i++) {
			String codeStr = codeArr[i];
			int code = Integer.parseInt(codeStr);
			codeArrInt[i] = code;
		}
		
		//获取资源的权限位
		Integer resPos = res.getResPos();
		//获取资源的权限码
		Integer resCode = res.getResCode();
		
		//根据权限位，从用户的权限码数组中获取用户的权限码
		int userCode = codeArrInt[resPos];
		
		//将用户的权限码和资源的权限码进行与运算
		int result = userCode & resCode ; //0表示没有权限，1表示有权限
		System.out.println(res + " 资源的访问权限是： " + result);
		
		return result != 0 ;
	}
	
	
	/**
	 * 生成表的名称
	 * @param ofset 偏移量
	 * 		以当前月为基准，偏移月份的数量
	 * 		例如：
	 * 			-1：上个月
	 * 			0：这个月
	 * 			1：下个月
	 * @return 表名称
	 */
	public static String generateTableName(int offset){
		
		Calendar instance = Calendar.getInstance();
		
		instance.add(Calendar.MONTH, offset);
		
		Date time = instance.getTime();
		
		String timeStr = new SimpleDateFormat("yyyy_MM").format(time);
		
		return "manager_log_"+timeStr ;
	}
	
	
	/**
	 * 根据日志表的表名集合，通过union将这些表合并为一张表，作为分页查询的子表使用
	 * @param logTableNameList 日志数据库的所有日志表
	 * @return union到一起的表
	 */
	public static String generateSubQueryUnionTable(List<String> logTableNameList){
		
		StringBuilder builder = new StringBuilder();
		
		for (String logTableName : logTableNameList) {
			builder.append("SELECT * FROM ").append(logTableName).append(" UNION ");
		}
		
		return builder.substring(0, builder.lastIndexOf(" UNION ")) ;
	}
	
}
