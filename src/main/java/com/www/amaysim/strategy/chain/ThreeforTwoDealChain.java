package com.www.amaysim.strategy.chain;

import com.www.amaysim.entity.Cart;
import com.www.amaysim.entity.CartItem;
import com.www.amaysim.util.MathUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public class ThreeforTwoDealChain extends AbstPricingChain implements PricingChain {

    public ThreeforTwoDealChain(PricingChain next) {
        super.next = next;
    }

    public void process(Cart cart) {

        CartItem item = getItem(cart, "ult_small");

        if(item != null) {

            Integer by3 = item.getQuantity() / 3;

            if( by3 > 0) {
                Double total = cart.getTotal();
                Integer unprocessed = item.getQuantity() - (by3 * 3);
                total = total + (by3 * (item.getProduct().getPrice() * 2));
                item.setUnprocessed(unprocessed);
                cart.setTotal(MathUtil.round(total, 2));
            }
        }

        if(super.next != null) {
            super.next.process(cart);
        }

    }


}
