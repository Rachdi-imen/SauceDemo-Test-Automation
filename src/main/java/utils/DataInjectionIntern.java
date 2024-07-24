package utils;

import org.testng.annotations.DataProvider;

public class DataInjectionIntern {
    // Définition du fournisseur de données
    @DataProvider(name = "userData")
    public Object[][] userData() {
        // Définissez les données de test ici
        // Retourne un tableau d'objets bidimensionnel
        // contenant les données de test
        return new Object[][]{
                // Chaque élément du tableau représente un jeu de données
                // Chaque jeu de données est un tableau d'objets
                {" ", "secret_sauce"},{"standard_user", " "},{"locked_out_user", "secret_sauce"},
        };
    }
}
