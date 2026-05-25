package ru.job4j.cars.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ads")
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "car_brand", nullable = false)
    private String carBrand;

    @Column(name = "body_type", nullable = false)
    private String bodyType;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "is_sold")
    private boolean sold = false;
}