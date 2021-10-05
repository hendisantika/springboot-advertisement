package com.hendisantika.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.33
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDTO {
    private Integer id;

    private String description;

    private String typology;

    private Integer houseSize;

    private Integer gardenSize;

    private List<PictureDTO> pictures;

    private List<Integer> picturesIds;

    private Integer score;

    private Long irrelevantFrom;

    public static Comparator<AdvertisementDTO> getAdComparator(String field, String order) {
        if (field == null) {
            return null;
        }
        Comparator<AdvertisementDTO> comparator = null;
        switch (field) {
            case "score":
                comparator = Comparator.comparing(ad -> ad.getScore());
                break;
            case "description":
                comparator = Comparator.comparing(ad -> ad.getDescription().toLowerCase());
                break;
            case "typology":
                comparator = Comparator.comparing(ad -> ad.getTypology().toLowerCase());
                break;
            case "houseSize":
                comparator = Comparator.comparing(ad -> ad.getHouseSize(),
                        Comparator.nullsFirst(Comparator.naturalOrder()));
                break;
            case "gardenSize":
                comparator = Comparator.comparing(ad -> ad.getGardenSize(),
                        Comparator.nullsFirst(Comparator.naturalOrder()));
                break;
            default:
                return null;
        }

        return order.equals("desc") ? comparator.reversed() : comparator;
    }
}
