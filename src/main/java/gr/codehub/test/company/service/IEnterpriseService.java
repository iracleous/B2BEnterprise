package gr.codehub.test.company.service;

import gr.codehub.test.company.model.Customer;
import gr.codehub.test.company.model.Product;
import gr.codehub.test.company.repository.Customers;
import gr.codehub.test.company.repository.Products;

import java.io.IOException;

public interface IEnterpriseService {
    Customers getCustomers();
    Customer getCustomerByCode(int code);
    Products getProducts();
    Product getProductByCode(int code) throws IOException;
}
