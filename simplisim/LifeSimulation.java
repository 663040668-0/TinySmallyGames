package simplisim;

import javax.swing.*;
import simplisim.util.FoodNutrient;

/**
 * This class will let player simulate the life of their {@link Character}.
 * This class extends {@link JFrame} to create and show GUI.
 * 
 * <p><strong>Available Activities :</strong>
 * <blockquote>
 * <br>
 * - {@code eat(String food)} ++hunger ++happiness +fatness <br> <br>
 * - {@code sleep()} ++energy +happiness -hygiene --hunger (++hapiness if yesterday {@code exercise()}) <br> <br>
 * - {@code exercise(int minutes)} -happiness -hunger -fatness --hygiene --energy <br> <br>
 * - {@code bath()} ++hygiene +happiness <br> <br>
 * - {@code work()} ++balance --happiness --hunger --energy -hygiene <br> <br>
 * </blockquote>
 * 
 * @author Fire Of Ender
 */

public class LifeSimulation {
    
}
