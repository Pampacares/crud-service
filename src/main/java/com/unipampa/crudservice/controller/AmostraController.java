package com.unipampa.crudservice.controller;

import com.unipampa.crudservice.dto.AmostraDTO;
import com.unipampa.crudservice.interfaces.*;
import com.unipampa.crudservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/salvar")
public class AmostraController {

    @Autowired
    private ICaoService caoService;

    @Autowired
    private IProprietarioService proprietarioService;

    @Autowired
    private IExameService exameService;

    @Autowired
    private ISintomaService sintomaService;

    @Autowired
    private IAmostraService amostraService;

    @Autowired
    private IAcaoService acaoService;

    @PostMapping("/geral")
    public void salvarGeral(@RequestBody AmostraDTO dto){

        Proprietario proprietario = caputurarProprietario(dto);
        Acao acao = capturarAcao(dto);
        Amostra amostra = caputurarAmostra(dto);

        List<Exame> exames = dto.getExames().stream().collect(Collectors.toList());
        List<Sintoma> sintomas = dto.getSintomas().stream().collect(Collectors.toList());
        List<Cao> caes = dto.getProprietario().getCaes().stream().collect(Collectors.toList());

        proprietario.setCaes(caes);
        amostra.setExames(exames);
        amostra.setAcao(acao);

        salvarCaes(caes);
        salvarExames(exames);
        salvarSintomas(sintomas);
        acaoService.salvarAcao(acao);
        proprietarioService.salvarProprietario(proprietario);
        amostraService.salvarAmostra(amostra);
    }

    public void salvarCaes(List<Cao> caes){
        caes.stream().forEach(e -> caoService.salvarCao(e));
    }


    public void salvarSintomas(List<Sintoma> sintomas){
        sintomas.stream().forEach(e -> sintomaService.salvarSintoma(e));
    }

    public void salvarExames(List<Exame> exames) {
        exames.stream().forEach(e -> exameService.salvarExame(e));
    }

    public Amostra caputurarAmostra(AmostraDTO dto){
        Amostra amostra = new Amostra();
        amostra.setLvc(dto.getAmostra().getLvc());
        amostra.setMorreu(dto.getAmostra().getMorreu());
        return amostra;
    }

    public Acao capturarAcao(AmostraDTO dto){
        Acao acao = new Acao();
        acao.setNome(dto.getAcao().getNome());
        return acao;
    }

    public Proprietario caputurarProprietario(AmostraDTO dto){
        Proprietario proprietario = new Proprietario();
        proprietario.setNome(dto.getProprietario().getNome());
        return proprietario;
    }
}
