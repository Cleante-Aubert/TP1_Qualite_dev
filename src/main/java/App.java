//
// Utilisation nominale des classes td3.Buffer, Killring et td3.Editor
//
////////////////////////////////////////////////////////////////

import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;

public class App {

    public static void main(String[] args) {
        TextBuffer textBuffer = new TextBuffer("Hello-World");

        System.out.println("Text Buffer : "+textBuffer);

        // Test ins
        textBuffer.ins("aaa",6);
        // Résultat attendu : Hello-aaaWorld
        System.out.println("Text BUffer après ins : "+textBuffer);

        // Test sup
        textBuffer.del(7,9);
        // Résultat attendu : Hello-World
        System.out.println("Text BUffer après sup : "+textBuffer);

    }
}
