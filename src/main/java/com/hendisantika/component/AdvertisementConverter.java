package com.hendisantika.component;

import com.hendisantika.dto.AdvertisementDTO;
import com.hendisantika.entity.Advertisement;
import com.hendisantika.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.32
 */
@Component
public class AdvertisementConverter {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private PictureConverter pictureConverter;

    public Advertisement modelToEntity(AdvertisementDTO model) {
        Advertisement ad = new Advertisement();
        ad.setId(model.getId());
        ad.setDescription(model.getDescription());
        ad.setTypology(model.getTypology());
        ad.setHouseSize(model.getHouseSize());
        ad.setGardenSize(model.getGardenSize());
        ad.setIrrelevantFrom(model.getIrrelevantFrom());
        ad.setScore(model.getScore());
        ad.setPictures(model.getPicturesIds().stream().map(pictureService::findEntityById).collect(Collectors.toList()));
        return ad;
    }

    public AdvertisementDTO entityToModel(Advertisement ad) {
        AdvertisementDTO model = new AdvertisementDTO();
        model.setId(ad.getId());
        model.setDescription(ad.getDescription());
        model.setTypology(ad.getTypology());
        model.setHouseSize(ad.getHouseSize());
        model.setGardenSize(ad.getGardenSize());
        model.setIrrelevantFrom(ad.getIrrelevantFrom());
        model.setScore(ad.getScore());
        model.setPictures(ad.getPictures().stream().map(pictureConverter::entityToModel).collect(Collectors.toList()));
        return model;
    }
}
