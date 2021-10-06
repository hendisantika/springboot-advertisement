package com.hendisantika.controller;

import com.hendisantika.dto.AdvertisementDTO;
import com.hendisantika.dto.AdvertisementScoreDTO;
import com.hendisantika.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.57
 */
@RestController
@RequestMapping("/api")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping(value = "/advertisement/calculate-scores")
    public List<AdvertisementScoreDTO> calculateScores() {
        return this.advertisementService.calculateScores();
    }

    @GetMapping(value = "/advertisement/all")
    public List<AdvertisementDTO> findAll(@RequestParam(required = false, defaultValue = "all") String show,
                                          @RequestParam(required = false) String sort) {
        boolean relevants = show.equals("all") || show.equals("relevants");
        boolean irrelevants = show.equals("all") || show.equals("irrelevants");
        return this.findAdvertisements(relevants, irrelevants, sort);
    }

    @GetMapping(value = "/advertisement")
    public List<AdvertisementDTO> findAllRelevants(@RequestParam(required = false) String sort) {
        return this.findAdvertisements(true, false, sort);
    }

    private List<AdvertisementDTO> findAdvertisements(Boolean relevants, Boolean irrelevants, String sort) {
        String sortField = null, sortOrder = null;
        if (sort != null) {
            String[] sortInfo = sort.split(":");
            sortField = sortInfo.length > 0 ? sortInfo[0] : null;
            sortOrder = sortInfo.length > 1 ? sortInfo[1] : "desc";
        }
        return advertisementService.findAll(relevants, irrelevants, sortField, sortOrder);
    }
}
