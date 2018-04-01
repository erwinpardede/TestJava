package com.testjava.model;

/**
 * Created by erwin on 3/30/18.
 */
public class PaymentMethod {

    private Integer id;
    private String name;

    public PaymentMethod() {
    }

    public PaymentMethod(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentMethod that = (PaymentMethod) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
