/**
 * @Copyright (C),上海容易网电子商务有限公司 
 * @Author: 柯军 
 * @datetime:2015年6月1日下午6:17:04
 *
 **/

package com.kiki.mq;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.kiki.mq.MessageEvent;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;

/**
 * @Author: 柯军
 * @Description: mq sender
 * @datetime:2015年6月1日下午6:17:04
 * 
 **/
@Component
public class Sender {

    private static final Logger LOGGER = Logger.getLogger(Sender.class);
    
    @Resource
    private  RabbitTemplate template;

    private Map<String, Notification> syscNotifyMap = new HashMap<String, Notification>();

    /**
     * @Description: 消息发送
     * @param messageMap
     * @param routingKey
     * @Author: 柯军
     * @datetime:2015年6月2日上午10:01:53
     **/
    public  void convertAndSend(Map<String, Object> messageMap, String routingKey) {
        toConvertAndSend(messageMap, routingKey);
    }

    /**
     * @Description: 消息发送
     * @param event 封装对象
     * @param routingKey
     * @Author: 柯军
     * @datetime:2015年6月2日上午10:01:58
     **/
    public  void convertAndSend(MessageEvent event) {
        toConvertAndSend(event, event.getTarget());
    }

    private  void toConvertAndSend(Object messageBody, String routingKey) {
        String message = JSONObject.fromObject(messageBody).toString();
        LOGGER.info("发送消息到" + routingKey + ",消息内容：" + message);
        template.convertAndSend(routingKey, (Object) message.getBytes());
    }

    /**
     * @Description: 消息发送并获得返回信息
     * @param event 封装对象
     * @Author: 柯军
     * @datetime:2015年6月2日下午3:54:23
     **/
    public  String convertSendAndReceive(MessageEvent event) {
        return toConvertSendAndReceive(event.getTarget(), event);
    }

    /**
     * @Description: 消息发送并获得返回信息
     * @param routingKey
     * @param messageMap
     * @return
     * @Author: 柯军
     * @datetime:2015年6月2日下午3:59:38
     **/
    public  String convertSendAndReceive(String routingKey, Map<String, Object> messageMap) {
        return toConvertSendAndReceive(routingKey, messageMap);
    }

    private  String toConvertSendAndReceive(String routingKey, Object messageBody) {
        String message = JSONObject.fromObject(messageBody).toString();
        LOGGER.info("rpc发送消息到" + routingKey + ",消息内容：" + message);
        byte[] bytes = (byte[]) template.convertSendAndReceive(routingKey, message.getBytes());
        if (bytes == null)
            return null;
        String result = new String(bytes);
        LOGGER.info("rpc收到" + routingKey + "回复消息,消息内容：" + result);
        return result;
    }

    /**
     * @Description: rpc调用，同步返回信息
     * @param message
     * @param map
     * @Author: 柯军
     * @datetime:2015年6月1日下午6:11:37
     **/
    public void rpcSend(Map<String, Object> messageMap, Message message, Channel channel) {
        try {
            String messageStr = JSONObject.fromObject(messageMap).toString();
            BasicProperties basicProperties = Receiver.getBasicProperties(message);
            channel.basicPublish("", basicProperties.getReplyTo(), basicProperties, messageStr.getBytes());
            LOGGER.info("rpc回复" + basicProperties.getReplyTo() + "消息,消息内容：" + messageStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOrderNotification(String orderNum, Notification notifier) {
        syscNotifyMap.put(orderNum, notifier);
    }

    public void removeNotification(String orderNum) {
        syscNotifyMap.remove(orderNum);
    }

    public static class Notification {
        private boolean notified = false;

        public boolean isNotified() {
            return notified;
        }

        public void setNotified(boolean notified) {
            this.notified = notified;
        }

        public synchronized void await(int time) {
            try {
                wait(time);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }

        public synchronized void anotify() {
            notify();
        }
    }
}

