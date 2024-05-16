package co.edu.uptc.views.vaccineInventoryFrame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.resources.Global;

public class vaccineInventoryAside extends JPanel{

    public vaccineInventoryAside(){
        initPanel();
    }

    private void initPanel(){
        this.setBackground(Global.ASIDE_BACKGROUND);
        this.setForeground(Global.ASIDE_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(298,0));
        this.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Color.black));
    }
}
