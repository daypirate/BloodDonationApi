package pl.kowalecki.blooddonationapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kowalecki.blooddonationapi.model.BloodDonationList;
import pl.kowalecki.blooddonationapi.model.BloodDonationModel;
import pl.kowalecki.blooddonationapi.service.BloodDonationService;

import javax.persistence.Access;
import java.util.List;

@RequestMapping("/bloodDonation")
@RestController
public class BloodDonationApi {
    BloodDonationService bloodDonationService;

    @Autowired
    public BloodDonationApi(BloodDonationService bloodDonationService) {
        this.bloodDonationService = bloodDonationService;
    }

    @GetMapping("allDonations")
    public ResponseEntity<BloodDonationList> getAllDonations(){
        if (!bloodDonationService.getAllDonations().bloodDonationModelList.isEmpty()){
            return new ResponseEntity<>(bloodDonationService.getAllDonations(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("addDonation")
    public ResponseEntity<HttpStatus> addBloodDonation(@RequestBody BloodDonationModel newBloodDonation){
            if(bloodDonationService.addBloodDonation(newBloodDonation)){
                return new ResponseEntity<>( HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
    }

    @DeleteMapping("deleteDonation/{id}")
    public ResponseEntity<HttpStatus> deleteBloodDonation(@PathVariable int id){
        if (bloodDonationService.deleteBloodDonation(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("editDonation/{id}")
    public ResponseEntity<HttpStatus> editBloodDonation(@PathVariable int id, @RequestBody BloodDonationModel bloodDonationModel){
        if (bloodDonationService.editBloodDonation(id, bloodDonationModel)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
