package spring.tutorial;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import spring.tutorial.config.AppConfig;
import spring.tutorial.domain.Product;
import spring.tutorial.service.ProductService;
import spring.tutorial.util.BasicUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static AtomicInteger id = new AtomicInteger();


    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = (ProductService) context.getBean("productService");

        Product product = getProduct();

        productService.sendProduct(product);

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static Product getProduct() {

        Product p = new Product();
        p.setName("Product" + id.incrementAndGet());
        p.setId(BasicUtil.getUniqueID());
        p.setQuantity(2);

        return p;
    }
}
