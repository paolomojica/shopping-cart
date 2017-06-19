package com.www.amaysim.strategy.chain;

import com.www.amaysim.entity.Cart;
import com.www.amaysim.entity.CartItem;
import com.www.amaysim.factory.ProductFactory;
import com.www.amaysim.util.MathUtil;

/**
 * Created by wsl-paolo on 19/06/2017.
 */
public class Unli2GbBundleChain extends AbstPricingChain implements PricingChain {

    public Unli2GbBundleChain(PricingChain next) {
        super.next = next;
    }

    public void process(Cart cart) {

        CartItem item = getItem(cart, "ult_medium");

        if(item != null) {

            CartItem i = new CartItem(ProductFactory.getProduct("1 GB Data-pack"), item.getQuantity());
            i.setUnprocessed(0);

            cart.getCartItems().add(i);
        }

        if(super.next != null) {
            super.next.process(cart);
        }
    }

}
