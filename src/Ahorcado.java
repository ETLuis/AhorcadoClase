import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;


public class Ahorcado {


    public static void partida() {

        List<String> palabras = Arrays.asList("camion", "toro", "perro", "hawaii");

        int i = 0;
        int tmp=0;



        Random rand = new Random();
        String palabraJuego = palabras.get(rand.nextInt(palabras.size()));

        System.out.println(palabraJuego);

        List<Character> jugadores = new ArrayList<>();

        int intentos = 0;

        while (true) {
            if (intentos >= 4) {
                JOptionPane.showMessageDialog(null, "Perdiste");
                break;
            }

            if(!jugando(palabraJuego, jugadores)){
                intentos++;
            }


            if(verPalabras(palabraJuego, jugadores)){
                JOptionPane.showMessageDialog(null, "Ganaste");
            }


            if(palabraJuego.equals(tmp)){
                JOptionPane.showMessageDialog(null, "Ganaste");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "No es correcto, continue");
            }

        }
    }



    private static void averiguar(String palabraJuego, List<Character> jugadores){
        int op = JOptionPane.showOptionDialog(null, "¿Quieres introducir la palabra?","Averiguar",YES_NO_OPTION,QUESTION_MESSAGE,null,new Object[] { "Si", "No"},null);

        switch(op){

            case 0:
                String palabra = JOptionPane.showInputDialog( "Introduce la palabraaa");



                System.out.print(palabra);
                if(palabraJuego.equals(palabra)){
                    JOptionPane.showMessageDialog(null, "Ganaste");

                } else {
                    JOptionPane.showMessageDialog(null, "No es correcto, continue");
                }

            case 1:
                Ahorcado.jugando(palabraJuego, jugadores);


                break;
        }


    }




    private static boolean jugando(String palabraJuego, List<Character> jugadores) {

        String letra = JOptionPane.showInputDialog("Introduce unha letra: ");
        jugadores.add(letra.charAt(0));

        Ahorcado.verPalabras(palabraJuego, jugadores);

        return palabraJuego.contains(letra);
    }

    private static boolean verPalabras(String palabraJuego, List<Character> jugadores) {
        String concatena = "";
        int correctas = 0;

        for (int i = 0; i < palabraJuego.length(); i++) {
            if (jugadores.contains(palabraJuego.charAt(i))) {
                concatena = concatena + palabraJuego.charAt(i);
                correctas++;
            } else {
                concatena = concatena + " - ";
            }
        }

        System.out.println(concatena);

        JOptionPane.showMessageDialog(null, concatena);

        Ahorcado.averiguar(palabraJuego, jugadores);

        return (palabraJuego.length() == correctas);
    }
}