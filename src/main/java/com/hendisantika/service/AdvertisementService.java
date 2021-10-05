package com.hendisantika.service;

import com.hendisantika.component.AdvertisementConverter;
import com.hendisantika.component.AdvertisementScoreConverter;
import com.hendisantika.dto.AdvertisementDTO;
import com.hendisantika.entity.Advertisement;
import com.hendisantika.helper.ScoreHelper;
import com.hendisantika.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.25
 */
@Service
public class AdvertisementService {

    private final static int MIN_AD_SCORE = 40;
    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private AdvertisementConverter converter;
    @Autowired
    private AdvertisementScoreConverter adScoreconverter;

    public List<AdvertisementDTO> findAll(Boolean relevants, Boolean irrelevants, String sortField, String sortOrder) {
        List<AdvertisementDTO> advertisements = advertisementRepository.findAll().stream()
                .parallel()
                .filter(ad -> (irrelevants && ad.getScore() < MIN_AD_SCORE) || (relevants && ad.getScore() >= MIN_AD_SCORE))
                .map(converter::entityToModel)
                .collect(Collectors.toList());
        Comparator<AdvertisementDTO> comparator = AdvertisementDTO.getAdComparator(sortField, sortOrder);
        if (comparator != null) {
            advertisements.sort(comparator);
        }
        return advertisements;
    }

    public Advertisement create(AdvertisementDTO ad) {
        if (ad.getId() != null) {
            Optional<Advertisement> existedAd = advertisementRepository.findById(ad.getId());
            if (existedAd.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Advertisement with Id " + ad.getId() + " " +
                        "already exist");
            }
        }
        Advertisement adEntity = converter.modelToEntity(ad);
        adEntity.setScore(ScoreHelper.calculateAdScore(adEntity));
        adEntity.setIrrelevantFrom((adEntity.getScore() < 40) ? new Date().getTime() : null);
        return advertisementRepository.save(adEntity);
    }
}
