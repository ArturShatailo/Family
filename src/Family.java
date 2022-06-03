import java.util.ArrayList;
import java.util.Arrays;

public class Family implements Names{

    private Human mother;
    private Human father;
    private final ArrayList<Human> children = new ArrayList<>();
    private final ArrayList<Human> grannies = new ArrayList<>();

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }

    public Family() {

    }

    public ArrayList<Human> getChildren() {
        return children;
    }


    //This method fills out grannies field with mother's and father's mother and father objects.
    public void familyTree(){
        grannies.add(mother.getMother());
        grannies.add(father.getFather());
        grannies.add(father.getMother());
        grannies.add(mother.getFather());
    }

    //Creates random amount of children (Human objects) and add them into children field of mother field and father field,
    //that is also Human objects
    public void doChildren(int amount) {

        for(int i=0; i<amount; i++){
            if (Tech.getRandom(0, 1) == 0) {
                children.add(new Human(mother, father, "f"));
            } else {
                children.add(new Human(mother, father, "m"));
            }
        }
        mother.setChildren(children);
        father.setChildren(children);
    }

    @Override
    public String toString(){
        return "Mother: "+mother.toString()+
                "\nFather: "+father.toString()+
                "\nChildren: "+ Arrays.toString(children.toArray())+
                "\nGrannies: "+ Arrays.toString(grannies.toArray());
    }

}
