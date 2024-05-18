package co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class VaccineInventoryHeader extends JPanel{
  private ImageIcon imageIcon;
  private PropertiesService propertiesService;

    public VaccineInventoryHeader(){
        propertiesService = new PropertiesService();
        initPanel();
        this.addImageIcon();
        this.addTitleLabel();
        this.addVaccineInventaryTitle();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(0,236));
        this.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
        this.setLayout(null);
    }

    private void addTitleLabel(){
        JLabel titleLabel = new JLabel("<html>Clinica<br/>Veterinaria</html>");
        titleLabel.setFont( new Font("Semi_Bold", 1, 40));;
        Dimension titleDimension = titleLabel.getPreferredSize();
        titleLabel.setBounds(62,55, (int)titleDimension.getWidth(), (int)titleDimension.getHeight());
        this.add(titleLabel);
    }

    private void addVaccineInventaryTitle(){
        RoundedButton vaccineInventaryTitle = new RoundedButton("Inventario de Vacunas", 20);
        vaccineInventaryTitle.setBounds(300, 78, 826, 80);
        vaccineInventaryTitle.setFont( new Font("Semi_Bold", 1, 40));;
        vaccineInventaryTitle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        ImageIcon vaccineIcon = new ImageIcon(propertiesService.getKeyValue("VaccineIconPath"));
        vaccineInventaryTitle.setIcon(vaccineIcon);
        vaccineInventaryTitle.setContentAreaFilled(false);
        this.add(vaccineInventaryTitle);
    }

    private void addImageIcon(){
        imageIcon = new ImageIcon(propertiesService.getKeyValue("LogoPath"));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imageIcon != null) {
            Image image = imageIcon.getImage();
            g.drawImage(image, 1140, 25, 211, 211, this);
        }
    }
}