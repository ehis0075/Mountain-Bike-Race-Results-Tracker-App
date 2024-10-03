package com.sport.club.service;

import com.sport.club.model.Rider;
import com.sport.club.pojo.request.CreateRiderDTO;
import com.sport.club.pojo.response.RiderDTO;

import java.util.List;

public interface RiderService {

    List<Rider> getRiderList();

    RiderDTO createRider(CreateRiderDTO request);
}
