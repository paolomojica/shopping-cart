package com.www.amaysim.strategy.chain;

import com.www.amaysim.entity.Cart;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public interface PricingChain {

    void process(Cart cart);

}
