class Zoo {
    private final Cage[] cages;

    public Zoo(int cageCount) {
        cages = new Cage[cageCount];
        for (int i = 0; i < cageCount; i++) {
            cages[i] = new Cage();
        }
    }

    public void addAnimal(Animal animal, int cageIndex) throws Exception {
        cages[cageIndex].add(animal);
    }

    public void walkThroughZoo() {
        for (int i = 0; i < cages.length; i++) {
            Animal animal = cages[i].getAnimal();
            if (animal != null) {
                System.out.println("Клетка " + (i+1) + ": " + animal.getAnimalSound());
            } else {
                System.out.println("Клетка " + (i+1) + " пуста.");
            }
        }
    }
}