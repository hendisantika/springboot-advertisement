package com.hendisantika.helper;

import com.hendisantika.entity.Picture;

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
}
