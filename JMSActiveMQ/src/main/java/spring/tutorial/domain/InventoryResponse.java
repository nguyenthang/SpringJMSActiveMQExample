package spring.tutorial.domain;

import java.io.Serializable;

/**
 * Created by thangnguyen-imac on 8/14/16.
 */
public class InventoryResponse implements Serializable {

    private String productId;

    private int returnCode;

    private String comment;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
