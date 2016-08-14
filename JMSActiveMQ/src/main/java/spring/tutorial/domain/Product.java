package spring.tutorial.domain;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by thangnguyen-imac on 8/14/16.
 */
public class Product implements Serializable{

    private String id;

    private String name;

    private int quantity;

    public Product(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
