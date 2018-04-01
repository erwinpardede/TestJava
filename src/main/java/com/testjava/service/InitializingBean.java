package com.testjava.service;

import com.testjava.model.*;

/**
 * Created by erwin on 3/31/18.
 */
public class InitializingBean implements org.springframework.beans.factory.InitializingBean {

    private ICustomerService customerService;
    private IAdminService adminService;
    private ICategoryService categoryService;
    private IProductService productService;
    private ICartService cartService;
    private IPaymentMethodService paymentMethodService;
    private IDeliveryAddressService deliveryAddressService;

    public void setDeliveryAddressService(IDeliveryAddressService deliveryAddressService) {
        this.deliveryAddressService = deliveryAddressService;
    }

    public void setPaymentMethodService(IPaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Customer");
        this.customerService.save(customer);

        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("Admin");
        this.adminService.save(admin);

        Category category = new Category();
        category.setId(1);
        category.setName("Peralatan Dapur");
        category.setDescription("Alat-alat masak, kompor, gas, dan sebagainya");
        this.categoryService.save(category);

        category = new Category();
        category.setId(2);
        category.setName("Sembako");
        category.setDescription("Berbagai jenis sembako");
        this.categoryService.save(category);

        category = new Category();
        category.setId(3);
        category.setName("Peralatan Mandi");
        category.setDescription("Sabun, shampoo, dan sebagainya");
        this.categoryService.save(category);

        Product product = new Product();
        product.setId(1);
        product.setName("Panci");
        product.setDescription("Panci");
        product.setStock(10);
        product.setCategory(this.categoryService.get(new Category(1)));
        this.productService.save(product);

        product = new Product();
        product.setId(2);
        product.setName("Wajan");
        product.setDescription("Wajan");
        product.setStock(10);
        product.setCategory(this.categoryService.get(new Category(1)));
        this.productService.save(product);

        product = new Product();
        product.setId(3);
        product.setName("Kompor Gas");
        product.setDescription("Kompor Gas");
        product.setStock(15);
        product.setCategory(this.categoryService.get(new Category(1)));
        this.productService.save(product);

        product = new Product();
        product.setId(4);
        product.setName("Gula Pasir");
        product.setDescription("Gula Pasir");
        product.setStock(40);
        product.setCategory(this.categoryService.get(new Category(2)));
        this.productService.save(product);

        product = new Product();
        product.setId(5);
        product.setName("Telur Ayam");
        product.setDescription("Telur Ayam");
        product.setStock(45);
        product.setCategory(this.categoryService.get(new Category(2)));
        this.productService.save(product);

        product = new Product();
        product.setId(6);
        product.setName("Garam");
        product.setDescription("Garam");
        product.setStock(45);
        product.setCategory(this.categoryService.get(new Category(2)));
        this.productService.save(product);

        product = new Product();
        product.setId(7);
        product.setName("Minyak Goreng");
        product.setDescription("Minyak Goreng");
        product.setStock(40);
        product.setCategory(this.categoryService.get(new Category(2)));
        this.productService.save(product);

        product = new Product();
        product.setId(8);
        product.setName("Sabun Mandi");
        product.setDescription("Sabun Mandi");
        product.setStock(25);
        product.setCategory(this.categoryService.get(new Category(3)));
        this.productService.save(product);

        product = new Product();
        product.setId(9);
        product.setName("Shampoo");
        product.setDescription("Shampoo");
        product.setStock(30);
        product.setCategory(this.categoryService.get(new Category(3)));
        this.productService.save(product);

        product = new Product();
        product.setId(10);
        product.setName("Sikat Gigi");
        product.setDescription("Sikat Gigi");
        product.setStock(30);
        product.setCategory(this.categoryService.get(new Category(3)));
        this.productService.save(product);

        Cart cart = new Cart();
        cart.setId(1);
        cart.setCustomer(this.customerService.get(new Customer(1)));
        cart.setProduct(this.productService.get(new Product(1)));
        cart.setQuantity(1);
        cart.setStatus(0);
        this.cartService.save(cart);

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(1);
        paymentMethod.setName("Transfer");
        this.paymentMethodService.save(paymentMethod);

        paymentMethod = new PaymentMethod();
        paymentMethod.setId(2);
        paymentMethod.setName("Credit Card");
        this.paymentMethodService.save(paymentMethod);

        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(1);
        deliveryAddress.setAddress("Jl. Raya no. 221");
        deliveryAddress.setCity("Jakarta");
        deliveryAddress.setPostCode("433234");
        deliveryAddress.setCustomer(this.customerService.get(new Customer(1)));
        deliveryAddress.setSelected(true);
        this.deliveryAddressService.save(deliveryAddress);

        deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(2);
        deliveryAddress.setAddress("Jl. Komplek ABC no. 33A");
        deliveryAddress.setCity("Jakarta");
        deliveryAddress.setPostCode("233314");
        deliveryAddress.setCustomer(this.customerService.get(new Customer(1)));
        deliveryAddress.setSelected(false);
        this.deliveryAddressService.save(deliveryAddress);

        customer = this.customerService.get(new Customer(1));
        customer.setPaymentMethod(this.paymentMethodService.get(new PaymentMethod(1)));
        this.customerService.update(customer);
    }
}
