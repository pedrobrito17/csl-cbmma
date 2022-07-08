package br.gov.ma.ssp.cbm.odonto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import br.gov.ma.ssp.cbm.odonto.model.BombeiroMilitar;
import br.gov.ma.ssp.cbm.odonto.repository.BombeiroMilitarRepository;
import br.gov.ma.ssp.cbm.odonto.repository.RoleRepository;

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
        bombeiro.setRoles(roleRepository.findByRole("PACIENTE"));
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

	public void limparBancoDados() {
        bombeiroRepository.deleteAll();
	}

	public BombeiroMilitar atualizarDados(BombeiroMilitar bombeiro) {
        return bombeiroRepository.save(bombeiro);
	}
}