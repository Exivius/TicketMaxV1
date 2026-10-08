package app.ui;

import app.service.validators.DataTypeValidator;
import app.view.SeatView;
import app.view.UserView;
//import app.view.UserView;

public class CliUserInterface {



    private final UserView userView;
    //21. Se inyecta la dependencia de la vista en la interface
    private final SeatView seatView;

    //22 se actualizan los parametros del constructor para inyectar la dependencia de la vista
    // y el 23 sigue en la clase Config
    public CliUserInterface(UserView userView, SeatView seatView) {
        this.seatView = seatView;
        this.userView = userView;
    }

    public void applicationInit(){

        System.out.println("Bienvenido TicketMax V1");

        int init = DataTypeValidator.validateInt("Presione 1 para iniciar la aplicación");

        while(init != 0){
            mainMenu();
            init = 0;
        }
    }

    public void mainMenu() {
        int option;
        do {
            option = DataTypeValidator.validateInt("""
                    Seleccione:
                    1. Menu de usuarios
                    2. Menu de asientos
                    3. Salir
                    """);
            switch (option) {
                case 1:
                    userMenu();
                    break;
                case 2:
                    seatMenu();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación");
                    break;
                default:
                    System.out.println("Seleccione una opción valida");
            }
        } while (option != 3);
    }

    public void userMenu(){
        int option;
        do {
            option = DataTypeValidator.validateInt("""
                    Menu de usuarios:
                    1. Registrar usuario
                    2. Consultar usuario por id
                    3. Consultar todos los usuarios
                    4. Actualizar usuario
                    5. Eliminar usuario
                    6. Consultar numero de usuarios
                    7. Volver al menu principal
                    """);
            switch (option){
                case 1:
                    userView.createUser();
                    break;
                case 2:
                    userView.selectById(DataTypeValidator.validateInt("Ingrese el id del usuario a consultar"));
                    break;
                case 3:
                    userView.selectUsers();
                    break;
                case 4:
                    userView.update();
                    break;
                case 5:
                    userView.delete(DataTypeValidator.validateInt("Ingrese el id del usuario a eliminar"));
                    break;
                case 6:
                    userView.countUsers();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
            }
        } while (option != 7);
    }

    public void seatMenu() {
        int option;
        do {
            option = DataTypeValidator.validateInt("""
                    Menu de asientos:
                    1. Registrar asiento
                    2. Consultar asiento por id
                    3. Consultar todos los asientos
                    4. Actualizar asiento
                    5. Eliminar asiento
                    6. Volver al menu principal
                    """);
            switch (option) {
                case 1:
                    seatView.createSeat();
                    break;
                case 2:
                    seatView.selectSeatById(DataTypeValidator.validateInt("Ingrese el id del asiento a consultar"));
                    break;
                case 3:
                    seatView.selectAllSeats();
                    break;
                case 4:
                    seatView.updateSeat();
                    break;
                case 5:
                    seatView.deleteSeat(DataTypeValidator.validateInt("Ingrese el id del asiento a eliminar"));
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
            }
        } while (option != 6);
    }
}
