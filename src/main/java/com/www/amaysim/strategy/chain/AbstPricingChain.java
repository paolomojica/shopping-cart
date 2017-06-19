package com.www.amaysim.strategy.chain;

import com.www.amaysim.entity.Cart;
import com.www.amaysim.entity.CartItem;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public abstract class AbstPricingChain implements PricingChain {

    protected PricingChain next;

    protected CartItem getItem(Cart cart, String itemCode) {

        CartItem item = null;

        for(CartItem i : cart.getCartItems()) {
            if(i.getProduct().getProductCode() == itemCode) {
                item = i;
            }
        }

        return item;
    }

}