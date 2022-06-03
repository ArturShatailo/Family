import java.util.ArrayList;

public class Human extends Family{

    private final String name;
    private final String sex;
    private Human mother;
    private Human father;
    private ArrayList<Human> children = new ArrayList<>();
    private ArrayList<Human> grannies = new ArrayList<>();

    public Human(String sex) {
        this.sex = sex;
        this.name = chooseName();
    }

    public Human(String name, String sex) {
        this.sex = sex;
        this.name = name;
    }

    public Human(Human mother, Human father, String sex) {
        this.father = father;
        this.mother = mother;
        this.sex = sex;
        this.name = chooseName();
    }

    public Human(Human mother, Human father, String sex, String name) {
        this.father = father;
        this.mother = mother;
        this.sex = sex;
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    //Names generator from interface Names collections of female and male names
    private String chooseName() {
        return sex.equals("f")
                ? fNames[Tech.getRandom(0, fNames.length-1)]+" #"+Tech.getRandom(1767, 9786)
                : mNames[Tech.getRandom(0, mNames.length-1)]+" #"+Tech.getRandom(1767, 9786);
    }

    public String toString(){
        return " name: "+name;
    }

}
