package com.atguigu.survey.utils;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Base64;

/**
 * 简单的加密解密算法
 * @author Monarch
 *
 */
public class SimpleEncrypUtil {
	
	private final static int C1 = 520;
    private final static int C2 = 1314;
    
	 /**
     *    加密函数
      */
    public static  String Encrypt(String S, int Key) {

        ByteBuffer buffer=ByteBuffer.allocate(S.length()*2);

        for (int i = 0; i < S.length(); i++) {
            // 依次对字符串中各字符进行操作

            char c=(char)((S.charAt(i)) ^ (Key >> 8));
            System.out.println(i+"c: "+(int)c);
            byte[] b=charToByte(c);

            buffer.put(b);

            Key = (Key>>8) * C1 + C2; // 产生下一个密钥
        }
       // System.out.println(buffer.);
        buffer.flip();  
        // 构建一个byte数组  
        byte[] content = new byte[buffer.limit()];  
        // 从ByteBuffer中读取数据到byte数组中  
        buffer.get(content);  

        // 把byte数组的内容写到标准输出  
        System.out.println(bytesToHexString(content)); 

        return   new String(Base64.getEncoder().encodeToString(content));

    }

    /**
     *  解密函数
      */


    public static String Decrypt(String S, int Key) {
        StringBuffer Result = new StringBuffer();
        byte[] content;
        try {
            content=Base64.getDecoder().decode(S.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
        System.out.println("content: "+bytesToHexString(content));
        for (int i = 0; i < content.length/2; i++) // 依次对字符串中各字符进行操作
        {
            byte [] b={content[i*2],content[i*2+1]};
            char c=byteToChar(b);

            System.out.println(i+"c: "+(int)c);
            Result.append((char)( c ^ (Key >> 8))); // 将密钥移位后与字符异或


            Key = (Key>>8) * C1 + C2; // 产生下一个密钥;
        }
        return Result.toString();
    }


    //char转化为byte：

    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00)>> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }




    //byte转换为char：
    public static char byteToChar(byte[] b) {
        char c = (char) (((b[0] & 0xFF)<< 8) | (b[1] &0xFF));       
        return c;
    }

    public static  String bytesToHexString(byte[] data, int start, int end) {
        StringBuilder sb = new StringBuilder("");
        if(data == null) {
            return "";
        } else {
            end = Math.min(end, data.length);

            for(int index = start; index < end; ++index) {
                int v = data[index] & 255;
                String hv = Integer.toHexString(v);
                if(hv.length() < 2) {
                    sb.append(0);
                }

                sb.append(hv.toLowerCase());
            }

            return sb.toString();
        }
    }

    public static String bytesToHexString(byte[] data) {
        return data == null?"":bytesToHexString(data, 0, data.length);
    }
    
    public static void main(String[] args) {
		int i =333;
		String encrypt = Encrypt(i+"",2018);
		String decrypt = Decrypt(encrypt, 2018);
		int parseInt = Integer.parseInt(decrypt);
		System.out.println("加密完后："+encrypt);
		System.out.println("解密完后："+decrypt);
	}
}
