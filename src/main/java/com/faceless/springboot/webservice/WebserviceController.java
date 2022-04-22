package com.faceless.springboot.webservice;

import com.faceless.springboot.business.ReservationService;
import com.faceless.springboot.business.RoomReservation;
import com.faceless.springboot.data.Guest;
import com.faceless.springboot.data.Room;
import com.faceless.springboot.util.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {

    private final DateUtil dateUtil;
    private final ReservationService reservationService;

    public WebserviceController(DateUtil dateUtil, ReservationService reservationService) {
        this.dateUtil = dateUtil;
        this.reservationService = reservationService;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservation(@RequestParam(value = "date", required = false)String dateString, Model model) {
        Date date = this.dateUtil.createDateFormatDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(value = "/guest", method = RequestMethod.GET)
    public List<Guest> getHotelGuest() {
        return this.reservationService.getHotelGuests();
    }
    @RequestMapping(value = "/guest", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void getHotelGuest(@RequestBody Guest guest) {
        this.reservationService.addGuest(guest);
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> getHotelRoom() {
        return this.reservationService.getHotelRooms();
    }

}
