package com.testjava.model;

/**
 * Created by erwin on 3/30/18.
 */
public class DeliveryAddress {

    private Integer id;
    private String address;
    private String city;
    private String postCode;
    private Customer customer;
    private Boolean selected;

    public DeliveryAddress() {
    }

    public DeliveryAddress(Integer id) {
        this.id = id;
    }

    public DeliveryAddress(Integer id, String address, String city, String postCode, Customer customer) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryAddress that = (DeliveryAddress) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
