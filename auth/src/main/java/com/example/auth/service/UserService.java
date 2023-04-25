package com.example.auth.service;

import com.example.auth.model.*;
import com.example.auth.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service

public class UserService {
    @Autowired
    private RepoUser repoUsers;
    @Autowired
    private RepoBankDetails repoBankDetails;
    @Autowired
    private RepoLocationDetails repoLocationDetails;
    @Autowired
    private RepoState repoState;
    @Autowired
    private RepoCountry repoCountry;
    @Autowired
    private RepoCity repoCity;


    public User addUser(User u){

        List<LocationDetails> locationDetailsList = u.getLocationDetailsList();

        List<BankDetails> bankDetails = u.getBankDetailsList();


        List<City> cityDetails = new ArrayList<>();
        for(LocationDetails ld:locationDetailsList){
            cityDetails.add(ld.getCity());
        }
        List<State> stateDetails=new ArrayList<>();
        for(City cd:cityDetails){
            stateDetails.add(cd.getState());
        }
        List<Country> countryDetails=new ArrayList<>();
        for(State sd:stateDetails){
            countryDetails.add(sd.getCountry());
        }

        for(Country country:countryDetails){
            repoCountry.save(country);
        }

        for(State state:stateDetails){
            Country country=new Country();
            country.setId(state.getCountry().getId());
            state.setCountry(country);
            repoState.save(state);
        }

        for(City city:cityDetails){
            State state=new State();
            state.setId(city.getState().getId());
            city.setState(state);
            repoCity.save(city);


        }

        u.setLocationDetailsList(null);
        u.setBankDetailsList(null);
        repoUsers.save(u);

        for(LocationDetails locationDetails:locationDetailsList){
            User newUser = new User();
            newUser.setId(u.getId());

            City newCity = new City();
            newCity.setId(locationDetails.getCity().getId());

            locationDetails.setUser(newUser);
            locationDetails.setCity(newCity);

            repoLocationDetails.save(locationDetails);
        }

        for(BankDetails bd:bankDetails){
            User newUser=new User();
            newUser.setId(u.getId());
            bd.setUser(newUser);
            repoBankDetails.save(bd);
        }
        u.setLocationDetailsList(locationDetailsList);
        u.setBankDetailsList(bankDetails);





        return u;


    }


}

