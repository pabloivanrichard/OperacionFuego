package com.example.easynotes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.easynotes.exception.MessageExceptions;

@Service
public class MessageServiceImpl implements IMessageService {

	public String getMessages(ArrayList<ArrayList<String>> menssages) throws MessageExceptions {

		// obtengo los mensajes separado de cada satellite
		List<String> individualmessage = MsgIndividual(menssages);
		boolean valida = validateSize((ArrayList<String>) individualmessage);
		if (!validateSize((ArrayList<String>) individualmessage)) {
			throw new MessageExceptions("Tamaño Incorrecto del Mensaje");
		}

		List<String> menssagefinal = ResolveMessage(menssages);
		String message = "";
		for (int i = 0; i < menssagefinal.size(); i++) {
			message = message + " " + menssagefinal.get(i);

		}

		return message;
	}

	public ArrayList<String> MsgIndividual(ArrayList<ArrayList<String>> menssages) {

		List<String> individualmessage = new ArrayList<String>();
		for (List<String> msg : menssages) {
			individualmessage = Stream.concat(individualmessage.stream(), msg.stream()).distinct()
					.collect(Collectors.toList());
		}
		return (ArrayList<String>) individualmessage;
	}

	public ArrayList<String> ResolveMessage(ArrayList<ArrayList<String>> menssages) {
		ArrayList<String> resultado = new ArrayList<>();

		int cantidadsatalite = menssages.size();
		int tamaniomessage = menssages.get(0).size();

		for (int j = 0; j < tamaniomessage; j++) {
			for (int i = 0; i < cantidadsatalite; i++) {
				if (!menssages.get(i).get(j).equals("")) {
					if (resultado.size() != 0) {
						// recorro el for para ver si el valor del string existe
						boolean contain = false;
						for (int z = 0; z < resultado.size(); z++) {
							if (resultado.get(z).equals(menssages.get(i).get(j))) {
								contain = true;
							}

						}
						if (!contain) {
							resultado.add(menssages.get(i).get(j));
						}
					}

					if (resultado.size() == 0) {
						resultado.add(menssages.get(i).get(j));
					}

				}
			}

		}

		String mensajearmado = "";
		for (int u = 0; u < resultado.size(); u++) {
			mensajearmado = mensajearmado + " " + resultado.get(u);
		}

		return (ArrayList<String>) resultado;

	}

	public boolean validateSize(ArrayList<String> individualmessage) {
		// los tamaños de las mensajes invidual tiene q ser iguales
		int tamanio = 0;
		boolean validatamanio = false;
		for (int i = 0; i < individualmessage.size(); i++) {
			if (tamanio != 0) {
				if (tamanio == individualmessage.size()) {
					validatamanio = true;
					tamanio = individualmessage.size();

				} else {
					validatamanio = false;
					i = individualmessage.size();
				}

			}
			if (tamanio == 0) {
				tamanio = individualmessage.size();
				validatamanio = true;
			}

		}
		return validatamanio;
	}

}
