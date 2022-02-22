package org.smart.board.service;

import org.smart.board.dao.ReservationDao;
import org.smart.board.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationImpl implements ReservationService {
    @Autowired
    ReservationDao reservationDao;

    @Override
    public int rvWrite(Reservation reservation) {
        System.out.println("서비스 임플까진 왔다" + reservation);
        return reservationDao.rvWrite(reservation);
    }
}
