    package app.view;

    import app.service.helpers.SetSeatStateHelper;
    import app.service.inputPorts.SeatServiceInterface;
    import app.service.validators.DataTypeValidator;

    public class SeatView {
        //17. Se inyecta la dependencia del servicio en la vista
        private final SeatServiceInterface seatServiceInterface;
        //18. Se inicializa el atributo
        public SeatView(SeatServiceInterface seatServiceInterface) {
            this.seatServiceInterface = seatServiceInterface;
        }
        //19. Continua en SeatServiceAdapter

        //2. Quitalos los metodos de la clase Seat y los movemos a View
        //3 sigue en SeatServiceInterface
        public void createSeat(){
            //26. Se solicitan los datos del asiento al usuario y se validan los tipos de datos
            int id = DataTypeValidator.validateInt("Ingrese el id del asiento");
            String seatNumber = DataTypeValidator.validateString("Ingrese el numero del asiento");
            String seatSector = DataTypeValidator.validateString("Ingrese el sector del asiento");
            //27. Se crea el SelectStateEnum para validar si el asiento esta disponible o no
            //30. Llamamos al metodo getSeatState de la clase SetSeatStateHelper para obtener el estado del asiento
            String seatState = SetSeatStateHelper.getSeatState();

            //31. Llamamos al metodo createSeat del servicio para crear el asiento con los datos ingresados por el usuario
            seatServiceInterface.createSeat(id, seatNumber, seatSector, seatState);
        }

        public void selectAllSeats(){
            for (var seat : seatServiceInterface.selectAllSeats()) {
                System.out.println(seat.getSeatId() + " " + seat.getSeatNumber() + " "
                        + seat.getSeatSector() + " " + seat.isAvailable());
            }
        }

        public void selectSeatById(int id){
            var seat = seatServiceInterface.selectSeatById(id);
            if (seat == null) {
                System.out.println("No se encontró un asiento con ese id");
                return;
            }
            System.out.println(seat.getSeatId() + " " + seat.getSeatNumber() + " "
                    + seat.getSeatSector() + " " + seat.isAvailable());
        }

        public void updateSeat(){
            int id = DataTypeValidator.validateInt("Ingrese el id del asiento a actualizar");
            if (seatServiceInterface.selectSeatById(id) == null) {
                System.out.println("No se encontró un asiento con ese id");
                return;
            }
            String number = DataTypeValidator.validateString("Ingrese el numero del asiento");
            String sector = DataTypeValidator.validateString("Ingrese el sector del asiento");
            String state = SetSeatStateHelper.getSeatState();
            seatServiceInterface.updateSeat(id, number, sector, state);
        }

        public void deleteSeat(int id){
            seatServiceInterface.deleteSeat(id);
        }
}
