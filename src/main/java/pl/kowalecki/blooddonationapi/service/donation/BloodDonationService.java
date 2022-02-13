package pl.kowalecki.blooddonationapi.service.donation;

import pl.kowalecki.blooddonationapi.model.BloodDonationList;
import pl.kowalecki.blooddonationapi.model.BloodDonationModel;


public interface BloodDonationService {

    BloodDonationList getAllDonations();
    boolean addBloodDonation(BloodDonationModel bloodDonationModel);
    boolean deleteBloodDonation(int id);
    boolean editBloodDonation(int id,BloodDonationModel newBloodDonation);


}
