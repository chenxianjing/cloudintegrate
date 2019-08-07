package org.cc.task.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Description:
 * User: yj
 * Date: 2019-01-10
 * Time: 11:16
 */
@Slf4j
public class SymmetricEncoder {
        //加密
   public static String AESEncode(String encodeRules,String content){
       try {
           KeyGenerator keygen=KeyGenerator.getInstance("AES");

           SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
           secureRandom.setSeed(encodeRules.getBytes());
           keygen.init(128, secureRandom);
           SecretKey original_key=keygen.generateKey();
           byte [] raw=original_key.getEncoded();
           SecretKey key=new SecretKeySpec(raw, "AES");
           Cipher cipher=Cipher.getInstance("AES");
           cipher.init(Cipher.ENCRYPT_MODE, key);
           byte [] byte_encode=content.getBytes("utf-8");
           byte [] byte_AES=cipher.doFinal(byte_encode);
           String AES_encode=new String(new BASE64Encoder().encode(byte_AES));
           return AES_encode;
           } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           }
       return null;
   }
	/*
	 * 解密
	 */
   public static String AESDncode(String encodeRules,String content) {
       try {
           KeyGenerator keygen=KeyGenerator.getInstance("AES");
           SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
           secureRandom.setSeed(encodeRules.getBytes());
           keygen.init(128, secureRandom);
           SecretKey original_key=keygen.generateKey();
           byte [] raw=original_key.getEncoded();
           SecretKey key=new SecretKeySpec(raw, "AES");
           Cipher cipher=Cipher.getInstance("AES");
           cipher.init(Cipher.DECRYPT_MODE, key);
           byte [] byte_content= new BASE64Decoder().decodeBuffer(content);
           byte [] byte_decode=cipher.doFinal(byte_content);
           String AES_decode=new String(byte_decode,"utf-8");
           return AES_decode;
           } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return null;
   }

    public static String sm3(String src){
        Assert.notNull(src,"param must not null");
        try {
            byte[] srcData = src.getBytes("utf-8");
            Security.addProvider(new BouncyCastleProvider());
            MessageDigest messageDigest = null;
            messageDigest = MessageDigest.getInstance("SM3", "BC");
            messageDigest.update(srcData, 0, srcData.length);
            return Hex.encodeHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException | NoSuchProviderException | UnsupportedEncodingException e) {
            log.error("签名失败",e);
        }
        return "";
    }

    public static String sm2(String src){
        try {
            byte[] encryptHash = src.getBytes("utf-8");
            Signature signature = Signature.getInstance("SM2", "BC");
            KeyFactory kf = KeyFactory.getInstance("EC", "BC"); // or "EC" or whatever
            signature.initSign(kf.generatePrivate(new PKCS8EncodedKeySpec(CertUtil.priKey.getBytes("utf-8"))));
            signature.update(encryptHash, 0, encryptHash.length);
            return new String(signature.sign());
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException
                |InvalidKeyException |SignatureException | UnsupportedEncodingException e) {
            log.error("签名失败",e);
        }
        return "";
    }

    public static void main(String[] args)throws Throwable{
       System.out.println(sm3("swc%*RBN9@"));

        System.out.println(sm3(sm3("swc%*RBN9@")+ "e60af4de34e8400a9133d8ddf6749919"));
    }
}
