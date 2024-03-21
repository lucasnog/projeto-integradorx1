package br.lucasnog.puc.pi.repository;

import br.lucasnog.puc.pi.model.Paciente;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteMemoriaRepository implements IPacienteRepository {
    List<Paciente> listaCompleta = new ArrayList<>();

    public void addPaciente(String nome, String dataNascimento) throws ParseException {
        Paciente paciente = new Paciente(nome, dataNascimento);
        listaCompleta.add(paciente);
    }

    public Paciente buscarPorId(Integer id) {
        return listaCompleta.stream()
                .filter(paciente -> paciente.getId().equals(id))
                .findFirst()
                .get();
    }


    public List<Paciente> buscarPorNome(String nome) {
        List<Paciente> pacientesEncontrados = listaCompleta.stream()
                .filter(paciente -> paciente.getNome().toLowerCase().contains(nome))
                .collect(Collectors.toList());

        return pacientesEncontrados;

    }


    public List<Paciente> exibirListaCompleta() {
        return this.listaCompleta;
    }

    public void atualizarPaciente(Paciente pacienteAtualizar, Integer op, String novoDado) throws ParseException {

        if (op == 1) {
            pacienteAtualizar.setNome(novoDado);
        } else {
            pacienteAtualizar.setDataDeNascimento(novoDado);
        }

    }

    public void deletarPaciente(Paciente pacienteDeletar) {
        listaCompleta.remove(pacienteDeletar);
    }
}
