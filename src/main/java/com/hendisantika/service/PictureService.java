package com.hendisantika.service;

import com.hendisantika.component.PictureConverter;
import com.hendisantika.dto.PictureDTO;
import com.hendisantika.entity.Picture;
import com.hendisantika.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.26
 */
@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private PictureConverter converter;

    public PictureDTO findById(Integer id) {
        return converter.entityToModel(findEntityById(id));
    }

    public Picture findEntityById(Integer id) {
        Optional<Picture> picture = pictureRepository.findById(id);
        if (!picture.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Picture with Id " + id + " not exist");
        }
        return picture.get();
    }

    public Picture create(PictureDTO picture) {
        return pictureRepository.save(converter.modelToEntity(picture));
    }
}
