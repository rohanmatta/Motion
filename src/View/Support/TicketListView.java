package View.Support;

import Controller.TicketController;
import Model.Support.Ticket;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TicketListView extends JFrame {
    private JPanel panel1;
    private JButton openTicketButton;
    private JScrollPane ticketPane;
    private JTable ticketTable;
    private final TicketController controller;


    public TicketListView(TicketController ticketController) {
        this.controller = ticketController;
        this.add(panel1);
        this.setTitle("Tickets: " + controller.getActiveUser().getUserID());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 1000);
        addActionListeners();
        addTickets();
        this.setVisible(true);
    }

    private void addTickets() {
        TicketTable tableValues = new TicketTable(controller.getTickets());
        ticketTable.setModel(tableValues);
    }

    private void addActionListeners() {
        openTicketButton.addActionListener((e) -> {
            // Get selected ticket id
            // set active ticket
            // dispose current view
            // open new TicketView
            if (ticketTable.getSelectedRowCount() == 1) {
                int selected = ticketTable.getSelectedRow();
                Ticket val = controller.getTickets().stream().filter(t -> t.getTicketId() == (long) ticketTable.getValueAt(selected, 0)).findFirst().orElseThrow();
                controller.setActiveTicket(val);
                this.dispose();
                new SupportTicketView(controller);
            }
        });
    }

    static class TicketTable extends AbstractTableModel {
        private final String[] columnNames = {"ID", "Subject", "Support User", "User"};
        private final List<Ticket> ticketList;

        public TicketTable(List<Ticket> ticketList){
            this.ticketList = ticketList;
        }

        @Override
        public int getRowCount() {
            return ticketList.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> ticketList.get(rowIndex).getTicketId();
                case 1 -> ticketList.get(rowIndex).getSubject();
                case 2 -> ticketList.get(rowIndex).getSupportUser().getUserName();
                case 3 -> ticketList.get(rowIndex).getUser().getUserName();
                default -> null;
            };
        }

        @Override
        public String getColumnName(int col){
            return columnNames[col];
        }
    }
}
