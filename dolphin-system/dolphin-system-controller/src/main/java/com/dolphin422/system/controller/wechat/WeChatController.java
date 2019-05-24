package com.dolphin422.system.controller.wechat;

import com.dolphin422.common.exception.BusinessException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.05.07 15:30
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {
    private final static String TOKEN = "weChat";//token值

    @RequestMapping(value = "/conn", method = RequestMethod.GET)
    public void sendStringMessage(HttpServletRequest request, HttpServletResponse response)
        throws BusinessException, IOException {
        System.out.println("开始签名校验");
        String signature = request.getParameter("signature");//微信的加密签名
        String timestamp = request.getParameter("timestamp");//时间戳
        String nonce = request.getParameter("nonce");//随机数
        String echostr = request.getParameter("echostr");//随机字符串

        ArrayList<String> array = new ArrayList<String>();
        array.add(signature);
        array.add(timestamp);
        array.add(nonce);

        //排序
        String sortString = sort(TOKEN, timestamp, nonce);
        //加密
        String mytoken = SHA1(sortString);
        //校验签名
        if (mytoken != null && mytoken != "" && mytoken.equals(signature)) {
            System.out.println("签名校验通过。");
            response.getWriter().println(echostr); //如果检验成功输出echostr，微信服务器接收到此输出，才会确认检验完成。
            // return echostr;
        } else {
            System.out.println("签名校验失败。");
        }
        // return null;
    }

    /**
     * 排序方法
     *
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    public static String sort(String token, String timestamp, String nonce) {
        String[] strArray = { token, timestamp, nonce };
        Arrays.sort(strArray);

        StringBuilder sbuilder = new StringBuilder();
        for (String str : strArray) {
            sbuilder.append(str);
        }

        return sbuilder.toString();
    }

    /**
     * 加密方式SHA1
     *
     * @param decript
     * @return
     */
    public static String SHA1(String decript) {
        try {
            //ava.security.MessageDigest类用于为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法
            MessageDigest digest = MessageDigest
                .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();//完成哈希算法
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
