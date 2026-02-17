package mx.hackaton02.service;

import mx.hackaton02.model.Agenda;
import mx.hackaton02.ui.ContactManagerUI;

import javax.swing.*;

public class SearchContact {

    public String search(Agenda agenda, String name) {
        String number = null;
        if (agenda.exists(name)) {
            return "Contacto encontrado:\nNombre: " + name +
                    "\nNúmero: " + agenda.get(name);

        } else {
            int option = JOptionPane.showConfirmDialog(null,
                    "El contacto no existe.\n¿Deseas crearlo?",
                    "Contacto no encontrado",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION && !agenda.isFull()) {
                number = JOptionPane.showInputDialog("Ingresa el número:");
                agenda.add(name, number);
                String message = """
                Se agregó el siguiente contacto de manera satisfactoria:
                Nombre: %s
                Número: %s
                """.formatted(name, number);
                return message;
            }

        }
        return agenda.get(number);


    }
}
