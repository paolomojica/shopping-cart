package com.www.amaysim.entity;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public class Product {

    private String productCode;
    private String productName;
    private Double price;

    public Product(String productCode, String productName, Double price) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return !(productCode != null ? !productCode.equals(product.productCode) : product.productCode != null);

    }

    @Override
    public int hashCode() {
        return productCode != null ? productCode.hashCode() : 0;
    }

}
