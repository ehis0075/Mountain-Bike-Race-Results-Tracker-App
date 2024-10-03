package com.sport.club.service.implementation;


import com.sport.club.enums.ResponseCodeAndMessage;
import com.sport.club.exceptions.GeneralException;
import com.sport.club.model.Rider;
import com.sport.club.pojo.request.CreateRiderDTO;
import com.sport.club.pojo.response.RiderDTO;
import com.sport.club.repository.RiderRepository;
import com.sport.club.service.RiderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Data
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final RiderRepository riderRepository;

    @Override
    public List<Rider> getRiderList() {
        log.info("Getting all riders");

        return riderRepository.findAll();
    }

    @Override
    public RiderDTO createRider(CreateRiderDTO request) {
        log.info("Creating rider with request {}", request);

        Rider rider = riderRepository.findByName(request.getName());

        if (Objects.isNull(rider)) {
            rider = new Rider();
            rider.setName(request.getName());
        } else {
            throw new GeneralException(ResponseCodeAndMessage.ALREADY_EXIST_60.responseMessage);
        }
        RiderDTO riderDTO = new RiderDTO();
        BeanUtils.copyProperties(rider, riderDTO);

        return riderDTO;
    }



}
