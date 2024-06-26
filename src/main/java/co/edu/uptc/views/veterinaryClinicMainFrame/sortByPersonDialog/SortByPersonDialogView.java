package co.edu.uptc.views.veterinaryClinicMainFrame.sortByPersonDialog;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;
@Getter
public class SortByPersonDialogView extends JDialog {
    private VeterinaryClinicView veterinaryClinicView;
    private SortByPersonDialogBody sortByPersonDialogBody;
    private SortByPersonDialogFooter sortByPersonDialogFooter;
    private PropertiesService propertiesService;

    public SortByPersonDialogView(VeterinaryClinicView veterinaryClinicView) {
        super(veterinaryClinicView, true);
        this.veterinaryClinicView = veterinaryClinicView;
        propertiesService = new PropertiesService();
        this.initDialog();
        this.createMainHeader();
        this.createMainBody();
        this.createMainFooter();
    }

    public void begin() {
        loadPeopleData();
        this.setVisible(true);
    }

    private void loadPeopleData(){
        ArrayList<Person> persons = veterinaryClinicView.getPresenter().getPersons();
        for (Person person : persons) {
            sortByPersonDialogBody.addPerson(person);
        }
    }

    private void initDialog(){
        this.setLayout(new BorderLayout());
        this.setSize(800,500);
        this.setTitle("Filtrar por Persona");
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void createMainHeader(){
        SortByPersonDialogHeader sortByPersonDialogHeader = new SortByPersonDialogHeader();
        this.add(sortByPersonDialogHeader, BorderLayout.NORTH);
    }

    private void createMainBody(){
        sortByPersonDialogBody = new SortByPersonDialogBody(this);
        this.add(sortByPersonDialogBody);
    }

    private void createMainFooter(){
        sortByPersonDialogFooter = new SortByPersonDialogFooter(this);
        this.add(sortByPersonDialogFooter,BorderLayout.SOUTH);
    }
}
