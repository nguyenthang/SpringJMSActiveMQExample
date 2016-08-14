package spring.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.tutorial.domain.Product;
import spring.tutorial.messaging.MessageSender;

/**
 * Created by thangnguyen-imac on 8/14/16.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private MessageSender messageSender;

    public void sendProduct(Product product) {
        messageSender.sendMessage(product);
    }
}
