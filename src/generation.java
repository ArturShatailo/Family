public class generation implements Generations{

    public static void main(String[] args) {

        //Creating the first man and woman, their family and children
        Human man = new Human("Adam", "m");
        Human woman = new Human("Eva", "f");
        Family family = new Family(woman, man);

        Human s = new Human(woman, man, "m", "Kain");
        Human s1 = new Human(woman, man, "m", "Avel");

        family.getChildren().add(s);
        family.getChildren().add(s1);

        //Adding Family to collection families in Generations interface
        families.add(family);

        //Start generations move
        startGeneration();

    }

    private static void startGeneration() {
        System.out.println("Click Enter to generate new family");
        Tech.GetInputStringFunction();
        newGeneration();
    }

    //This method defines children who don't have children and calls addGeneration method for them.
    private static void newGeneration() {

        for(Family h:families){

            h.getChildren()
                    .stream()
                    .filter(n -> n.getChildren().size() == 0)
                    .filter(m -> m.getSex().equals("m"))
                    .forEach(m -> addGeneration(m, new Human(new Human("f"), new Human("m"), "f")));

            h.getChildren()
                    .stream()
                    .filter(n -> n.getChildren().size() == 0)
                    .filter(m -> m.getSex().equals("f"))
                    .forEach(m -> addGeneration(new Human(new Human("f"), new Human("m"), "m"), m));

        }

        families.forEach(n -> System.out.println(n.toString()));
        System.out.println("\n////////////////\n");

        startGeneration();
    }

    //Creating new family from 2 Human objects (the defined one from method newGeneration() and new created Human object)
    private static void addGeneration(Human man, Human woman) {

        Family family = new Family(woman, man);

        //Family object methods call
        family.doChildren(Tech.getRandom(1, 3));
        family.familyTree();

        //Add new Family into families collection
        families.add(family);

    }


}
