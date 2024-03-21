package br.lucasnog.puc.pi;

import br.lucasnog.puc.pi.controller.IController;
import br.lucasnog.puc.pi.controller.PacienteController;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {

        IController userInterface = new PacienteController();
        Boolean continuar = true;

        userInterface.teste();
        do {
            try {

                switch (userInterface.menuPrincipal()) {
                    case 1:
                        userInterface.addPaciente();
                        break;
                    case 2:
                        userInterface.aplicarVacina();
                        break;
                    case 3:
                        userInterface.exibirListaCompleta();
                        break;
                    case 4:
                        userInterface.buscarPorNome();
                        break;
                    case 5:
                        userInterface.atualizarPaciente();
                        break;
                    case 6:
                        userInterface.deletarPaciente();
                        break;
                    case 7:
                        continuar = userInterface.sair();
                        break;
                    default:
                        userInterface.msgDefault();

                }

            } catch (Exception e) {
                userInterface.msgDefault();
            }

        } while (continuar);
    }
}