package com.hendisantika.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hendisantika.entity.Advertisement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 07.08
 */
@SpringBootTest
public class ScoreHelperTest {
    private List<Advertisement> advertisements;

    @BeforeEach
    public void init() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Advertisement>> typeReference = new TypeReference<List<Advertisement>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/exampleData.json");
        this.advertisements = mapper.readValue(inputStream, typeReference);
    }

    @Test
    public void testScoreCalculation() throws Exception {
        for (Advertisement advertisement : advertisements) {
            int score = ScoreHelper.calculateAdScore(advertisement);
            assertTrue(score == advertisement.getScore());
        }
    }
}
