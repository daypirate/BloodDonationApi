package pl.kowalecki.blooddonationapi.model;

import java.util.List;

public class BloodDonationList {

    public List<BloodDonationModel> bloodDonationModelList;

    public BloodDonationList() {
    }

    public BloodDonationList(List<BloodDonationModel> bloodDonationModelList) {
        this.bloodDonationModelList = bloodDonationModelList;
    }

    public List<BloodDonationModel> getBloodDonationModelList() {
        return bloodDonationModelList;
    }

    public void setBloodDonationModelList(List<BloodDonationModel> bloodDonationModelList) {
        this.bloodDonationModelList = bloodDonationModelList;
    }
}
