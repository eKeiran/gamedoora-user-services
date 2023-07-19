package com.gamedoora.backend.userservices.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



//@RestController
//@RequestMapping("/api/auth")
//public class AuthenticationController {

//    @Autowired
//    private FirebaseAuth firebaseAuth;
//
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST,
//            consumes = "application/json", produces = "application/json")
//    public GdUser authenticateUser(@RequestBody GdLogin login) throws FirebaseAuthException {
//        FirebaseToken decodedToken = firebaseAuth.verifyIdToken(login.getToken(),true);
//        UserRecord userRecord = firebaseAuth.getUser(decodedToken.getUid());
//        GdUser user = new GdUser();
//        user.setEmail(userRecord.getEmail());
//        user.setPhoneNumber(userRecord.getPhoneNumber());
//        user.setEmailVerified(userRecord.isEmailVerified());
//        user.setDisplayName(userRecord.getDisplayName());
//        user.setPhotoUrl(userRecord.getPhotoUrl());
//        user.setCustomClaims(userRecord.getCustomClaims());
//        user.setProvider(userRecord.getProviderData()[0].getProviderId());
//        return user;
//    }

//}
