package com.hendisantika.service;

import com.hendisantika.component.PictureConverter;
import com.hendisantika.dto.PictureDTO;
import com.hendisantika.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private PictureRepository repository;
    @Autowired
    private PictureConverter converter;

    public PictureDTO findById(Integer id) {
        return converter.entityToModel(findEntityById(id));
    }
}
