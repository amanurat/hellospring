package com.assanai.spring.core.di;

import org.springframework.stereotype.Service;

/**
 * Created by amanurat on 2/3/2016 AD.
 */
@Service("facebookLoginService")
public class FacebookLoginService implements LoginService {

    public boolean login(String user, String password) {
        System.out.println("This is login by facebook service");
        return false;
    }
}
