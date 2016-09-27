package com.tony.aop.genurl;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author songyu.li@yeepay.com
 * @createtime 2016年3月21日 下午6:01:59
 */
public class DesUtil {

	/**
     * 加密方法(有DES、DESede(即3DES)、Blowfish)
     * @param src 源数据的字节数组
     * @return 
     */
    public static String encryptMode(String src, String algorithm, String cryptKey) {
        try {
             SecretKey deskey = new SecretKeySpec(build3DesKey(cryptKey), algorithm);    //生成密钥
             Cipher c1 = Cipher.getInstance(algorithm);    //实例化负责加密/解密的Cipher工具类
             c1.init(Cipher.ENCRYPT_MODE, deskey);    //初始化为加密模式
             return Base64.encodeBase64String(c1.doFinal(src.getBytes()));
         } catch (java.security.NoSuchAlgorithmException e1) {
             e1.printStackTrace();
         } catch (javax.crypto.NoSuchPaddingException e2) {
             e2.printStackTrace();
         } catch (java.lang.Exception e3) {
             e3.printStackTrace();
         }
         return null;
     }
    
    
    /**
     * 解密函数
     * @param src 密文的字节数组
     * @return
     */
    public static String decryptMode(String src, String algorithm, String cryptKey) {      
        try {
            SecretKey deskey = new SecretKeySpec(build3DesKey(cryptKey), algorithm);
            Cipher c1 = Cipher.getInstance(algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);    //初始化为解密模式
            return new String(c1.doFinal(Base64.decodeBase64(src)));
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
     }
    
    
    /*
     * 根据字符串生成密钥字节数组 
     * @param keyStr 密钥字符串
     * @return 
     * @throws UnsupportedEncodingException
     */
    public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException{
        byte[] key = new byte[24];    //声明一个24位的字节数组，默认里面都是0
        byte[] temp = keyStr.getBytes("UTF-8");    //将字符串转成字节数组
        
        /*
         * 执行数组拷贝
         * System.arraycopy(源数组，从源数组哪里开始拷贝，目标数组，拷贝多少位)
         */
        if(key.length > temp.length){
            //如果temp不够24位，则拷贝temp数组整个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, temp.length);
        }else{
            //如果temp大于24位，则拷贝temp数组24个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, key.length);
        }
        return key;
    }
	
}
