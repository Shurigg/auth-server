package com.yandream.health.authserver.util;

import com.yandream.health.authserver.error.OAuth2AuthenticationProcessingException;
import com.yandream.health.authserver.model.security.AuthProvider;
import com.yandream.health.authserver.model.security.user.FacebookOAuth2UserInfo;
import com.yandream.health.authserver.model.security.user.GithubOAuth2UserInfo;
import com.yandream.health.authserver.model.security.user.GoogleOAuth2UserInfo;
import com.yandream.health.authserver.model.security.user.OAuth2UserInfo;

import java.util.Map;

public class OAuth2UserInfoFactory {

    private OAuth2UserInfoFactory() {

    }

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
            return new GithubOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
