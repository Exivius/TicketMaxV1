package app.repository.mappers;

import app.domain.Seat;
import app.service.outputPorts.SeatRepositoryPort;

import java.util.ArrayList;
import java.util.List;
//14 Se realiza la implementacion de la interfaz SeatRepositoryPort en la clase SeatRepositoryAdapter
public class SeatRepositoryAdapter implements SeatRepositoryPort {

    //16 Se crea una lista de asientos para simular la base de datos
    List<Seat> seats = new ArrayList<>();

    //17 Sigue en la clase SeatView

    //15 Se implementan los metodos de la interfaz SeatRepositoryPort en la clase SeatRepositoryAdapter
    @Override
    public Seat save(Seat seat) {
        //25 Se agrega el asiento a la lista de asientos. 26 continua en SeatView.
        seats.add(seat);
        return seat;
    }

    @Override
    public Seat selectById(int id) {
        for (Seat seat : seats) {
            if (seat.getSeatId() != null && seat.getSeatId() == id) {
                return seat;
            }
        }
        return null;
    }

    @Override
    public List<Seat> selectAllSeats() {
        return seats;
    }

    @Override
    public Seat updateSeat(Seat seat) {
        for (int index = 0; index < seats.size(); index++) {
            Seat currentSeat = seats.get(index);
            if (currentSeat.getSeatId() != null && currentSeat.getSeatId().equals(seat.getSeatId())) {
                seats.set(index, seat);
                return seat;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        seats.removeIf(seat -> seat.getSeatId() != null && seat.getSeatId() == id);
    }
}
