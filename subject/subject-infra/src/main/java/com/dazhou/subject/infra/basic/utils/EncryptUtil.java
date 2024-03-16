package com.dazhou.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * yml数据加密
 *
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 14:43
 */
public class EncryptUtil {

    /**
     * 加密
     * @param plainText
     * @throws Exception
     */
    public static void testEncrypt(String plainText) throws Exception {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        // 加密的算法（默认的）
        config.setAlgorithm("PBEWithMD5AndDES");
        // 加密的密钥，自己填写
        config.setPassword("dazhou");
        standardPBEStringEncryptor.setConfig(config);
        //密码（未加密）
        String encryptedText = standardPBEStringEncryptor.encrypt(plainText);
        System.out.println(encryptedText);
    }

    /**
     * 解密
     * @param passWord
     * @throws Exception
     */
    public static void testDe(String passWord) throws Exception {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("dazhou");
        standardPBEStringEncryptor.setConfig(config);
        //加密后的密码
        String plainText = standardPBEStringEncryptor.decrypt(passWord);
        System.out.println(plainText);
    }

    public static void main(String[] args) throws Exception {
//        testEncrypt("root");
        testDe("MciqoonXkskKLYaZYQry7w==");
    }
}
