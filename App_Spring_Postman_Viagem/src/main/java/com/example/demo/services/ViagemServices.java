package com.example.demo.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ViagemDto;
import com.example.demo.entities.Viagem;
import com.example.demo.repositories.ViagemRepository;


@Service
public class ViagemServices {
	
	@Autowired
	private ViagemRepository viagemRepository;

	public List<Viagem> listar() {
		return viagemRepository.findAll();
	}

	public Viagem salvar(ViagemDto viagemDto) {

		Viagem viagem = new Viagem();

		viagem.setLocalDeDestino(viagemDto.getLocalDeDestino());
		viagem.setDataPartida(viagemDto.getDataPartida());
		viagem.setDataRetorno(viagemDto.getDataRetorno());
		viagem.setAcompanhante(viagemDto.getAcompanhante());
		return viagemRepository.save(viagem);
	}

	public Viagem buscar(Long id) throws Exception {
		Viagem viagem = viagemRepository.findById(id).orElse(null);

		if (viagem == null) {
			throw new Exception("Não existe esta viagem cadastrada");
		}
		return viagem;
	}

}
