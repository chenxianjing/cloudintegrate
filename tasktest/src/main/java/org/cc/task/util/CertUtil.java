package org.cc.task.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CertUtil {
    //状态系统证书
    public static final String systemCert;
    //状态系统私钥
    public static final String priKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgEnGxn8+YNFkG85Jte6yZH230kTsOodErv7JJsCaQejWgCgYIKoEcz1UBgi2hRANCAASTARBnq/Oz5Wz38uRoCXDA+dXcj3EKy038OhnKocZytYO01FxROi4qVQ2WhOmy9TtYwsKYgwnqDEedV9Z+zRI/";
    /**
     * 系统证书初始化
     */
    static{
        ByteArrayOutputStream baos = null;
        try {
            FileInputStream fis = new FileInputStream(new File("certFiles/59.202.51.217-status.crt"));
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            log.error("读取出错", e);
        }
        if(Objects.isNull(baos)){
            systemCert =  "MIIEGDCCA7ygAwIBAgIIPfUAxwAFB10wDAYIKoEcz1UBg3UFADBpMQswCQYDVQQG\n" +
                    "EwJDTjE8MDoGA1UECgwzTmF0aW9uYWwgRS1Hb3Zlcm5tZW50IE5ldHdvcmsgQWRt\n" +
                    "aW5pc3RyYXRpb24gQ2VudGVyMRwwGgYDVQQDDBNDRUdOIFNNMiBDbGFzcyAyIENB\n" +
                    "MB4XDTE5MDcxNjE2MDAwMFoXDTIxMDcxNjE1NTk1OVowgYQxCzAJBgNVBAYTAkNO\n" +
                    "MRIwEAYDVQQIDAnmtZnmsZ/nnIExEjAQBgNVBAcMCeadreW3nuW4gjEWMBQGA1UE\n" +
                    "CgwNNTkuMjAyLjUxLjIxNzEdMBsGA1UECwwUc2VhbF9zdGF0dXNfcGxhdGZvcm0x\n" +
                    "FjAUBgNVBAMMDTU5LjIwMi41MS4yMTcwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNC\n" +
                    "AASTARBnq/Oz5Wz38uRoCXDA+dXcj3EKy038OhnKocZytYO01FxROi4qVQ2WhOmy\n" +
                    "9TtYwsKYgwnqDEedV9Z+zRI/o4ICLjCCAiowDAYDVR0TBAUwAwEBADATBgNVHSUE\n" +
                    "DDAKBggrBgEFBQcDATAOBgNVHQ8BAf8EBAMCAMAwEQYJYIZIAYb4QgEBBAQDAgBA\n" +
                    "MBgGA1UdEQQRMA+CDTU5LjIwMi41MS4yMTcwHwYDVR0jBBgwFoAUucCMM4GesPqh\n" +
                    "eyNyP0OU7qnWfn0wgcUGA1UdHwSBvTCBujCBt6CBtKCBsYaBrmxkYXA6Ly9sZGFw\n" +
                    "LnN0YXRlY2EuY2Vnbi5jbjozODkvQ049Q0VHTiBTTTIgQ2xhc3MgMiBDQSxDTj1D\n" +
                    "RUdOIFNNMiBDbGFzcyAyIENBLCBPVT1DUkxEaXN0cmlidXRlUG9pbnRzLCBvPXNp\n" +
                    "Y2NhP2NlcnRpZmljYXRlUmV2b2NhdGlvbkxpc3Q/YmFzZT9vYmplY3RjbGFzcz1j\n" +
                    "UkxEaXN0cmlidXRpb25Qb2ludDCBvwYIKwYBBQUHAQEEgbIwga8wgawGCCsGAQUF\n" +
                    "BzAChoGfbGRhcDovL2xkYXAuc3RhdGVjYS5jZWduLmNuOjM4OS9DTj1DRUdOIFNN\n" +
                    "MiBDbGFzcyAyIENBLENOPUNFR04gU00yIENsYXNzIDIgQ0EsIE9VPWNBQ2VydGlm\n" +
                    "aWNhdGVzLCBvPXNpY2NhP2NBQ2VydGlmaWNhdGU/YmFzZT9vYmplY3RDbGFzcz1j\n" +
                    "ZXJ0aWZpY2F0aW9uQXV0aG9yaXR5MB0GA1UdDgQWBBRxqrnSTHyPrdofdnfgaOSw\n" +
                    "eir+oDAMBggqgRzPVQGDdQUAA0gAMEUCIQC2lkninaJ9Xd8rTlfsWZsX8KdFjC6F\n" +
                    "oMHuXq2dd1wEPgIgF1Vtm84LkLerM78d0rpynQRqDd6yElFvjaUQrfPkj78=";
        }else{
            systemCert =  new String(baos.toByteArray(), StandardCharsets.UTF_8).replace("-----BEGIN CERTIFICATE-----","").replace("-----END CERTIFICATE-----","");
        }
    }
    public static String getCert(String path) {
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            return new String(baos.toByteArray());
        } catch (IOException e) {
            log.error("读取出错", e);
        }
        return "";
    }
}
