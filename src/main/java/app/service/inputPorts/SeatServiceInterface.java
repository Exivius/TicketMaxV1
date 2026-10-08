package app.service.inputPorts;

import app.domain.Seat;

import java.util.List;

public interface SeatServiceInterface {
    //1. Creamos el motodo y traemos los parametros que tiene el conctructor en la clase Seat
    //2 sigue en seatView
    Seat createSeat(Integer seatId, String seatNumber, String seatSector, String isAvailable);
    //3.
    public Seat selectSeatById(int id);
    //4
    public List<Seat> selectAllSeats();
    //5
    public Seat updateSeat(Integer seatId, String seatNumber, String seatSector, String isAvailable);
    //6
    public void deleteSeat(int id);
    //7 esta en SeatRepositoryPort
}
