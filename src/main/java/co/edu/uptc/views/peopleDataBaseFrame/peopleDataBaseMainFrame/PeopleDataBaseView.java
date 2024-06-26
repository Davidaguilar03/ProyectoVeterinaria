package co.edu.uptc.views.peopleDataBaseFrame.peopleDataBaseMainFrame;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;

@Getter
public class PeopleDataBaseView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private PeopleDataBaseBody peopleDataBaseBody;
    private PropertiesService propertiesService;
    private PeopleDataBaseAside peopleDataBaseAside;

    public PeopleDataBaseView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView,true);
        this.veterinaryClinicView=veterinaryClinicView;
        propertiesService = new PropertiesService();
        this.initFrame();
        this.createPeopleDataBaseHeader();
        this.createPeopleDataBaseAside();
        this.createPeopleDataBaseBody();
    }
    public void begin(){
        this.loadPeopleData();
        this.setVisible(true);
    }

    private void initFrame(){
        this.setTitle("Registro de Personas");
        this.setLayout(new BorderLayout());
        this.setSize(1366,768);
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    public void loadPeopleData(){
        ArrayList<Person> persons = veterinaryClinicView.getPresenter().getPersons();
        peopleDataBaseBody.cleanTable();
        for (Person person : persons) {
            peopleDataBaseBody.addPerson(person);
        }
    }

    public void setPersonStatus(Person person) {
        if (person != null) {
            peopleDataBaseAside.enableDeletePersonBtn(true);
            peopleDataBaseAside.enableEditPersonBtn(true);
        }
         else {
            peopleDataBaseAside.enableDeletePersonBtn(false);
            peopleDataBaseAside.enableEditPersonBtn(false);
         }
        }

    private void createPeopleDataBaseHeader(){
        PeopleDataBaseHeader peopleDataBaseHeader = new PeopleDataBaseHeader();
        this.add(peopleDataBaseHeader, BorderLayout.NORTH);
    }

    private void createPeopleDataBaseAside(){
        peopleDataBaseAside = new PeopleDataBaseAside(this);
        this.add(peopleDataBaseAside, BorderLayout.WEST);
    }

    private void createPeopleDataBaseBody(){
        peopleDataBaseBody = new PeopleDataBaseBody(this);
        this.add(peopleDataBaseBody);
    }

}
