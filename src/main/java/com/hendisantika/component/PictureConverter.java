package com.hendisantika.component;

import com.hendisantika.dto.PictureDTO;
import com.hendisantika.entity.Picture;
import com.hendisantika.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.26
 */
@Component
public class PictureConverter {

    @Autowired
    private PictureService pictureService;

    public Picture modelToEntity(PictureDTO model) {
        Picture picture = new Picture();
        picture.setId(model.getId());
        picture.setUrl(model.getUrl());
        picture.setQuality(model.getQuality());
        return picture;
    }
}
