package com.pablodomingos.classes.rps;

import com.pablodomingos.classes.rps.builders.LoteRpsBuilder;
import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.enums.LoteRpsVersao;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoteRps extends AbstractRPS {
    @Attribute(name = "Id")
    @NotNull
    private String id;

    @Attribute(name = "versao")
    @NotNull
    @Valid
    private LoteRpsVersao versao;

    @Element(name = "NumeroLote")
    @NotNull
    @Pattern(regexp = "\\d+")
    @Size(min = 1, max = 15)
    private String numeroLote;

    @Element(name = "CpfCnpj")
    @NotNull
    private RpsCpfCnpj cpfCnpj;

    @Element(name = "InscricaoMunicipal")
    @NotNull
    @Size(min = 1, max = 15)
    private String inscricaoMunicipal;

    @Element(name = "QuantidadeRps")
    @NotNull
    private int quantidadeRps;

    @ElementList(name = "ListaRps", type = Rps.class)
    @NotNull
    @Valid
    private final ArrayList<Rps> listaRps = new ArrayList<>();

    public LoteRps(LoteRpsBuilder builder) {
        this.id = builder.getId();
        this.versao = builder.getVersao();
        this.numeroLote = builder.getNumeroLote();
        this.cpfCnpj = new RpsCpfCnpj(builder.getCpf(), builder.getCnpj());
        this.inscricaoMunicipal = builder.getInscricaoMunicipal();
        this.quantidadeRps = builder.getQuantidadeRps();

        for (RpsInfoBuilder rpsInfoBuilder : builder.getListaRps()) {
            this.listaRps.add(new Rps(rpsInfoBuilder));
        }

    }

    public String getId() {
        return id;
    }

    public LoteRpsVersao getVersao() {
        return versao;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public RpsCpfCnpj getCpfCnpj() {
        return cpfCnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public Integer getQuantidadeRps() {
        return quantidadeRps;
    }

    public List<Rps> getRps() {
        return Collections.unmodifiableList(listaRps);
    }


}
