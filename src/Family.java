import java.util.ArrayList;
import java.util.Arrays;

public class Family implements Names{

    private Human woman;
    private Human man;
    private final ArrayList<Human> children = new ArrayList<>();
    private final ArrayList<Human> grannies = new ArrayList<>();

    public Family(Human mother, Human father) {
        this.woman = mother;
        this.man = father;
    }

    public Family() {

    }

    public ArrayList<Human> getChildren() {
        return children;
    }


    //This method fills out grannies field with mother's and father's mother and father objects.
    public void familyTree(){
        grannies.add(woman.getMother());
        grannies.add(man.getFather());
        grannies.add(man.getMother());
        grannies.add(woman.getFather());
    }

    //Creates random amount of children (Human objects) and add them into children field of mother field and father field,
    //that is also Human objects
    public void doChildren(int amount) {

        for(int i=0; i<amount; i++){
            if (Tech.getRandom(0, 1) == 0) {
                children.add(new Human(woman, man, "f"));
            } else {
                children.add(new Human(woman, man, "m"));
            }
        }
        woman.setChildren(children);
        woman.setChildren(children);
    }

    @Override
    public String toString(){
        return "Mother: "+woman.toString()+
                "\nFather: "+man.toString()+
                "\nChildren: "+ Arrays.toString(children.toArray())+
                "\nGrannies: "+ Arrays.toString(grannies.toArray());
    }

}
