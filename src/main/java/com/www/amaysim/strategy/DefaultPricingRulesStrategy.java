package com.www.amaysim.strategy;

import com.www.amaysim.entity.Cart;
import com.www.amaysim.strategy.chain.Bulk5GbDiscountChain;
import com.www.amaysim.strategy.chain.CalculateRemainingItemChain;
import com.www.amaysim.strategy.chain.EmptyCartChain;
import com.www.amaysim.strategy.chain.PricingChain;
import com.www.amaysim.strategy.chain.ThreeforTwoDealChain;
import com.www.amaysim.strategy.chain.Unli2GbBundleChain;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public class DefaultPricingRulesStrategy implements  PricingRulesStrategy {

    public void process(Cart cart) {

        PricingChain chain = new EmptyCartChain(
                new Unli2GbBundleChain(
                        new Bulk5GbDiscountChain(
                                new ThreeforTwoDealChain(
                                        new CalculateRemainingItemChain(null)))));

        chain.process(cart);
    }

}
