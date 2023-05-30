package com.example.LocalUpload.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface IGoogleDriveService {
    public boolean upload(MultipartFile file) throws GeneralSecurityException, IOException;
}
