package gr.codehub.test.company.service;

import gr.codehub.test.company.model.Customer;
import gr.codehub.test.company.model.Product;
import gr.codehub.test.company.repository.Customers;
import gr.codehub.test.company.repository.Products;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Qualifier("mkyong")
@Service
public class EnterpriseService implements IEnterpriseService {

    public Customers getCustomers(){
        return new Customers("customers.csv");
    }

    public Customer getCustomerByCode(int code){
        Customers customers = new Customers("customers.csv");

        return customers.getCustomerByCode(code);
    }

    public Products getProducts(){

        try {
            return new Products("products.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Product getProductByCode(int code) throws IOException {
        Products products = new Products("products.xlsx");

        return products.getProductByCode(code);
    }



}
