package pl.kowalecki.blooddonationapi.service;

import pl.kowalecki.blooddonationapi.model.BloodDonationList;
import pl.kowalecki.blooddonationapi.model.BloodDonationModel;

import java.util.List;


public interface BloodDonationService {

    BloodDonationList getAllDonations();
    boolean addBloodDonation(BloodDonationModel bloodDonationModel);
    boolean deleteBloodDonation(int id);
    boolean editBloodDonation(int id,BloodDonationModel newBloodDonation);


}
