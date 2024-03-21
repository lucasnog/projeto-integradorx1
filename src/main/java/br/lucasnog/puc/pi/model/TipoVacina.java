package br.lucasnog.puc.pi.model;

import java.util.Arrays;

public enum TipoVacina {
    BCG(1),
    HEPATITE_B(2),
    PENTA(3),
    POLIO_INATIVADA(4),
    POLIO_ORAL(5),
    ROTAVIRUS(6),
    PNEUMO_10(7),
    MENINGO_C(8),
    FEBRE_AMARELA(9),
    TRIPICE_VIRAL(10),
    TETRA_VIRAL(11),
    DTP(12),
    HEPATITE_A(13),
    VARICELA(14),
    DIFTERIA_TETANO_ADULTO(15),
    MENINGOCOCICA_ACWY(16),
    HPV_QUADRIVALENTE(17),
    DTPA(18),
    INFLUENZA(19),
    PNEUMO_23(20);

    private final int id;

    TipoVacina(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static String getNomePeloId(int id) {
        return Arrays.stream(TipoVacina.values())
                .filter(tipo -> tipo.getId() == id)
                .findFirst()
                .get()
                .name();
    }
}
