package pl.kowalecki.blooddonationapi.service.user;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.kowalecki.blooddonationapi.model.BloodDonationList;
import pl.kowalecki.blooddonationapi.model.BloodDonationModel;
import pl.kowalecki.blooddonationapi.model.UserModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public List<UserModel> getUser(String username, String password) {
//        List<UserModel> user = new ArrayList<>();
//        String sql = "SELECT * FROM useraccount WHERE user_name=? AND user_password=?";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, username, password);
//        maps.forEach(element -> user.add(new UserModel(
//                (Integer) element.get("user_id"),
//                String.valueOf(element.get("user_name")),
//                String.valueOf(element.get("user_password")),
//                (Date)(element.get("creation_date")),
//                String.valueOf(element.get("user_email"))
//        )));
//        return user;
//
//    }

    @Override
    public UserModel getUserModel(String username, String password) {
        UserModel userModel = new UserModel();
        String sql = "SELECT * FROM useraccount WHERE user_name=? AND user_password=?";
        try{
            userModel = jdbcTemplate.queryForObject(sql, new Object[]{username, password},
                    (rs, rowNum) -> new UserModel(
                            rs.getInt("user_id"),
                            rs.getString("user_name"),
                            rs.getString("user_password"),
                            rs.getDate("creation_date"),
                            rs.getString("user_email")

                    ));
            return userModel;
        }catch (EmptyResultDataAccessException e){

        }
        return userModel;
    }


    @Override
    public BloodDonationList getBloodDonationForUser(int id) {
        BloodDonationList bloodListList = new BloodDonationList();
        List<BloodDonationModel> donation = new ArrayList<>();
        String sql = "SELECT * FROM blooddonation WHERE user_id_FK=?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, id);
        maps.forEach(element -> donation.add(new BloodDonationModel(
                (Integer) element.get("blood_id"),
                String.valueOf(element.get("amount_donation")),
                (Date)(element.get("date_donation")),
                String.valueOf(element.get("place_donation")),
                (Integer) element.get("user_id_FK"))
        ));
        bloodListList.setBloodDonationModelList(donation);
        return bloodListList;
    }
}
