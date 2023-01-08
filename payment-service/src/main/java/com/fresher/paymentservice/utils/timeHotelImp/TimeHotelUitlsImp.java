package com.fresher.paymentservice.utils.timeHotelImp;

import com.fresher.paymentservice.utils.TimeHotelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class TimeHotelUitlsImp implements TimeHotelUtils {
    @Override
    public Date timeInHotel(Date checkIn, Date checkOut) {
//        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.getDefault());

        long diffInMillies = Math.abs(checkOut.getTime() - checkIn.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.DAYS);
        log.info("diff: {}", diff);
        return null;
    }
}
