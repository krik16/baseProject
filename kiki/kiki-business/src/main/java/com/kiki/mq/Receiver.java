package com.kiki.mq;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.support.DefaultMessagePropertiesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kiki.service.MqReceiverService;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;

/**	
 * @Author:  柯军
 * @Description: mq 消息接收器 
 * @datetime:2015年6月25日下午4:37:28
 *
 **/
@Component
public class Receiver implements ChannelAwareMessageListener {

	@Autowired
	MqReceiverService mqReceiverService;

    private static final Logger LOGGER = Logger.getLogger(Receiver.class);


    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        String messageString = new String(message.getBody());
        LOGGER.info("接收消息：" + messageString);
        try {
            mqReceiverService.callBack(message, channel, messageString);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            LOGGER.error("消息处理失败，失败原因：");
            e.printStackTrace();
        }
    }

    /**
     * @Description: 将 Message messageProperties 转换为 channel 使用的BasicProperties
     * @param message
     * @return
     * @Author: 柯军
     * @datetime:2015年6月2日下午5:51:57
     **/
    public static BasicProperties getBasicProperties(Message message) {
        MessageProperties messageProperties = message.getMessageProperties();
        DefaultMessagePropertiesConverter defaultMessagePropertiesConverter = new DefaultMessagePropertiesConverter();
        return defaultMessagePropertiesConverter.fromMessageProperties(messageProperties, "UTF-8");
    }
}
