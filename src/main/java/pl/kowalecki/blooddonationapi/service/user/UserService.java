package pl.kowalecki.blooddonationapi.service.user;

import pl.kowalecki.blooddonationapi.model.donation.BloodDonationList;
import pl.kowalecki.blooddonationapi.model.donation.BloodDonationModel;
import pl.kowalecki.blooddonationapi.model.user.UserModel;

import java.util.List;

public interface UserService {

//    List<UserModel> getUser(String username, String password);
    UserModel getUserModel(String username, String password);
    BloodDonationList getBloodDonationForUser(int id);
}
