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
        TextBuffer text = new TextBuffer("Hello-World");

        System.out.println("Text Buffer : "+text);

        // Test ins
        text.ins("aaa",6);
        // Résultat attendu : Hello-aaaWorld
        System.out.println("Text BUffer après ins : "+text);

        // Test sup
        text.del(7,9);
        // Résultat attendu : Hello-World
        System.out.println("Text BUffer après sup : "+text);

        TextBuffer bu = new TextBuffer("Cour qualité algo");
        EmacsKillRing kr = new EmacsKillRing();
        TextEditor ed = new TextEditor("Je suis un éditeur de texte");

        try{
            System.out.println(ed.getBuffer());

            ed.setCursor(3);
            ed.setMark(7);
            ed.killRingBackup();
            System.out.println(ed.getBuffer());

            ed.setCursor(11);
            ed.setMark(16);
            ed.killSection();
            System.out.println(ed.getBuffer());

            ed.setCursor(8);
            ed.yank();

            ed.killSection();
            System.out.println(ed.getBuffer());
        }
        catch (EmacsKillRingOverflowException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}