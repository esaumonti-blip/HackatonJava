package mx.hackaton02.service;

import mx.hackaton02.model.Agenda;
import javax.swing.*;

public class ContactExistence {

    public void checkOrCreate(Agenda agenda, String name) {
        if (agenda.exists(name)) {
            JOptionPane.showMessageDialog(null,
                    "Contacto encontrado:\n" +
                            name + " - " + agenda.get(name));
        } else {
            int option = JOptionPane.showConfirmDialog(null,
                    "El contacto no existe.\n¿Deseas crearlo?",
                    "Contacto no encontrado",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION && !agenda.isFull()) {
                String number = JOptionPane.showInputDialog("Ingresa el número:");
                agenda.add(name, number);
            }
        }
    }
}
