package mx.hackaton02.service;

import mx.hackaton02.model.Agenda;
import java.util.Map;

public class ListContact {

    public String listContacts(Agenda agenda) {
        if (agenda.getAll().isEmpty()) {
            return "(Agenda vacía)";
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : agenda.getAll().entrySet()) {
            sb.append(String.format("Nombre: %-12s | Número: %-10s \n", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
