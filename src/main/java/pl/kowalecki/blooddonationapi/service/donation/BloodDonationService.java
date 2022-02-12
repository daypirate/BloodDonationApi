package pl.kowalecki.blooddonationapi.service.donation;

import pl.kowalecki.blooddonationapi.model.donation.BloodDonationList;
import pl.kowalecki.blooddonationapi.model.donation.BloodDonationModel;


public interface BloodDonationService {

    BloodDonationList getAllDonations();
    boolean addBloodDonation(BloodDonationModel bloodDonationModel);
    boolean deleteBloodDonation(int id);
    boolean editBloodDonation(int id,BloodDonationModel newBloodDonation);


}
