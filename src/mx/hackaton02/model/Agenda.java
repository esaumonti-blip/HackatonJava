package mx.hackaton02.model;

import java.util.Map;
import java.util.TreeMap;

public class Agenda {

    private final int LIMIT;
    private TreeMap<String, String> contacts = new TreeMap<>();

    public Agenda(int limit) {
        this.LIMIT = limit;
    }

    public boolean add(String name, String number) {
        if (contacts.size() >= LIMIT) return false;
        contacts.put(name, number);
        return true;
    }

    public boolean remove(String name) {
        return contacts.remove(name) != null;
    }

    public boolean exists(String name) {
        return contacts.containsKey(name);
    }

    public boolean numberExists(String number) {
        return contacts.containsValue(number);
    }

    public String get(String name) {
        return contacts.get(name);
    }

    public boolean isFull() {
        return contacts.size() == LIMIT;
    }

    public int remainingSpaces() {
        return LIMIT - contacts.size();
    }

    public Map<String, String> getAll() {
        return contacts;
    }
}
