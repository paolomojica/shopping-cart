package com.www.amaysim.strategy;

import com.www.amaysim.entity.Cart;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public interface PricingRulesStrategy {

    void process(Cart cart);

}
