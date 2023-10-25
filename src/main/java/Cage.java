class Cage {
    private Animal animal;

    public void add(Animal animal) throws Exception {
        if (this.animal != null) {
            throw new Exception("Клетка уже занята!");
        }
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
}