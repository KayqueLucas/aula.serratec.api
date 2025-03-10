package br.org.serratec.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.biblioteca.entities.Perfil;
import br.org.serratec.biblioteca.repositories.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	PerfilRepository perfilRepository;
	
	public List<Perfil> findAll() {
		return perfilRepository.findAll();
	}
	public Perfil findById(Integer id) {
		return perfilRepository.findById(id).orElse(null);
	}
	
	public Perfil save(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	public Perfil update(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
//	public Perfil update(Perfil perfil, Integer id) {
//		Perfil existentePerfil = findById(id);
//		existentePerfil.setDescricao(perfil.getDescricao());
//		existentePerfil.setNome(perfil.getNome());
//		
//		return perfilRepository.save(existentePerfil);
//	}
	
	//Exercicio para casa: Implementar uma forma de retornar o resultado
	//da deleção, retornando se o perfil foi deletado com sucesso ou não
	
	public void deleteById1(Integer id) {
		perfilRepository.deleteById(id);
	}

	public long count() {
		return perfilRepository.count();
	}

	public boolean deleteById(Integer id) {
		if(perfilRepository.existsById(id)) {
			perfilRepository.deleteById(id);
			Perfil perfilDeletado = perfilRepository.findById(id).orElse(null);
			if(perfilDeletado == null) {
				return true;
			}else {
				return false;
			}	
		}else {
			return false;
		}
	}
}