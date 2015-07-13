package com.kiki.core.common;

import com.jianzhou.sdk.BusinessService;
import com.kiki.core.common.util.PropertiesUtil;
import com.kiki.core.constant.Constants;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 类MessageManger.java的实现描述：TODO 类实现描述
 * 
 * @author jiejie 2014年6月10日 下午2:09:18
 */
public class MessageManger {

	protected Logger logger = LoggerFactory.getLogger(MessageManger.class);
    private static MessageManger instance = new MessageManger();
    private static final String  SMS_URL  = "http://service6.baiwutong.com:8080/sms_send2.do";

	private PropertyConfigurer propertyConfigurer;
	
    private MessageManger() {
    } 

    public static MessageManger getInstance() {
        return instance;
    }

    /**
     * 发送短信
     * 百悟短信通道
     * @param phone :手机号
     * @param message :短信内容
     */
    public String sendBaiwutongSmsMessage(String phone, String message) {
        NameValuePair[] params = new NameValuePair[] { new NameValuePair("corp_id", "6e1r001"),
                new NameValuePair("corp_pwd", "6e1r001"), new NameValuePair("corp_service", "106550939yd"),//106550939yd 这个换成 10690269yd
                new NameValuePair("mobile", phone), new NameValuePair("msg_content", message),
                new NameValuePair("corp_msg_id", ""), new NameValuePair("ext", "86") };
        HttpClient httpclient = new HttpClient();
        httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
        httpclient.getHttpConnectionManager().getParams().setSoTimeout(30000);
        GetMethod getMethod = new GetMethod(SMS_URL);
        getMethod.setQueryString(params);
        try {
            httpclient.executeMethod(getMethod);
            return getMethod.getResponseBodyAsString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            getMethod.releaseConnection();
        }
    }
    
    /**
     * 发送短信
     * 云短信通道
     * @param phone :手机号
     * @param message :短信内容
     */
    public String sendYunSmsMessage(String phone, String message) {
    	String yunsms = "http://http.yunsms.cn/tx/";
        NameValuePair[] params = new NameValuePair[] { new NameValuePair("uid", "53787"),
                new NameValuePair("pwd", "45bc8c89e1312f2accdf339d7cc52cf8"), new NameValuePair("corp_service", "106550939yd"),
                new NameValuePair("mobile", phone), new NameValuePair("content", message),
                new NameValuePair("encode", "utf8")};
        HttpClient httpclient = new HttpClient();
        httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
        httpclient.getHttpConnectionManager().getParams().setSoTimeout(30000);
        GetMethod getMethod = new GetMethod(yunsms);
        getMethod.setQueryString(params);
        try {
            httpclient.executeMethod(getMethod);
            return getMethod.getResponseBodyAsString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            getMethod.releaseConnection();
        }
    }

    /**
     * 发送短信
     * 建周短信通道
     * @param phone :手机号
     * @param message :短信内容
     */
    public static String sendJianZhouSmsMessage(String phone, String message) {
        BusinessService bs = new BusinessService();
        bs.setWebService("http://www.jianzhou.sh.cn/JianzhouSMSWSServer/services/BusinessService");
        int temp=bs.sendBatchMessage("sdk_rongyi", "54100171", phone, message);
        return temp+"";
    }
    /**
     * 发送短信
     * @param phone
     * @param message
     * @return
     */
    public String sendSmsMessage(String phone, String message) {
    	logger.info("--------------------------------->");
    	logger.info("-----进入短信通道----->");
    	logger.info("-----phone----->"+ phone);
    	String messageChannel = "1";//短信通道,1:云短信通道 ，2：百悟短信通道，3:建周短信通道
    	String result = null;
    	String classesPath = MessageManger.class.getClassLoader().getResource("").getFile();
		classesPath += "config.properties";
		logger.info("classesPath--->"+ classesPath);
//		logger.info(classesPath);
		Properties pro = PropertiesUtil.getProperties(classesPath);
		messageChannel = pro.getProperty(Constants.Common.MESSAGE_CHANNEL);
		logger.info("messageChannel--->"+ messageChannel);
//    	if(propertyConfigurer!=null && propertyConfigurer.getProperty(Constants.Common.MESSAGE_CHANNEL) != null) {    		
//    		messageChannel = propertyConfigurer.getProperty(Constants.Common.MESSAGE_CHANNEL).toString();
//    	}
		
    	if("1".equals(messageChannel)) {
    		result = sendYunSmsMessage(phone, message);
    	}else if("2".equals(messageChannel)) {
    		result = sendBaiwutongSmsMessage(phone, message);
    	}else if("3".equals(messageChannel)) {
    	    //建周需要自己添加签名
    	    message =  message + "【容易网】";
    	    logger.info("message--->"+ message);
            result = sendJianZhouSmsMessage(phone, message);
            logger.info("result--->"+ result);
        }
    	return result;
    }

	public PropertyConfigurer getPropertyConfigurer() {
		return propertyConfigurer;
	}

	public void setPropertyConfigurer(PropertyConfigurer propertyConfigurer) {
		this.propertyConfigurer = propertyConfigurer;
	}
}
