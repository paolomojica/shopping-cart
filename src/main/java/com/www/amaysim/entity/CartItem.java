package com.www.amaysim.entity;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public class CartItem {

    private Product product;
    private Integer quantity;
    private Integer unprocessed;

    public CartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        this.unprocessed = quantity;
    }

    public Integer getUnprocessed() {
        return unprocessed;
    }

    public void setUnprocessed(Integer unprocessed) {
        this.unprocessed = unprocessed;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getQuantity() + " x " + getProduct().getProductName();
    }

}
