class Herbivore implements Animal {
    private final String name;
    private final String animalClass;
    private final String sound;

    public Herbivore(String name, String animalClass, String sound) {
        this.name = name;
        this.animalClass = animalClass;
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Herbivore{" +
                "name='" + name + '\'' +
                ", animalClass='" + animalClass + '\'' +
                ", sound='" + sound + '\'' +
                '}';
    }

    @Override
    public String getAnimalName() {
        return name;
    }

    @Override
    public String getAnimalType() {
        return "Травоядное";
    }

    @Override
    public String getAnimalClass() {
        return animalClass;
    }

    @Override
    public String getAnimalSound() {
        return sound;
    }
}