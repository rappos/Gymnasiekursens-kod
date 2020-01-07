package djurpark;

public class Animal {
    
    private String animal;
    private String name;

    Animal(String djur, String namn) {
        animal = djur;
        name = namn;
    }

    void viewAnimal() {
        System.out.println("Djuret: " + animal +"\t"+ "Namn: " + name);
    }
    
    

}
