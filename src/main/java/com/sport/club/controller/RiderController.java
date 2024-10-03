package com.sport.club.controller;


import com.sport.club.enums.ResponseCodeAndMessage;
import com.sport.club.general.GeneralService;
import com.sport.club.model.Rider;
import com.sport.club.pojo.request.CreateRiderDTO;
import com.sport.club.pojo.response.RiderDTO;
import com.sport.club.service.RiderService;
import com.sport.club.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/riders")
public class RiderController {

    private final GeneralService generalService;
    private final RiderService riderService;

    @PostMapping("/create")
    public Response createRider(@RequestBody CreateRiderDTO createRiderDTO) {

        RiderDTO data = riderService.createRider(createRiderDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @GetMapping()
    public Response getRiderList() {

        List<Rider> data = riderService.getRiderList();
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }


}
