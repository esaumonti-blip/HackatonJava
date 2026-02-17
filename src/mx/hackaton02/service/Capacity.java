package mx.hackaton02.service;

import mx.hackaton02.model.Agenda;

public class Capacity {

    public static String remaining(Agenda agenda, int size) {
        return "Contactos: " + agenda.remainingSpaces()+"/"+size;
    }
}
