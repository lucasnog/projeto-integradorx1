package br.lucasnog.puc.pi.controller;

import br.lucasnog.puc.pi.model.Paciente;
import br.lucasnog.puc.pi.model.Vacina;
import br.lucasnog.puc.pi.repository.IPacienteRepository;
import br.lucasnog.puc.pi.repository.PacienteMemoriaRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PacienteController implements IController {

    Scanner sc = new Scanner(System.in);
    String nome;
    String dataNascimento;

    IPacienteRepository pacienteMemoriaRepository = new PacienteMemoriaRepository();

    public PacienteController() {
    }

    public Integer menuPrincipal() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar novo Paciente");
        System.out.println("2 - Aplicar vacina");
        System.out.println("3 - Listar todos os Pacientes");
        System.out.println("4 - Buscar Paciente pelo Nome");
        System.out.println("5 - Atualizar Paciente");
        System.out.println("6 - Excluir Paciente");
        System.out.println("7 - Sair");

        return sc.nextInt();

    }

    public void addPaciente() throws ParseException {
        sc.nextLine();
        System.out.println("Qual o nome do paciente?");
        nome = sc.nextLine();
        System.out.println("Qual a data de nasciimento do paciente?");
        dataNascimento = sc.next();

        pacienteMemoriaRepository.addPaciente(nome, dataNascimento);

        System.out.println("Paciente " + nome + " cadastrado com sucesso.");

    }

    public void aplicarVacina() {
        System.out.println("Digite o Codigo da vacina que será aplicada.");
        System.out.println("1. BCG\n" +
                "2. Hepatite B\n" +
                "3. Penta\n" +
                "4. Pólio inativada\n" +
                "5. Pólio oral\n" +
                "6. Rotavírus\n" +
                "7. Pneumo 10\n" +
                "8. Meningo C\n" +
                "9. Febre amarela\n" +
                "10. Tríplice viral (sarampo, caxumba e rubéola)\n" +
                "11. Tetra viral (sarampo, caxumba, rubéola e\n" +
                "varicela)\n" +
                "12. DTP\n" +
                "13. Hepatite A\n" +
                "14. Varicela\n" +
                "15. Difteria e tétano adulto (dT)\n" +
                "16. Meningocócica ACWY\n" +
                "17. HPV quadrivalente\n" +
                "18. dTpa\n" +
                "19. Influenza (ofertada durante Campanha anual)\n" +
                "20. Pneumocócica 23-valente (Pneumo 23)");

        Integer idVacinaMenu = sc.nextInt();
        System.out.println("Qual o ID do paciente que será aplicada a vacina?");
        Integer pacienteId = sc.nextInt();

        Vacina vacinaAplicada = new Vacina(idVacinaMenu);
        pacienteMemoriaRepository.buscarPorId(pacienteId).addVacinasTomadas(vacinaAplicada);

        System.out.println("Vacina " + vacinaAplicada.getNome() + " aplicada com sucesso no paciente " + pacienteMemoriaRepository.buscarPorId(pacienteId).getNome());

    }


    public void exibirListaCompleta() {
        System.out.println(pacienteMemoriaRepository.exibirListaCompleta());
    }

    public void buscarPorNome() {

        System.out.println("Digite parte o nome do paciente a ser buscado:");
        String parteNomeBuscado = sc.next().toLowerCase();


        if (pacienteMemoriaRepository.buscarPorNome(parteNomeBuscado) == null) {
            System.out.println("Nenhum paciente encontrado com o nome contendo '" + parteNomeBuscado + "'.");
        } else {
            System.out.println(pacienteMemoriaRepository.buscarPorNome(parteNomeBuscado));
        }
    }

    public void atualizarPaciente() throws ParseException {
        System.out.println("Digite o ID do paciente a ser atualizado.");
        Paciente pacienteAtualizar = pacienteMemoriaRepository.buscarPorId(sc.nextInt());

        if (pacienteAtualizar != null) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("Paciente " + pacienteAtualizar.getNome());
            System.out.println("Data de nascimento " + formato.format(pacienteAtualizar.getDataDeNascimento()));
            System.out.println("O que deseja alterar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Data de nascimento");
            System.out.println("0 - Voltar");

            int op = sc.nextInt();

            if (op == 1 || op == 2) {
                sc.nextLine();
                System.out.println("Qual será o novo valor?");
                String novoDado = sc.nextLine();
                pacienteMemoriaRepository.atualizarPaciente(pacienteAtualizar, op, novoDado);
                System.out.println(pacienteAtualizar.getNome() + " atualizado com sucesso.");
            }

        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public void deletarPaciente() {
        System.out.println("Digite o ID do paciente a ser deletado.");
        Paciente pacienteDeletar = pacienteMemoriaRepository.buscarPorId(sc.nextInt());

        if (pacienteDeletar != null) {
            System.out.println("Paciente " + pacienteDeletar.getNome() + " removido com sucesso.");
            pacienteMemoriaRepository.deletarPaciente(pacienteDeletar);
        } else {
            System.out.println("Paciente não encontrado");
        }
    }

    public Boolean sair() {
        System.out.println("Até logo!");
        return false;
    }

    public void msgDefault() {
        System.out.println("Digite uma opção valida.");
        sc.nextLine();
    }


    public void teste() throws ParseException {
        pacienteMemoriaRepository.addPaciente("Lucas", "01/01/2000");
    }
}
