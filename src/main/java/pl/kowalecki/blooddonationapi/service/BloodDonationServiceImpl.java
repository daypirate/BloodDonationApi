package pl.kowalecki.blooddonationapi.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.kowalecki.blooddonationapi.model.BloodDonationList;
import pl.kowalecki.blooddonationapi.model.BloodDonationModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BloodDonationServiceImpl implements BloodDonationService{

    private JdbcTemplate jdbcTemplate;

    public BloodDonationServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public List<BloodDonationModel> getAllDonations() {
//        List<BloodDonationModel> bloodList = new ArrayList<>();
//        String sql = "SELECT * FROM blooddonation";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        maps.forEach(element -> bloodList.add(new BloodDonationModel(
//                (Integer)(element.get("blood_id")) ,
//                String.valueOf(element.get("amount_donation")),
//                String.valueOf(element.get("date_donation")),
//                String.valueOf(element.get("place_donation"))
//
//        )));
//        return bloodList;
//    }

    @Override
    public BloodDonationList getAllDonations() {
        BloodDonationList bloodListList = new BloodDonationList();
        List<BloodDonationModel> bloodList = new ArrayList<>();
        String sql = "SELECT * FROM blooddonation";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(element -> bloodList.add(new BloodDonationModel(
                (Integer)(element.get("blood_id")) ,
                String.valueOf(element.get("amount_donation")),
                String.valueOf(element.get("date_donation")),
                String.valueOf(element.get("place_donation"))

        )));
        bloodListList.setBloodDonationModelList(bloodList);
        return bloodListList;
    }

    @Override
    public boolean addBloodDonation(BloodDonationModel bloodDonationModel) {
        BloodDonationModel newModel = new BloodDonationModel(bloodDonationModel.getBloodId(), bloodDonationModel.getAmonutDonation(), bloodDonationModel.getDateDonation(), bloodDonationModel.getPlaceDonation());
        String sql = "INSERT INTO blooddonation VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, newModel.getBloodId(), newModel.getAmonutDonation(), newModel.getDateDonation(), newModel.getPlaceDonation());
        return true;
    }

    @Override
    public boolean deleteBloodDonation(int id) {
        String sql = "DELETE FROM blooddonation WHERE blood_id=?";
        jdbcTemplate.update(sql, id);
        return true;
    }

    @Override
    public boolean editBloodDonation(int id, BloodDonationModel newBloodDonation) {
        BloodDonationModel newModel = new BloodDonationModel(newBloodDonation.getBloodId(), newBloodDonation.getAmonutDonation(), newBloodDonation.getDateDonation(), newBloodDonation.getPlaceDonation());
        String sql = "UPDATE blooddonation SET amount_donation=?, date_donation=?, place_donation=? WHERE blood_id=?";
        this.jdbcTemplate.update(sql,newModel.getAmonutDonation(), newModel.getDateDonation(), newModel.getPlaceDonation(), newModel.getBloodId());
        return true;
    }
}
