package com.sport.club.service.implementation;


import com.sport.club.model.Rider;
import com.sport.club.repository.RiderRepository;
import com.sport.club.service.RiderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
