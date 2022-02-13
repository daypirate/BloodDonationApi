package pl.kowalecki.blooddonationapi.service.user;

import pl.kowalecki.blooddonationapi.model.BloodDonationList;
import pl.kowalecki.blooddonationapi.model.UserModel;

public interface UserService {

//    List<UserModel> getUser(String username, String password);
    UserModel getUserModel(String username, String password);
    BloodDonationList getBloodDonationForUser(int id);
}
