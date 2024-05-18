package co.edu.uptc.pojos;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet implements Cloneable {
    private int id;
    private String name;
    private String species;
    private int age;
    private String breed;
    private ArrayList<Keeper> keepers;

    public Keeper getOwner(){
        Keeper ownerkeeper = new Keeper();
        for (Keeper keeper : keepers) {
            if (keeper.getRelationship() == 'O') {
                ownerkeeper = keeper;
            }
        }
        return ownerkeeper;
    }


    @Override
    public Pet clone(){
        try {
            return (Pet) super.clone(); 
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
