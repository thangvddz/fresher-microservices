package com.fresher.msa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "hotel")
@Data
public class Hotel {
    @Id
    private Long idHotel;
    @Column(name = "name_hotel")
    private String nameHotel;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "time_check_in_default", columnDefinition = "timestamp with time zone not null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCheckInDefault;
    @Column(name = "time_check_out_default", columnDefinition = "timestamp with time zone not null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCheckOutDefault;
}
