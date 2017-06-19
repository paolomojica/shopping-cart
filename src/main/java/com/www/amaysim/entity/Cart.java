package com.www.amaysim.entity;

import com.www.amaysim.visitor.ShoppingPromo;
import com.www.amaysim.visitor.ShoppingPromoVisitor;

import java.util.List;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public class Cart implements ShoppingPromo {

    private List<CartItem> cartItems;
    private Double total;
    private ShoppingPromoVisitor visitor;

    public void accept(ShoppingPromoVisitor visitor) {
        visitor.visit(this);
    }

    public ShoppingPromoVisitor getVisitor() {
        return visitor;
    }

    public void setVisitor(ShoppingPromoVisitor visitor) {
        this.visitor = visitor;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
