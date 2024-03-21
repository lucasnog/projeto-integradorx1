package br.lucasnog.puc.pi.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente {

    private static int proximoId = 1;
    private Integer id;
    private String nome;
    private Date dataDeNascimento;
    private List<Vacina> vacinasTomadas = new ArrayList<>();

    public Paciente(String nome, String dataDeNascimento) throws ParseException {
        this.id = proximoId++;
        this.nome = nome;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataDeNascimento = dateFormat.parse(dataDeNascimento);
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataDeNascimento = dateFormat.parse(dataDeNascimento);
    }

    public List<Vacina> getVacinasTomadas() {
        return vacinasTomadas;
    }

    public void addVacinasTomadas(Vacina vacina) {
        vacinasTomadas.add(vacina);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(dataDeNascimento);
        return "Paciente{" + "id=" + id + ", nome='" + nome + '\'' + ", dataDeNascimento=" + dataFormatada + ", vacinasTomadas=" + vacinasTomadas + '}';
    }
}
