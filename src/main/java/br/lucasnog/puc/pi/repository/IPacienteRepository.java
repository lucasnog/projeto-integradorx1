package br.lucasnog.puc.pi.repository;

import br.lucasnog.puc.pi.model.Paciente;

import java.text.ParseException;
import java.util.List;

public interface IPacienteRepository {
    public void addPaciente(String nome, String dataNascimento) throws ParseException;

    public Paciente buscarPorId(Integer id);

    public List<Paciente> buscarPorNome(String nome);

    public List<Paciente> exibirListaCompleta();

    public void atualizarPaciente(Paciente pacienteAtualizar, Integer op, String novoDado) throws ParseException;

    public void deletarPaciente(Paciente pacienteDeletar);
}
