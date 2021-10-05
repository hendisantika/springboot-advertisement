package com.hendisantika.component;

import com.hendisantika.dto.AdvertisementScoreDTO;
import com.hendisantika.entity.Advertisement;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.38
 */
@Component
public class AdvertisementScoreConverter {

    public AdvertisementScoreDTO entityToModel(Advertisement ad) {
        AdvertisementScoreDTO model = new AdvertisementScoreDTO();
        model.setId(ad.getId());
        model.setDescription(ad.getDescription());
        model.setTypology(ad.getTypology());
        model.setIrrelevantFrom(ad.getIrrelevantFrom());
        model.setScore(ScoreHelper.calculateAdScore(ad));
        return model;
    }

}
