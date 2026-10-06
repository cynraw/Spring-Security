package com.chep.client.event.listener;

import com.chep.client.entity.User;
import com.chep.client.event.RegistrationCompleteEvent;
import com.chep.client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the verification token for user
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

        //Send mail to user
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

        //Mocking the send verification email functionality
        log.info("Click the lnk to verify your account: {}", url);

    }
}
