package com.fresher.billservice.feignClients;

import com.fresher.billservice.response.RoomResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "roomhotel-service",
path = "/api/rooms")
public interface RoomFeignClient {
    @GetMapping("/findByID/{id}")
    RoomResponse getByIdRoom(@PathVariable(name = "id") Long id);

    //when check in then set room is true
    @GetMapping("/setStatusInActive")
    void setStatusRoomInactive(@RequestParam(name = "id") Long id);

    //when check out then set room is false
    @GetMapping("/setStatusActive")
    void setStatusRoomActive(@RequestParam(name = "id") Long id);
}
