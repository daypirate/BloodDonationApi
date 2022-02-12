package pl.kowalecki.blooddonationapi.api.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kowalecki.blooddonationapi.cipher.MD5Cipher;
import pl.kowalecki.blooddonationapi.model.ResultModel;
import pl.kowalecki.blooddonationapi.model.donation.BloodDonationList;
import pl.kowalecki.blooddonationapi.model.user.UserModel;
import pl.kowalecki.blooddonationapi.service.user.UserService;

import java.util.List;

@RequestMapping("/userAccount")
@RestController
public class UserApi {

    UserService userService;


    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;

    }

//    @GetMapping("getUser/username={username}&password={password}")
//    public ResponseEntity<List<UserModel>> getUser(@PathVariable String username, @PathVariable String password) {
//        if (!userService.getUser(username, password).isEmpty()) {
//
//            return new ResponseEntity<>(userService.getUser(username, password), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("getUserModel/username={username}&password={password}")
    public ResponseEntity<UserModel> getUserModel(@PathVariable String username, @PathVariable String password) {
        if (userService.getUserModel(username, password).getUsername() != null) {
            return new ResponseEntity<>(userService.getUserModel(username, password), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("getUserDonations/id={id}")
    public ResponseEntity<BloodDonationList> getBloodDonationForUser(@PathVariable int id) {
        if (!userService.getBloodDonationForUser(id).bloodDonationModelList.isEmpty()) {
            return new ResponseEntity<>(userService.getBloodDonationForUser(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
