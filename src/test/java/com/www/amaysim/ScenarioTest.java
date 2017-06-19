package com.www.amaysim;

import com.www.amaysim.entity.CartItem;
import com.www.amaysim.factory.ProductFactory;
import com.www.amaysim.strategy.DefaultPricingRulesStrategy;
import com.www.amaysim.strategy.PricingRulesStrategy;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wsl-paolo on 19/06/2017.
 */
public class ScenarioTest {

    @Test
    public void testScenario1() {

        // given
        CartItem unli1gb = new CartItem(
                ProductFactory.getProduct("Unlimited 1GB"),
                3);

        CartItem unli5gb = new CartItem(
                ProductFactory.getProduct("Unlimited 5GB"),
                1);

        // when
        PricingRulesStrategy strategy = new DefaultPricingRulesStrategy();
        ShoppingCart shoppingCart = new ShoppingCartImpl(strategy);
        shoppingCart.add(unli1gb);
        shoppingCart.add(unli5gb);

        // then
        assertThat("Price is $94.70", shoppingCart.getTotal(), is(94.70));
        assertThat("Shopping cart has 3 x Unlimited 1GB, 1 x Unlimited 5GB", shoppingCart.getItems().toString(), is("[3 x Unlimited 1GB, 1 x Unlimited 5GB]"));

        System.out.println(shoppingCart.getItems());
        System.out.println(shoppingCart.getTotal());
    }

    @Test
    public void testScenario2() {

        // given
        CartItem unli1gb = new CartItem(
                ProductFactory.getProduct("Unlimited 1GB"),
                2);

        CartItem unli5gb = new CartItem(
                ProductFactory.getProduct("Unlimited 5GB"),
                4);

        // when
        PricingRulesStrategy strategy = new DefaultPricingRulesStrategy();
        ShoppingCart shoppingCart = new ShoppingCartImpl(strategy);
        shoppingCart.add(unli1gb);
        shoppingCart.add(unli5gb);

        // then
        assertThat("Price is $209.40", shoppingCart.getTotal(), is(209.40));
        assertThat("Shopping cart has 2 x Unlimited 1GB, 4 x Unlimited 5GB", shoppingCart.getItems().toString(), is("[2 x Unlimited 1GB, 4 x Unlimited 5GB]"));

        System.out.println(shoppingCart.getItems());
        System.out.println(shoppingCart.getTotal());
    }

    @Test
    public void testScenario3() {

        // given
        CartItem unli1gb = new CartItem(
                ProductFactory.getProduct("Unlimited 1GB"),
                1);

        CartItem unli2gb = new CartItem(
                ProductFactory.getProduct("Unlimited 2GB"),
                2);

        // when
        PricingRulesStrategy strategy = new DefaultPricingRulesStrategy();
        ShoppingCart shoppingCart = new ShoppingCartImpl(strategy);
        shoppingCart.add(unli1gb);
        shoppingCart.add(unli2gb);

        // then
        assertThat("Price is $84.70", shoppingCart.getTotal(), is(84.70));
        assertThat("Shopping cart has 1 x Unlimited 1GB, 2 x Unlimited 2GB, 2 x 1 GB Data-pack", shoppingCart.getItems().toString(), is("[1 x Unlimited 1GB, 2 x Unlimited 2GB, 2 x 1 GB Data-pack]"));

        System.out.println(shoppingCart.getItems());
        System.out.println(shoppingCart.getTotal());
    }

    @Test
    public void testScenario4() {

        // given
        CartItem unli1gb = new CartItem(
                ProductFactory.getProduct("Unlimited 1GB"),
                1);

        CartItem dataPack1gb = new CartItem(
                ProductFactory.getProduct("1 GB Data-pack"),
                1);

        // when
        PricingRulesStrategy strategy = new DefaultPricingRulesStrategy();
        ShoppingCart shoppingCart = new ShoppingCartImpl(strategy);
        shoppingCart.add(unli1gb);
        shoppingCart.add(dataPack1gb, "I<3AMAYSIM");

        // then
        assertThat("Price is $31.32", shoppingCart.getTotal(), is(31.32));
        assertThat("Shopping cart has 1 x Unlimited 1GB, 1 x 1 GB Data-pack", shoppingCart.getItems().toString(), is("[1 x Unlimited 1GB, 1 x 1 GB Data-pack]"));

        System.out.println(shoppingCart.getItems());
        System.out.println(shoppingCart.getTotal());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testInvalidPromoCode() {

        // given
        CartItem unli1gb = new CartItem(
                ProductFactory.getProduct("Unlimited 1GB"),
                1);

        CartItem dataPack1gb = new CartItem(
                ProductFactory.getProduct("1 GB Data-pack"),
                1);

        // when
        PricingRulesStrategy strategy = new DefaultPricingRulesStrategy();
        ShoppingCart shoppingCart = new ShoppingCartImpl(strategy);
        shoppingCart.add(unli1gb);
        shoppingCart.add(dataPack1gb, "DUMMY");

        // then
        // IllegalArgumentException thrown.
    }

    @Test
    public void testEmptyShoppingCart() {

        // given
        // no cart item.

        // when
        PricingRulesStrategy strategy = new DefaultPricingRulesStrategy();
        ShoppingCart shoppingCart = new ShoppingCartImpl(strategy);
        // no cart item added on shopping cart.

        // then
        assertThat("Price is $0", shoppingCart.getTotal(), is(0.0));

        System.out.println(shoppingCart.getItems());
        System.out.println(shoppingCart.getTotal());
    }


}
