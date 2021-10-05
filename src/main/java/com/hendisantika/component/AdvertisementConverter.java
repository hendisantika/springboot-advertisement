package com.hendisantika.component;

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
 * Time: 06.32
 */
@Component
public class AdvertisementConverter {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private PictureConverter pictureConverter;
}
