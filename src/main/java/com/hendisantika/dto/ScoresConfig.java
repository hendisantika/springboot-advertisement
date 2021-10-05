package com.hendisantika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoresConfig {
    private final List<String> pictures = new ArrayList<>();
    private final List<String> descriptionContains = new ArrayList<>();
    private final List<String> descriptionLengths = new ArrayList<>();
    private final List<String> adComplete = new ArrayList<>();
    private Integer noPictures;
    private Integer haveDescription;

    public Map<String, Integer> getPicturesMap() {
        return this.pictures
                .stream()
                .map(element -> element.split(":"))
                .collect(Collectors.toMap(element -> element[0], element -> Integer.parseInt(element[0])));
    }

    public Map<String, Integer> getDescriptionContainsMap() {
        return this.descriptionContains
                .stream()
                .map(element -> element.split(":"))
                .collect(Collectors.toMap(element -> element[0], element -> Integer.parseInt(element[1])));
    }

}
