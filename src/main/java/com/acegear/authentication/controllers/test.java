package com.acegear.authentication.controllers;

import com.acegear.authentication.domain.User;
import com.acegear.authentication.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guoweike on 16/11/23.
 */
@RestController
@SuppressWarnings("unused")
public class test {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map<String, String> invitationAccount(@RequestParam String username, @RequestParam String password) {
        Map<String, String> map = new HashMap<>();
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            map.put("state", "201");
        } else {
            map.put("state", "200");

        }
        return map;

    }
}
