package mx.hackaton02.ui;

import mx.hackaton02.model.Agenda;
import mx.hackaton02.service.*;
import mx.hackaton02.ui.WelcomeScreen;

import javax.swing.*;
import java.awt.*;

public class ContactManagerUI extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Iniciamos con la pantalla de bienvenida
            new WelcomeScreen().setVisible(true);
        });
    }


    private Agenda agenda;
    private JTextField nameField, numberField;
    private static JTextArea display;

    public ContactManagerUI(int size) {
        this.agenda = new Agenda(size);
        setTitle("Agenda de Contactos");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        nameField = new JTextField(10);
        numberField = new JTextField(10);
        top.add(new JLabel("Nombre:"));
        top.add(nameField);
        top.add(new JLabel("Número:"));
        top.add(numberField);
        add(top, BorderLayout.NORTH);

        display = new JTextArea();
        display.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(display), BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton add = new JButton("Agregar");
        JButton list = new JButton("Listar");
        JButton search = new JButton("Buscar");
        JButton delete = new JButton("Eliminar");

        buttons.add(add);
        buttons.add(list);
        buttons.add(search);
        buttons.add(delete);
        add(buttons, BorderLayout.SOUTH);

        AddContact addService = new AddContact();
        ListContact listService = new ListContact();
        SearchContact searchService = new SearchContact();
        DeleteContact deleteService = new DeleteContact();

        add.addActionListener(e -> {
                addService.addContact(agenda, nameField.getText(), numberField.getText());
                clearNameField();
                clearNumberField();
        });

        list.addActionListener(e -> {
                display.setText(listService.listContacts(agenda));
                clearNameField();
                clearNumberField();
        });

        search.addActionListener(e -> {
                display.setText(searchService.search(agenda, nameField.getText()));
                clearNameField();
                clearNumberField();
        });

        delete.addActionListener(e -> {
                deleteService.delete(agenda, nameField.getText());
                clearNameField();
                clearNumberField();
        });
    }

    public static void displayText(String message){
        display.setText(message);
    }

    private void clearNameField(){
        numberField.setText("");
    }

    private void clearNumberField(){
        nameField.setText("");
    }
}
