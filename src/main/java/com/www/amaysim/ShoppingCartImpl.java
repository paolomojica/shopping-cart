package com.www.amaysim;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;
import com.www.amaysim.entity.Cart;
import com.www.amaysim.entity.CartItem;
import com.www.amaysim.factory.VisitorFactory;
import com.www.amaysim.strategy.PricingRulesStrategy;
import com.www.amaysim.visitor.ShoppingPromo;
import com.www.amaysim.visitor.ShoppingPromoVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public class ShoppingCartImpl implements ShoppingCart {

    private Cart cart;
    private PricingRulesStrategy strategy;


    public ShoppingCartImpl(PricingRulesStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(CartItem item) {

        if(cart == null) {
            cart = new Cart();
            cart.setCartItems(new ArrayList<CartItem>());
        }

        cart.getCartItems().add(item);
    }

    public void add(CartItem item, String promoCode) {

        if(cart == null) {
            cart = new Cart();
            cart.setCartItems(new ArrayList<CartItem>());
        }

        ShoppingPromoVisitor visitor = VisitorFactory.getVisitor(promoCode);

        if(visitor == null) {
            throw new IllegalArgumentException("promoCode not found.");
        }

        cart.getCartItems().add(item);
        cart.setVisitor(visitor);
    }

    public Double getTotal() {
        strategy.process(cart);
        if(cart.getVisitor() != null) {
            cart.accept(cart.getVisitor());
        }
        return cart.getTotal();
    }

    public List<CartItem> getItems() {
        return cart.getCartItems();
    }


}
