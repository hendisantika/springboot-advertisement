package com.hendisantika.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.47
 */
public class ScoresConfig {
    private final List<String> pictures = new ArrayList<>();
    private final List<String> descriptionContains = new ArrayList<>();
    private final List<String> descriptionLengths = new ArrayList<>();
    private final List<String> adComplete = new ArrayList<>();
    private Integer noPictures;
    private Integer haveDescription;
}
