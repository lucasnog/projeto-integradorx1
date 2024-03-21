package br.lucasnog.puc.pi.controller;

import java.text.ParseException;

public interface IController {
    public Integer menuPrincipal();

    public void addPaciente() throws ParseException;

    public void aplicarVacina();

    public void exibirListaCompleta();

    public void buscarPorNome();

    public void atualizarPaciente() throws ParseException;

    public void deletarPaciente();

    public Boolean sair();

    public void msgDefault();
    public void teste() throws ParseException;
}
