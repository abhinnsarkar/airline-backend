package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.models.CustomerModel;
import com.sarkar.airlinebackend.models.FlightModel;
import com.sarkar.airlinebackend.models.ModelSeatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class ModelSeatDataService {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }



    public List<ModelSeatModel> getAllSeatsByModelNameKey(String flightModelNameKey) {

        String sql = "SELECT * FROM model_seat WHERE flight_model_name_key = ?";

        RowMapper<ModelSeatModel> mapper = new RowMapper<ModelSeatModel>(){

            @Override
            public ModelSeatModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                ModelSeatModel modelSeat = new ModelSeatModel();

                modelSeat.setModelSeatId((UUID) rs.getObject("model_seat_id", UUID.class));
                modelSeat.setSeatNumber(rs.getString("seat_number"));
                modelSeat.setSeatClass(rs.getString("seat_class"));
                modelSeat.setFlightModelNameKey(rs.getString("flight_model_name_key"));

                return modelSeat;
            }

        };

        return template.query(sql, mapper);

    }

}
