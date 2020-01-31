package gr.codehub.test.company.repository;

import gr.codehub.test.company.model.Customer;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Data
public class Customers {
    private List<Customer> customers;

    private final String CSV_DELIMETER =",";

    public Customers() {
        customers = new ArrayList<>();
    }


    public Customers(String filename) {
        this();

        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String []words= line.split(CSV_DELIMETER);
                Customer customer = new Customer(
                        Integer.parseInt(words[0]), words[1], words[2],words[3]);

                customers.add(customer);

            }
        } catch (Exception e) {

        }

    }



    public Customer getCustomerByCode(int code){

        for(Customer customer:customers)
        {
            if (customer.getCode()==code)
                return customer;
        }
        return null;


//        return customers
//                .stream()
//                .filter(customer -> customer.getCode()==code)
//                .findFirst()
//                .get();

    }


}
