package app.view;

import app.domain.User;
import app.domain.enums.SelectPreferencesEnum;
import app.service.helpers.SetUserState;
import app.service.inputPorts.UserService;
import app.service.validators.DataTypeValidator;

import java.util.ArrayList;
import java.util.List;

public class UserView {


    private final UserService userService;

    public UserView(UserService userService){
        this.userService = userService;
    }

    public void createUser() {


        int id = DataTypeValidator.validateInt("Ingrese el id del usuario: ");
        String name = DataTypeValidator.validateString("Ingrese el nombre del usuario: ");
        String lastName = DataTypeValidator.validateString("Ingrese el apellido del usuario: ");
        String email = DataTypeValidator.validateString("Ingrese el correo del usuario: ");
        String phone = DataTypeValidator.validateString("Ingrese el telefono del usuario: ");
        //  System.out.println("Ingrese la contraseña del usuario: ");
        String password = DataTypeValidator.validateString("Ingrese la contraseña del usuario: ");
        System.out.println("Ingrese el estado del usuario: ");
        String state = SetUserState.getUserState();
        System.out.println();
        String city = DataTypeValidator.validateString("Ingrese la ciudad del usuario: ");
        System.out.println("Ingrese las preferencias del usuario: ");
        String preferences = setUserPreferences();

        userService.create(id, name , lastName , email , phone , password , state, city, preferences);

    }


    public void selectById(int id) {
        userService.selectById(id);
    }


    public void selectUsers(){

        userService.selectUsers();

    }


    public void update() {
        int id = DataTypeValidator.validateInt("Ingrese el id del usuario a actualizar: ");
        User currentUser = userService.selectUserById(id);
        if (currentUser == null) {
            System.out.println("No se encontró un usuario con ese id");
            return;
        }
        String name = DataTypeValidator.validateString("Ingrese el nombre del usuario: ");
        String lastName = DataTypeValidator.validateString("Ingrese el apellido del usuario: ");
        String email = DataTypeValidator.validateString("Ingrese el correo del usuario: ");
        String phone = DataTypeValidator.validateString("Ingrese el telefono del usuario: ");
        String password = DataTypeValidator.validateString("Ingrese la contraseña del usuario: ");
        String state = SetUserState.getUserState();
        String city = DataTypeValidator.validateString("Ingrese la ciudad del usuario: ");
        String preferences = setUserPreferences();
        User updatedUser = new User(id, name, lastName, email, phone, password, state, city, preferences);
        if (userService.updateUser(updatedUser) == null) {
            System.out.println("No se pudo actualizar el usuario");
        }
    }

    public void delete(int id) {
        userService.deleteUser(id);
    }

    public void countUsers() {
        System.out.println("Numero de usuarios: " + userService.countUsers());
    }

    // métodos Helper




    public String setUserPreferences(){


        int option = DataTypeValidator.validateInt("Seleccione 1. VIP 2. General 3. Preferencial");
        String preferences = "";

        switch (option){

            case 1:
                preferences = SelectPreferencesEnum.VIP.getPreference();
                break;
            case 2:
                preferences = SelectPreferencesEnum.GENERAL.getPreference();
                break;
            case 3:
                preferences = SelectPreferencesEnum.PREFERENCIAL.getPreference();
                break;
            default:
                System.out.println("Opción no valida");

        }
        return preferences;
    }








}
