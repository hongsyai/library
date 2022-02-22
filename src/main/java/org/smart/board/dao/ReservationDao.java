package org.smart.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.smart.board.entity.Reservation;

@Mapper
public interface ReservationDao {
    public int rvWrite(Reservation reservation);
}
