package simplisim;

import java.io.Serializable;

/**
 * This class implemented {@link Serializable} interface to allow the character to be saved on an obj file.
 * The file then can be loaded in the {@link CharacterCreator} class.
 * <br>
 * <p> Use {@code FileOutputStream} and {@code ObjectOutputStream} to save the file. eg.,
 * <blockquote><pre>
 *   try (final ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream("character.obj"))) {
 *       outputFile.writeObject(character);
 *       outputFile.flush();
 *   }
 * </pre></blockquote>
 * Use {@code FileInputStream} and {@code ObjectInputStream} to load the file. eg.,
 * <blockquote><pre>
 *   try (final ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream("character.obj"))) {
 *       inputFile.writeObject(character);
 *       inputFile.flush();
 *   }
 * </pre></blockquote>
 * 
 * <p>This class has no custom constructor but attributes can be set with the setters.
 * <p><strong>Attributes :</strong>
 * <blockquote>
 * <br>
 * - {@link String} {@code firstName} <br> <br>
 * - {@link String} {@code lastName} <br> <br>
 * - {@link Integer} {@code age} <br> <br>
 * - {@link String} {@code gender} <br> <br>
 * - {@link Integer} {@code hunger} <br> <br>
 * - {@link Integer} {@code hygiene} <br> <br>
 * - {@link Integer} {@code energy} <br> <br>
 * - {@link Integer} {@code fatness} <br> <br>
 * - {@link Integer} {@code happiness} <br> <br>
 * - {@link Integer} {@code balance} <br> <br>
 * </blockquote>
 * 
 * @author Fire Of Ender
 */

public class Character implements Serializable{
    
}
