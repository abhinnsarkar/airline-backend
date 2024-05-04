package com.sarkar.airlinebackend.handlers.Customer;

import com.sarkar.airlinebackend.services.business.Customer.GetCustomersBusiness;
import com.sarkar.airlinebackend.models.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomersHandler {

    @Autowired
    private GetCustomersBusiness getCustomersBusiness;
    public List<CustomerModel> getCustomers() {
        return getCustomersBusiness.getCustomers();
    }
}
