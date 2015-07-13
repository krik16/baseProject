/**
 * @Copyright (C),上海容易网电子商务有限公司	
 * @Author: 柯军 
 * @datetime:2015年5月29日下午6:17:54
 * @Description: TODO
 *
 **/

package com.kiki.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

import com.kiki.service.MqReceiverService;
import com.rabbitmq.client.Channel;

/**
 * @Author: 柯军
 * @Description: mq消息处理类
 * @datetime:2015年5月29日下午6:17:54
 * 
 **/
@Service
public class MqReceiverServiceImpl implements MqReceiverService {


	@Override
	public void callBack(Message message, Channel channel, String messageString) {}

	
}
