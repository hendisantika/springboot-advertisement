package com.hendisantika.controller;

import com.hendisantika.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
