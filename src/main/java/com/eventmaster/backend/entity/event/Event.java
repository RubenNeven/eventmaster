package com.eventmaster.backend.entity.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Entity(name = "event")
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "location")
    private String location;
    @Column(name = "date_from")
    private LocalDateTime dateFrom;
    @Column(name = "date_until")
    private LocalDateTime dateUntil;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
