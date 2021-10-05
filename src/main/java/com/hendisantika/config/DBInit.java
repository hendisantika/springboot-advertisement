package com.hendisantika.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hendisantika.dto.AdvertisementDTO;
import com.hendisantika.dto.PictureDTO;
import com.hendisantika.service.AdvertisementService;
import com.hendisantika.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.io.InputStream;
import java.util.List;

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

    @Override
    public void run(String... args) throws Exception {
        logger.info("Starting DB Init!");
        loadPictures();
        loadAdvertisements();
    }

    private void loadPictures() throws Exception {
        logger.info("Loading Pictures");
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<PictureDTO>> typeReference = new TypeReference<List<PictureDTO>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/pictures.json");
        try {
            List<PictureDTO> pictures;
            pictures = mapper.readValue(inputStream, typeReference);
            pictures.forEach(pictureService::create);
            logger.info("Number of pictures created: " + pictures.size());
        } catch (Exception e) {
            logger.error("Unable to create pictures: " + e.getMessage());
        }
    }

    private void loadAdvertisements() throws Exception {
        logger.info("Loading Advertisements");
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<AdvertisementDTO>> typeReference = new TypeReference<List<AdvertisementDTO>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/advertisements.json");
        try {
            List<AdvertisementDTO> advertisements = mapper.readValue(inputStream, typeReference);
            advertisements.forEach(advertisementService::create);
            logger.info("Number of advertisements created: " + advertisements.size());
        } catch (Exception e) {
            logger.error("Unable to create advertisements: " + e.getMessage());
            throw e;
        }
    }
}
