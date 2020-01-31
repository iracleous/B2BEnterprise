package gr.codehub.test.company.controller;

import gr.codehub.test.company.model.Customer;
import gr.codehub.test.company.model.Product;
import gr.codehub.test.company.repository.Customers;
import gr.codehub.test.company.repository.Products;
import gr.codehub.test.company.service.EnterpriseService;
import gr.codehub.test.company.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("myapp/v1")
public class EnterpriseController {

    @Autowired
    @Qualifier("baeldung")
    private IEnterpriseService ea;


    @GetMapping("")
    public String getIntro(){
        return  null;
    }

    @GetMapping("customers")
    public Customers getCustomers(){

        return  ea.getCustomers();
    }

    @GetMapping("products")
    public Products getProducts(){

        return  ea.getProducts();
    }

    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable int id) throws IOException {

        return  ea.getProductByCode(id);
    }

    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable int id){

        return  ea.getCustomerByCode(id);
    }

}
