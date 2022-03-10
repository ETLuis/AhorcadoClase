import javax.swing.*;

public class JuegoAhorcado {


        public static void main(String[] args) {
            // TODO code application logic here

            int op;

            op = Integer.parseInt(JOptionPane.showInputDialog(" **** MENU ****" +
                    "\n1 --> Empezar partida" + "\n2 --> Sair da partida"));

            switch (op){
                case 1 : Ahorcado.partida();
                    break;
            } while (op != 2);
        }

    }

