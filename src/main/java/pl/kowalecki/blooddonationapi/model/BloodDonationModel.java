package pl.kowalecki.blooddonationapi.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BloodDonationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bloodId;
    String amonutDonation;
    String dateDonation;
    String placeDonation;

    public BloodDonationModel() {
    }

    public BloodDonationModel(int bloodId, String amonutDonation, String dateDonation, String placeDonation) {
        this.bloodId = bloodId;
        this.amonutDonation = amonutDonation;
        this.dateDonation = dateDonation;
        this.placeDonation = placeDonation;
    }

    public int getBloodId() {
        return bloodId;
    }

    public void setBloodId(int bloodId) {
        this.bloodId = bloodId;
    }

    public String getAmonutDonation() {
        return amonutDonation;
    }

    public void setAmonutDonation(String amonutDonation) {
        this.amonutDonation = amonutDonation;
    }

    public String getDateDonation() {
        return dateDonation;
    }

    public void setDateDonation(String dateDonation) {
        this.dateDonation = dateDonation;
    }

    public String getPlaceDonation() {
        return placeDonation;
    }

    public void setPlaceDonation(String placeDonation) {
        this.placeDonation = placeDonation;
    }

    @Override
    public String toString() {
        return "BloodDonationModel{" +
                "bloodId=" + bloodId +
                ", amonutDonation='" + amonutDonation + '\'' +
                ", dateDonation='" + dateDonation + '\'' +
                ", placeDonation='" + placeDonation + '\'' +
                '}';
    }
}
