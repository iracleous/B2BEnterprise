package gr.codehub.test.company.service;

import gr.codehub.test.company.model.Customer;
import gr.codehub.test.company.model.Product;
import gr.codehub.test.company.repository.Customers;
import gr.codehub.test.company.repository.Products;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Qualifier("baeldung")
@Service
public class OtherService implements IEnterpriseService {
    @Override
    public Customers getCustomers() {
        return null;
    }

    @Override
    public Customer getCustomerByCode(int code) {
        return null;
    }

    @Override
    public Products getProducts() {
        return null;
    }

    @Override
    public Product getProductByCode(int code) throws IOException {
        return null;
    }
}
