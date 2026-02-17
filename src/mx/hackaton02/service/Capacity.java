package mx.hackaton02.service;

import mx.hackaton02.model.Agenda;

public class Capacity {

    public String remaining(Agenda agenda) {
        return "Espacios disponibles: " + agenda.remainingSpaces();
    }
}
