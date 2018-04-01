package com.testjava.model;

/**
 * Created by erwin on 3/30/18.
 */
public class Shipping {

    private Integer id;
    private LogisticProvider logisticProvider;
    private String shippingNumber;

    public Shipping() {
    }

    public Shipping(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LogisticProvider getLogisticProvider() {
        return logisticProvider;
    }

    public void setLogisticProvider(LogisticProvider logisticProvider) {
        this.logisticProvider = logisticProvider;
    }

    public String getShippingNumber() {
        return shippingNumber;
    }

    public void setShippingNumber(String shippingNumber) {
        this.shippingNumber = shippingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shipping shipping = (Shipping) o;

        return id.equals(shipping.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
