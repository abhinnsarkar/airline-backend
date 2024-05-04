package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.models.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class Customer {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<CustomerModel> getAllCustomers(){

        String sql = "SELECT * from public.customer";

        RowMapper<CustomerModel> mapper = new RowMapper<CustomerModel>(){

            @Override
            public CustomerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                CustomerModel customerModel = new CustomerModel();
                customerModel.setCustomerId((UUID) rs.getObject("customer_id", UUID.class));
                customerModel.setCustomerName(rs.getString("customer_name"));
                customerModel.setDob(rs.getDate("dob"));
                return customerModel;
            }

        };


        return template.query(sql, mapper);
    }
}
