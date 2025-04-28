package View.Support;

import Controller.TicketController;
import Model.DB.DBError;
import Model.Support.Ticket;
import View.MainMenuView;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TicketListView extends JFrame {
    private JPanel panel1;
    private JButton openTicketButton;
    private JScrollPane ticketPane;
    private JTable ticketTable;
    private JButton backToMenuButton;
    private JCheckBox archivedCheckBox;
    private JButton createTicketButton;
    private final TicketController controller;


    public TicketListView(TicketController ticketController) {
        this.controller = ticketController;
        this.add(panel1);
        this.setTitle("Tickets: " + controller.getActiveUser().getUserID());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
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
            if (ticketTable.getSelectedRowCount() == 1) {
                int selected = ticketTable.getSelectedRow();
                if (selected == -1) {
                    JOptionPane.showMessageDialog(this, "No ticket selected");
                    return;
                }
                Ticket val;
                if (archivedCheckBox.isSelected()) {
                    val = controller.getArchive().get(ticketTable.getSelectedRow());
                } else {
                    val = controller.getTickets().get(ticketTable.getSelectedRow());
                }
                controller.setActiveTicket(val);
                this.dispose();
                new SupportTicketView(controller);
            }
        });
        backToMenuButton.addActionListener((e) -> {
            this.dispose();
            new MainMenuView(this.controller.getActiveUser());
        });
        archivedCheckBox.addActionListener((e) -> {
            if (archivedCheckBox.isSelected()) {
                this.ticketTable.setModel(new TicketTable(controller.getArchive()));
            } else {
                this.ticketTable.setModel(new TicketTable(controller.getTickets()));
            }
            ticketTable.repaint();
        });
        createTicketButton.addActionListener((e) -> {
            String subject = JOptionPane.showInputDialog("What is the subject of the ticket?");
            Ticket.TicketBuilder tb = new Ticket.TicketBuilder();
            tb.setSubject(subject);
            tb.setUser(controller.getActiveUser());
            Ticket t = tb.build();
            try {
                this.controller.createTicket(t, null);
                new SupportTicketView(controller);
                this.dispose();
            } catch (DBError ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
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
                case 2 -> {
                    if (ticketList.get(rowIndex).getSupportUser() != null) {
                        yield ticketList.get(rowIndex).getSupportUser().getUserName();
                    } else {
                        yield "";
                    }
                }
                case 3 -> {
                    if (ticketList.get(rowIndex).getUser() != null) {
                        yield ticketList.get(rowIndex).getUser().getUserName();
                    } else {
                        yield "User deleted";
                    }
                }
                default -> null;
            };
        }

        @Override
        public String getColumnName(int col){
            return columnNames[col];
        }
    }
}
