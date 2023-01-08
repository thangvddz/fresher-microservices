package com.fresher.billservice.utils.timeHotelImp;

import com.fresher.billservice.utils.TimeHotelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class TimeHotelUitlsImp implements TimeHotelUtils {
    @Override
    public Date timeInHotel(Date checkIn, Date checkOut) {
//        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.getDefault());
        log.info("check in: {}", checkIn);
        log.info("check out: {}", checkOut);
        long diffInMillies = checkOut.getDate() - checkIn.getDate();
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.DAYS);
        log.info("diff: {}", diff);
        return null;
    }
}
