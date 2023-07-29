package org.gs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "planet")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Planet {
    @Id
    @Column(name = "id", length = 30, nullable = false)
    private String id;

    @Column(name = "name", length = 500, nullable = false)
    private String name;

    @OneToMany(mappedBy = "fromPlanetId", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Ticket> fromPlanetTickets;

    @OneToMany(mappedBy = "toPlanetId", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Ticket> toPlanetTickets;
}