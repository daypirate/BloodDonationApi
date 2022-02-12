package pl.kowalecki.blooddonationapi.model.donation;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


public class BloodDonationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bloodId;
    String amonutDonation;
    Date dateDonation;
    String placeDonation;
    int donatorId;

    public BloodDonationModel() {
    }

    public BloodDonationModel(int bloodId, String amonutDonation, Date dateDonation, String placeDonation, int donatorId ) {
        this.bloodId = bloodId;
        this.amonutDonation = amonutDonation;
        this.dateDonation = dateDonation;
        this.placeDonation = placeDonation;
        this.donatorId = donatorId;
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

    public Date getDateDonation() {
        return dateDonation;
    }

    public void setDateDonation(Date dateDonation) {
        this.dateDonation = dateDonation;
    }

    public String getPlaceDonation() {
        return placeDonation;
    }

    public void setPlaceDonation(String placeDonation) {
        this.placeDonation = placeDonation;
    }

    public int getDonatorId() {
        return donatorId;
    }

    public void setDonatorId(int donatorId) {
        this.donatorId = donatorId;
    }

    @Override
    public String toString() {
        return "BloodDonationModel{" +
                "bloodId=" + bloodId +
                ", amonutDonation='" + amonutDonation + '\'' +
                ", dateDonation='" + dateDonation + '\'' +
                ", placeDonation='" + placeDonation + '\'' +
                ", donatorId=" + donatorId +
                '}';
    }
}
