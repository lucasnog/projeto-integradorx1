package br.lucasnog.puc.pi.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Vacina {
    private static int proximoId = 1;
    private Integer id;
    private String nome;
    private Date dataAplicada;

    public Vacina(int idTipoVacina) {
        this.dataAplicada = new Date();
        this.nome = TipoVacina.getNomePeloId(idTipoVacina) ;
        this.id = proximoId++;
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

    public Date getDataAplicada() {
        return dataAplicada;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(dataAplicada);
        return "Vacina{" +
                "nome='" + nome + '\'' +
                ", dataAplicada=" + dataFormatada +
                '}';
    }
}
