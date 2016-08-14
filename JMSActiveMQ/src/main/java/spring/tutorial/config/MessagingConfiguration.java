package spring.tutorial.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import spring.tutorial.messaging.MessageReceiver;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

/**
 * Created by thangnguyen-imac on 8/13/16.
 */
@Configuration
public class MessagingConfiguration {

    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";

    private static final String ORDER_QUEUE = "order-queue";

    private static final String ORDER_RES_QUEUE = "order-response-queue";

    @Autowired
    MessageReceiver messageReceiver;

    /**
     * We need to initialising a ConnectionFactory
     * cachingConnectionFactory
     * getContainer
     * initializing jmsTemplate
     * initializing converter
     */

    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("spring.tutorial"));
        return connectionFactory;
    }

    /**
     * Unused
     * @return
     */
    @Bean
    public ConnectionFactory cachingConnectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setTargetConnectionFactory(connectionFactory());
        cachingConnectionFactory.setSessionCacheSize(10);

        return cachingConnectionFactory;
    }

    @Bean
    public MessageListenerContainer getContainer(){
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setDestinationName(ORDER_RES_QUEUE);
        container.setMessageListener(messageReceiver);

        return container;
    }

    /**
     * Use for sending messages
     * @return
     */
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestinationName(ORDER_QUEUE);
        return jmsTemplate;
    }

    @Bean
    MessageConverter converter(){
        return new SimpleMessageConverter();
    }

}
