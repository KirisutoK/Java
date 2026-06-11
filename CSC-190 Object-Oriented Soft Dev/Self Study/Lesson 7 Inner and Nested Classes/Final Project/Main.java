// Creation Date: June 08, 2026. at 11:15 AM
// Last Modified: June 10, 2026. at  9:24 PM

public class Main {
    public static void main(String[] args) {
        // ============= CREATING OBJECT ============= \\
        Cat Cat01 = new Cat("Sheila");
        Cat.Accessories CatAccessory01 = Cat01.new Accessories("Collar", "Shiela's Special Collar");

        // [ANONYMOUS CLASS]
        Cat Cat02 = new Cat("Ginger") {
            @Override public void makeNoise() {
                System.out.println("Ginger: Nah, i dont swing that way dawg.");
            }
        };

        // ============= METHODS ============= \\
        System.out.println("=============================== Shiela ===============================");
        Cat01.makeNoise();
        Cat01.eatFood("Fish");
        CatAccessory01.displayInformation();
        System.out.println("=============================== Ginger ===============================");
        Cat02.makeNoise();
        Cat02.eatFood("Fish");

    }
}

// Requirements:
//
// 1. Must use at least 2 of the 4 types of inner/nested classes (✅Static Nested, ✅Inner, Local, ✅Anonymous)
// 2. Must have at least one static nested class that is instantiated without an outer object
// ✅ 3. Must have at least one inner class that directly accesses an outer class member
// 4. Must have at least 5 classes total (including nested/inner classes)
// ✅ 5. Must have a fully working Main.java that demonstrates all nested/inner classes being used
// 6. The system must make real-world logical sense
// 7. Must demonstrate that you understand when and why to use each type — the choice of which class gets which type should make sense

// TODO: I LEFT AT MAKING A LOCAL CLASS FOR THE METHOD getVaccinated() FOR THE CAT CLASS