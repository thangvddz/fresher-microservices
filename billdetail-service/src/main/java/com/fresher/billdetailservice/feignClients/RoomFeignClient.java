package com.fresher.billdetailservice.feignClients;

import com.fresher.billdetailservice.response.RoomResponse;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${room.service.url}", value = "room-service-client",
path = "/api/rooms")
public interface RoomFeignClient {
    @GetMapping("/findByID/{id}")
    public RoomResponse getByIdRoom(@PathVariable(name = "id") Long id);
}
