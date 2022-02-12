package pl.kowalecki.blooddonationapi.service.donation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.kowalecki.blooddonationapi.model.donation.BloodDonationList;
import pl.kowalecki.blooddonationapi.model.donation.BloodDonationModel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                (Date)(element.get("date_donation")),
                String.valueOf(element.get("place_donation")),
                (Integer)(element.get("user_id_FK"))

        )));
        bloodListList.setBloodDonationModelList(bloodList);
        return bloodListList;
    }

    @Override
    public boolean addBloodDonation(BloodDonationModel bloodDonationModel) {
        BloodDonationModel newModel = new BloodDonationModel(bloodDonationModel.getBloodId(), bloodDonationModel.getAmonutDonation(), bloodDonationModel.getDateDonation(), bloodDonationModel.getPlaceDonation(), bloodDonationModel.getDonatorId());
        String sql = "INSERT INTO blooddonation VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, newModel.getBloodId(), newModel.getAmonutDonation(), newModel.getDateDonation(), newModel.getPlaceDonation(), newModel.getDonatorId());
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
        BloodDonationModel newModel = new BloodDonationModel(newBloodDonation.getBloodId(), newBloodDonation.getAmonutDonation(), newBloodDonation.getDateDonation(), newBloodDonation.getPlaceDonation(), newBloodDonation.getDonatorId());
        String sql = "UPDATE blooddonation SET amount_donation=?, date_donation=?, place_donation=?, user_id_FK=? WHERE blood_id=?";
        this.jdbcTemplate.update(sql,newModel.getAmonutDonation(), newModel.getDateDonation(), newModel.getPlaceDonation(), newModel.getBloodId(), newModel.getDonatorId());
        return true;
    }
}
