package com.hendisantika.helper;

import com.hendisantika.entity.Advertisement;
import com.hendisantika.entity.Picture;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.39
 */
public class ScoreHelper {
    private static final String[] DESCRIPTION_CHARACTERISTICS = {"Luminoso", "Nuevo", "Céntrico", "Reformado", "Atico"};

    private static Integer getPictureScore(Picture picture) {
        return picture.getQuality() == "HD" ? 20 : 10;
    }

    private static Integer getAdPicturesScore(Advertisement ad) {
        return ad.getPictures().isEmpty()
                ? -10
                : ad.getPictures()
                .stream()
                .mapToInt(ScoreHelper::getPictureScore)
                .sum();
    }

    private static Integer getAdDescriptionScore(Advertisement ad) {
        String description = ad.getDescription();
        int desScore = 0;
        if (description != null && !description.isEmpty()) {
            desScore += 5;
            switch (ad.getTypology()) {
                case "FLAT":
                    desScore += description.length() > 20 && description.length() < 50
                            ? 10
                            : description.length() >= 50
                            ? 30
                            : 0;
                    break;
                case "CHALET":
                    desScore += description.length() > 50 ? 20 : 0;
                    break;
            }
            desScore += Arrays.asList(DESCRIPTION_CHARACTERISTICS)
                    .stream()
                    .map(String::toLowerCase)
                    .mapToInt(element -> description.toLowerCase().contains(element) ? 5 : 0)
                    .sum();

        }
        return desScore;
    }

    private static Boolean isAdCompleteByTypology(Advertisement ad) {
        switch (ad.getTypology()) {
            case "FLAT":
                return ad.getDescription() != null
                        && !ad.getDescription().isEmpty()
                        && ad.getHouseSize() != null
                        && ad.getHouseSize() > 0;
            case "CHALET":
                return ad.getDescription() != null
                        && !ad.getDescription().isEmpty()
                        && ad.getHouseSize() != null
                        && ad.getHouseSize() > 0
                        && ad.getGardenSize() != null
                        && ad.getGardenSize() > 0;
            case "GARAGE":
                return true;
            default:
                return false;
        }
    }


}
