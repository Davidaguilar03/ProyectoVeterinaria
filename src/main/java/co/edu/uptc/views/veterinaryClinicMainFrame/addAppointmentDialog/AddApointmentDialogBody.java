package co.edu.uptc.views.veterinaryClinicMainFrame.addAppointmentDialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.CenterTableCellRenderer;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

public class AddApointmentDialogBody extends JPanel {
    private VeterinaryClinicView veterinaryClinicView;
    private DefaultTableModel peopleTableModel;
    private JTable peopleDataBaseTable;
    private DefaultTableModel petDataBaseTableModel;
    private JTable petDataBaseTable;
    private DefaultTableModel vaccineTableModel;
    private JTable vaccinesTable;

    public AddApointmentDialogBody(VeterinaryClinicView veterinaryClinicView) {
        this.veterinaryClinicView = veterinaryClinicView;
        this.initPanel();
        this.addPeopleTableHeader();
        this.addPeopleDataBaseTable();
        this.addPetTableHeader();
        this.addPetDataBaseTable();
        this.addVaccineTableHeader();
        this.addVaccinesTable();
    }

    public void initPanel() {
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addPeopleTableHeader() {
        JLabel headerLabel = new JLabel("Registro de Personas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(310, 20, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addPeopleDataBaseTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(10, 10, 765, 150);
        tablePanel.setLayout(null);
        String[] columnNames = {
                "ID.Persona", "Nombre", "Edad", "Tipo de Documento", "Numero de Documento"
        };
        peopleTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        peopleDataBaseTable = new JTable(peopleTableModel);
        peopleDataBaseTable.setFillsViewportHeight(true);
        peopleDataBaseTable.getTableHeader().setReorderingAllowed(false);
        peopleDataBaseTable.getTableHeader().setResizingAllowed(false);
        peopleDataBaseTable.setDragEnabled(false);
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        for (int i = 0; i < peopleDataBaseTable
                .getColumnCount(); i++) {
            peopleDataBaseTable
                    .getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        JScrollPane scrollPane = new JScrollPane(peopleDataBaseTable);
        scrollPane.setBounds(20, 40, 725, 100);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    private void addPetTableHeader() {
        JLabel headerLabel = new JLabel("Registro de Mascotas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(310, 190, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addPetDataBaseTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(10, 180, 765, 150);
        tablePanel.setLayout(null);
        String[] columnNames = {
                "ID.Mascota", "Nombre", "Especie", "Edad", "Raza", "Dueño"
        };
        petDataBaseTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        petDataBaseTable = new JTable(petDataBaseTableModel);
        petDataBaseTable.setFillsViewportHeight(true);
        petDataBaseTable.getTableHeader().setReorderingAllowed(false);
        petDataBaseTable.getTableHeader().setResizingAllowed(false);
        petDataBaseTable.setDragEnabled(false);
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        for (int i = 0; i < petDataBaseTable
                .getColumnCount(); i++) {
            petDataBaseTable
                    .getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        JScrollPane scrollPane = new JScrollPane(petDataBaseTable);
        scrollPane.setBounds(20, 40, 725, 100);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    private void addVaccineTableHeader() {
        JLabel headerLabel = new JLabel("Inventario de Vacunas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(310, 360, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addVaccinesTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(10, 350, 765, 170);
        tablePanel.setLayout(null);
        String[] columnNames = {
                "ID.Vacuna", "Nombre", "Duracion(Dias)"
        };
        vaccineTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        vaccinesTable = new JTable(vaccineTableModel);
        vaccinesTable.setFillsViewportHeight(true);
        vaccinesTable.getTableHeader().setReorderingAllowed(false);
        vaccinesTable.getTableHeader().setResizingAllowed(false);
        vaccinesTable.setDragEnabled(false);
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        for (int i = 0; i < vaccinesTable
                .getColumnCount(); i++) {
            vaccinesTable
                    .getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        JScrollPane scrollPane = new JScrollPane(vaccinesTable);
        scrollPane.setBounds(20, 40, 725, 120);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    public Person searchPersonByid(int id) {
        return veterinaryClinicView.getPresenter().searchPersonById(id);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }

}
