package com.fresher.msa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class RoomHotel {
    @Id
    private int id;
    @Column(name = "number_room")
    private String numberRoom;
    @Column(name = "floor")
    private int floor;
    @Column(name = "id_type_room")
    private int idTypeRoom;
    @Column(name = "id_hotel")
    private Long idHotel;
    @Column(name = "status")
    private boolean status;
}
