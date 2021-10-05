package com.hendisantika.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.22
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String description;

    @NotNull
    private String typology;

    private Integer houseSize;

    private Integer gardenSize;

    @ManyToMany
    @JoinTable(
            name = "AD_PIC",
            joinColumns = @JoinColumn(name = "AD_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PIC_ID", referencedColumnName = "ID"))
    private List<Picture> pictures = new ArrayList<>();

    private Integer score;

    private Long irrelevantFrom;
}
