package com.matallica.NotificationService.Rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matallica.NotificationService.Controller.NotificationServiceController;
import com.matallica.NotificationService.Entity.TradingEntity;


/**listens to the rabbitMQ queue and runs the method receiveMessage
 * when a message is sent to the rabbitMQ queue.
 *
 */
@Component
public class Receiver {

	@Autowired
	NotificationServiceController controller;

	@RabbitListener(queues= "${queue.name}", containerFactory="jsaFactory")
	public void receiveMessage(TradingEntity trade) {
		controller.sendMsgWS(trade);
	}
}
