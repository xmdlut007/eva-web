package com.cn.xm.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月23日 下午7:48:07
 */
public class SendCloudMailUtil {
    private static Logger logger = LoggerFactory.getLogger(SendCloudMailUtil.class);
    private final static String GLOBAL_CONFIG_PATH = "global_config.properties";

    private static String MAIL_URL = "";
    private static String API_USER = "";
    private static String API_KEY = "";
    private static String MAIL_FROM = "";
    private static String MAIL_FROM_NAME="";
    private static String MAIL_SUBJECT="";
    private static String MAIL_TEMPLATE="";
    static {
        Properties properties = System.getProperties();
        Resource res = new ClassPathResource(GLOBAL_CONFIG_PATH);

        try {
            properties.load(res.getInputStream());
            System.setProperties(properties);
            MAIL_URL = (String) System.getProperties().get("mail_webapi_url");
            API_USER = (String) System.getProperties().get("api_user");
            API_KEY = (String) System.getProperties().get("api_key");
            MAIL_FROM = (String) System.getProperties().get("mail_from");
            MAIL_FROM_NAME = (String) System.getProperties().get("mail_from_name");
            MAIL_SUBJECT = (String) System.getProperties().get("mail_subject");
            MAIL_TEMPLATE = (String) System.getProperties().get("mail_template");
            logger.info("SendCloudMailUtil-INFO {}{}", MAIL_URL, API_USER);
        } catch (IOException e) {
            logger.error("SendCloudMailUtil{}", e);
        }
    }
    public static void sendMailTemplate(String toMailAddress, String username, String code) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpost = new HttpPost(MAIL_URL);
            List params = new ArrayList();
            // 不同于登录SendCloud站点的帐号，您需要登录后台创建发信子帐号，使用子帐号和密码才可以进行邮件的发送。
            params.add(new BasicNameValuePair("api_user", API_USER));
            params.add(new BasicNameValuePair("api_key", API_KEY));
            params.add(new BasicNameValuePair("from", MAIL_FROM));
            params.add(new BasicNameValuePair("fromname", MAIL_FROM_NAME));
            params.add(new BasicNameValuePair("subject", MAIL_SUBJECT));
            params.add(new BasicNameValuePair("resp_email_id", "true"));
            params.add(new BasicNameValuePair("template_invoke_name", MAIL_TEMPLATE));

            // 传入模板内置参数值
            JSONObject substitution_vars = new JSONObject();
            List<String> toList = new ArrayList<String>();
            toList.add(toMailAddress);
            substitution_vars.put("to", toList);
            JSONObject subList = new JSONObject();
            subList.put("%name%", Lists.newArrayList(username));
            subList.put("%code%", Lists.newArrayList(code));
            substitution_vars.put("sub", subList);
            params.add(new BasicNameValuePair("substitution_vars", JSON.toJSONString(substitution_vars)));

            httpost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            // 请求
            HttpResponse response = httpclient.execute(httpost);
            // 处理响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 正常返回
                // 读取xml文档
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);

            } else {
                System.err.println("error");
            }
            httpost.releaseConnection();
        } catch (Exception e) {

        }

    }
    public static void main(String[] args) throws IOException {
        sendMailTemplate("qiuwenming1988@163.com", "xmdlut", "2048");
    }
}
