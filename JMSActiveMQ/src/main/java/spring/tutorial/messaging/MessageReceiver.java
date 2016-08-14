package spring.tutorial.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import spring.tutorial.domain.InventoryResponse;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by thangnguyen-imac on 8/13/16.
 */
@Component
public class MessageReceiver implements MessageListener {

    @Autowired
    private MessageConverter messageConverter;

    public void onMessage(Message message) {
        try {
            InventoryResponse response = (InventoryResponse)messageConverter.fromMessage(message);

        }catch (JMSException e){
            e.fillInStackTrace();
        }
    }
}
