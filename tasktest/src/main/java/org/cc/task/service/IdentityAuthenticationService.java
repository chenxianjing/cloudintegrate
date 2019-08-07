package org.cc.task.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class IdentityAuthenticationService {



    /**
     * 生成16位随机数
     *
     * @return
     */
    public static String getAccountIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        return machineId + String.format("%015d", hashCodeV);
    }


    /**
     * 以"||"分割字符串
     *
     * @param data
     * @return
     */
    public static String[] stringToSplit(String data) {
        if (StringUtils.isEmpty(data)) {
            return new String[0];
        }
        return data.split("\\|\\|");
    }

    /**
     * 方法一、正则表达式去掉数据中的空格和回车符
     * @param str 传进来的字符串
     * @return 去掉空格和回车符
     */
    public static String rmString1 (String str){
        // 正则表达式匹配空格和换行符
        Pattern par = Pattern.compile("\\s*|\t|\r|\n");
        Matcher mch = par.matcher(str);
        // 返回数据
        return mch.replaceAll("");
    }

    public String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String re = new String(filecontent, encoding).replace("-----BEGIN CERTIFICATE-----","");
            re = re.replace("-----END CERTIFICATE-----","");
            System.out.print(rmString1(re));
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }
}