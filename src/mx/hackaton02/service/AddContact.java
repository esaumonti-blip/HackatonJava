package mx.hackaton02.service;

import mx.hackaton02.model.Agenda;
import javax.swing.*;

public class AddContact {

    public void addContact(Agenda agenda, String name, String number) {
        if (agenda.isFull()) {
            JOptionPane.showMessageDialog(null,
                    "No se pueden agregar más contactos.\nLa agenda está llena.");
            return;
        }

        if (agenda.exists(name) || agenda.numberExists(number)) {
            JOptionPane.showMessageDialog(null,
                    "El contacto o el número ya existen.");
            return;
        }

        agenda.add(name, number);
        JOptionPane.showMessageDialog(null, "Contacto agregado correctamente.");
    }
}
