package br.gov.ma.ssp.cbm.csl.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import br.gov.ma.ssp.cbm.csl.model.BombeiroMilitar;
import br.gov.ma.ssp.cbm.csl.model.Role;
import br.gov.ma.ssp.cbm.csl.repository.BombeiroMilitarRepository;
import br.gov.ma.ssp.cbm.csl.repository.RoleRepository;

@Service
public class BombeiroMilitarService{

    @Autowired
    private BombeiroMilitarRepository bombeiroRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void salvarNovoUsuario(BombeiroMilitar bombeiro){
        bombeiro.setSenha(bCryptPasswordEncoder.encode(bombeiro.getSenha()));
        Role bombeiroRole = roleRepository.findByRole("CSL_UNIDADE");
        bombeiro.setRoles(new HashSet<Role>(Arrays.asList(bombeiroRole)));
        bombeiroRepository.save(bombeiro);
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public BombeiroMilitar getBombeiroLogado(){
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String matricula = auth.getName();
        BombeiroMilitar bombeiro = bombeiroRepository.findByMatricula(matricula);
        return bombeiro;
    }

	public BombeiroMilitar atualizarDados(BombeiroMilitar bombeiro) {
        return bombeiroRepository.save(bombeiro);
	}	
    
    public BombeiroMilitar atualizarSenha(BombeiroMilitar bombeiro) {
        bombeiro.setSenha(bCryptPasswordEncoder.encode(bombeiro.getSenha()));
        return bombeiroRepository.save(bombeiro);
	}

    public List<BombeiroMilitar> getTodosBombeiros() {
        return bombeiroRepository.findAll();
    }

    public BombeiroMilitar tornarAtivo(int id) {
        Optional<BombeiroMilitar> bm = bombeiroRepository.findById(id);
        bm.get().setAtivo(1);
        return bombeiroRepository.save(bm.get());
    }
    
    public BombeiroMilitar resetarSenha(int id) {
        Optional<BombeiroMilitar> bm = bombeiroRepository.findById(id);
        bm.get().setSenha(bCryptPasswordEncoder.encode("123456"));
        return bombeiroRepository.save(bm.get());
    }
}