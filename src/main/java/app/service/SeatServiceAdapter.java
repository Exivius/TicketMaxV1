package app.service;

import app.domain.Seat;
import app.service.inputPorts.SeatServiceInterface;
import app.service.outputPorts.SeatRepositoryPort;

import java.util.List;

//12. Se implementa la interfaz SeatServiceInterface en la clase SeatServiceAdapter
public class SeatServiceAdapter implements SeatServiceInterface {

    //19 Se inyecta la dependencia del repositorio en el servicio
    private final SeatRepositoryPort seatRepositoryPort;
    //20 Se inicializa el atributo. 21 Sigue en CliUserInterface.
    public SeatServiceAdapter(SeatRepositoryPort seatRepositoryPort) {
        this.seatRepositoryPort = seatRepositoryPort;
    }

    //13. Se implementan los metodos de la interfaz SeatServiceInterface en la clase SeatServiceAdapter
    @Override
    public Seat createSeat(Integer seatId, String seatNumber, String seatSector, String isAvailable) {
        //24 Se crea un objeto Seat con los parametros recibidos y se retorna el resultado
        // del metodo save del repositorio. 25 Continua en SeatRepositoryAdapter.
        Seat seat = new Seat(seatId, seatNumber, seatSector, isAvailable);
        return seatRepositoryPort.save(seat);
    }

    @Override
    public Seat selectSeatById(int id) {
        return seatRepositoryPort.selectById(id);
    }

    @Override
    public List<Seat> selectAllSeats() {
        return seatRepositoryPort.selectAllSeats();
    }

    @Override
    public Seat updateSeat(Integer seatId, String seatNumber, String seatSector, String isAvailable) {
        Seat seat = new Seat(seatId, seatNumber, seatSector, isAvailable);
        return seatRepositoryPort.updateSeat(seat);
    }

    @Override
    public void deleteSeat(int id) {
        seatRepositoryPort.deleteById(id);
    }
    //14. Se implementan los metodos de la interfaz SeatRepositoryPort en la clase SeatRepositoryAdapter
}
