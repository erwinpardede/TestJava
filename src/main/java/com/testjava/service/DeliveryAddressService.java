package com.testjava.service;

import com.testjava.base.BaseService;
import com.testjava.model.Customer;
import com.testjava.model.DeliveryAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erwin on 3/30/18.
 */
public class DeliveryAddressService extends BaseService<DeliveryAddress> implements IDeliveryAddressService {

    @Override
    public List<DeliveryAddress> getByCustomer(Customer customer) {

        List<DeliveryAddress> result = new ArrayList<DeliveryAddress>();
        for (DeliveryAddress deliveryAddress : this.objects) {
            if (deliveryAddress.getCustomer().equals(customer)) {
                result.add(deliveryAddress);
            }
        }
        return result;
    }

    @Override
    public Integer updateDeliveryAddress(DeliveryAddress deliveryAddress) {

        boolean updated = false;
        List<DeliveryAddress> addresses = this.getByCustomer(deliveryAddress.getCustomer());
        for (DeliveryAddress deliveryAddress1 : addresses) {
            if (deliveryAddress1.equals(deliveryAddress)) {
                deliveryAddress1.setSelected(true);
                updated = true;
            } else {
                deliveryAddress1.setSelected(false);
            }
            this.update(deliveryAddress1);
        }
        if (updated)
            return 1;
        else
            return 0;
    }
}
