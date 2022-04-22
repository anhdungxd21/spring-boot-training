package com.faceless.springboot.util;

import com.faceless.springboot.business.ReservationService;
import com.faceless.springboot.business.RoomReservation;
import com.faceless.springboot.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Lắng nghe sự kiện của Spring - ApplicationListener<ApplicationReadyEvent>
 *     Class này đản bảo spring hoàn thành việc building rồi mới khởi chạy
 */
@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final ReservationService reservationService;
    private final DateUtil dateUtil;

    public AppStartupEvent(ReservationService reservationService, DateUtil dateUtil) {
        this.reservationService = reservationService;
        this.dateUtil = dateUtil;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
//        Date date = this.dateUtil.createDateFormatDateString("2022-01-01");
//        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
//        reservations.forEach(System.out::println);
//        System.out.println(reservationService.getClass().getSimpleName());
    }
}
