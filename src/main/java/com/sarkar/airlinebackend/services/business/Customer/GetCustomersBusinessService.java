package com.sarkar.airlinebackend.services.business.Customer;

import com.sarkar.airlinebackend.models.CustomerModel;
import com.sarkar.airlinebackend.services.data.CustomerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomersServiceBusiness {

    @Autowired
    private CustomerDataService customerDataService;

    public List<CustomerModel> getCustomers() {

        return customerDataService.getAllCustomers();
    }
}
