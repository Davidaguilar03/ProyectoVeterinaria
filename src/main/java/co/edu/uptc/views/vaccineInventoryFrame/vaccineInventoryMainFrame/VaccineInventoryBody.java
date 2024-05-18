package co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.utilities.CenterTableCellRenderer;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

public class VaccineInventoryBody extends JPanel {
    private VeterinaryClinicView veterinaryClinicView;
    private DefaultTableModel tableModel;
    private JTable vaccinesTable;

    public VaccineInventoryBody(VeterinaryClinicView veterinaryClinicView) {
        this.veterinaryClinicView = veterinaryClinicView;
        this.initPanel();
        this.addTableHeader();
        this.addVaccinesTable();
    }

    private void initPanel() {
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
        this.setLayout(null);
    }

    private void addTableHeader() {
        JLabel headerLabel = new JLabel("Inventario de Vacunas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(445, 30, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addVaccinesTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        tablePanel.setBounds(15, 20, 1015, 455);
        tablePanel.setLayout(null);
        String[] columnNames = {
                "ID.Vacuna", "Nombre", "Duracion(Dias)"
        };
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        vaccinesTable = new JTable(tableModel);
        vaccinesTable
                .setFillsViewportHeight(true);
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        for (int i = 0; i < vaccinesTable
                .getColumnCount(); i++) {
            vaccinesTable
                    .getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        JScrollPane scrollPane = new JScrollPane(vaccinesTable);
        scrollPane.setBounds(24, 40, 970, 400);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    public void addVaccine(Vaccine vaccine) {
        Object[] vaccineData = {vaccine.getId(),vaccine.getName(),vaccine.getShelfLife()};
        tableModel.addRow(vaccineData);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }
}