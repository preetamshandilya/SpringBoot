package com.example.GmailApi.service;

import com.google.api.client.auth.oauth2.Credential;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface IGmailService {
    public void getAuth() throws GeneralSecurityException, IOException;

}
