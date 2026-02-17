package mx.hackaton02.service;

import mx.hackaton02.model.Agenda;

public class SearchContact {

    public String search(Agenda agenda, String name) {
        if (agenda.exists(name)) {
            return "Contacto encontrado:\nNombre: " + name +
                    "\nNúmero: " + agenda.get(name);
        }
        return "Contacto no encontrado.";

    }
}
