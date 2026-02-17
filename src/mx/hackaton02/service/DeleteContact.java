package mx.hackaton02.service;

import mx.hackaton02.model.Agenda;
import javax.swing.*;

public class DeleteContact {

    public void delete(Agenda agenda, String name) {
        if (agenda.remove(name)) {
            JOptionPane.showMessageDialog(null,
                    "Contacto eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "El contacto no existe.");
        }
    }
}
