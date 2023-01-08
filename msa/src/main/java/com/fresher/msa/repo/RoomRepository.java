package com.fresher.msa.repo;


import com.fresher.msa.entities.RoomHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomHotel,Long> {

    @Query(value = "select * from rooms where status=false", nativeQuery = true)
    List<RoomHotel> getAllEmptyRoom();

    @Query(value = "select * from rooms where status=true", nativeQuery = true)
    List<RoomHotel> getAllRoomRent();
}
