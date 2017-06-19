package com.www.amaysim;

import com.www.amaysim.entity.Cart;
import com.www.amaysim.entity.CartItem;
import com.www.amaysim.factory.VisitorFactory;
import com.www.amaysim.strategy.PricingRulesStrategy;
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
        cart = new Cart();
        cart.setCartItems(new ArrayList<CartItem>());
    }

    public void add(CartItem item) {
        cart.getCartItems().add(item);
    }

    public void add(CartItem item, String promoCode) {
        ShoppingPromoVisitor visitor = VisitorFactory.getVisitor(promoCode);

        if(visitor == null) {
            throw new IllegalArgumentException("promoCode not found.");
        }

        cart.getCartItems().add(item);
        cart.setVisitor(visitor);
    }

    public Double getTotal() {
        processCart();
        return cart.getTotal();
    }

    public List<CartItem> getItems() {
        processCart();
        return cart.getCartItems();
    }

    private void processCart() {
        strategy.process(cart);
        if(cart.getVisitor() != null) {
            cart.accept(cart.getVisitor());
        }
    }

}
