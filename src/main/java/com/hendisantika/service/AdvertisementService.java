package com.hendisantika.service;

import com.hendisantika.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private AdvertisementRepository repository;
    @Autowired
    private AdvertisementConverter converter;
    @Autowired
    private AdvertisementScoreConverter adScoreconverter;
}
