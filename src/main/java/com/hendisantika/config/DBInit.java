package com.hendisantika.config;

import com.hendisantika.service.AdvertisementService;
import com.hendisantika.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.54
 */
public class DBInit implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DBInit.class);

    @Autowired
    private PictureService pictureService;

    @Autowired
    private AdvertisementService advertisementService;
}
