// Creation Date: September 13, 2026. at 9:15 PM
// Last Modified: September 15, 2026. at  3:26 PM

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        // [CREATE OBJECTS]
        ClothesManager CManager = new ClothesManager();

        // [CREATE CLOTH]
        CManager.createClothes("T-Shirt", "Nike", "Black", "Medium", "Cloth01");
        CManager.createClothes("Long-Sleeve", "Why", "White", "Extra Small", "Cloth02");
        CManager.createClothes("Hoodie", "Aeropostale", "Blue", "Large", "Cloth03");

        // [MODIFY CLOTHES]
        CManager.changeClothBrand("Converse");
        CManager.changeClothColor("Blue");

        // [LOAD FILE]
        CManager.loadFile("Cloth01");
        CManager.changeClothColor("Rainbow");

        // [DELETE FILE]
        CManager.loadFile("Cloth02");

    }
    // =========================== METHODS =========================== \\
}
