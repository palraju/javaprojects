package com.cognizant.amqp;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ReturnListener;

public class AMQPLogPublisher {

    private static final String EXCHANGE_NAME = "logsRouter";

    public static void main(String[] argv)
                  throws java.io.IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String message = "Hello Sir. I am sending you red Signal";

        channel.basicPublish(EXCHANGE_NAME, "red",true, false, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        
        channel.addReturnListener(new ReturnListener() {
            public void handleReturn(int replyCode,String replyText,String exchange,String routingKey,
                                          AMQP.BasicProperties properties, byte[] body) throws IOException {               
            	System.out.println("replyText:" + replyText);
            	System.out.println("exchange:" + exchange);
            	System.out.println("routingKey:" + routingKey);
            	System.out.println("body:" + new String(body));
            	
            }
        });

        channel.close();
        connection.close();
    }    
}