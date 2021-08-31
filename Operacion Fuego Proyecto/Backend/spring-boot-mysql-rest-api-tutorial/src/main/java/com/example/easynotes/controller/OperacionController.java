package com.example.easynotes.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.SSLEngineResult.Status;
import javax.validation.Valid;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.easynotes.exception.MessageExceptions;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Position;
import com.example.easynotes.model.Satelite;
import com.example.easynotes.model.SateliteTop_split;
import com.example.easynotes.model.Ship;
import com.example.easynotes.model.Top_Secret;
import com.example.easynotes.repository.IPositionRepository;
import com.example.easynotes.repository.ISateliteRepository;
import com.example.easynotes.repository.IShipRepository;
import com.example.easynotes.service.ILocationService;
import com.example.easynotes.service.IMessageService;
import com.example.easynotes.service.ISateliteService;
import com.example.easynotes.service.SateliteServiceImpl;

@RestController
@RequestMapping("/api/operacion")
public class OperacionController {

	@Autowired
	ISateliteService sateliteService;
	@Autowired
	ILocationService locationService;
	@Autowired
	IMessageService messageService;
	@Autowired
	IPositionRepository positionRepository;
	@Autowired
	IShipRepository shipRepository;

	public OperacionController(ISateliteService sateliteService) {
		this.sateliteService = sateliteService;
	}

	@GetMapping("/satelites")
	public List<Satelite> getAllSatellites() {
		return sateliteService.findAll();
	}

	@GetMapping("/ship")
	public Ship getship() {
		return shipRepository.findAll().get(0);
	}

	// Nivel 1
	@PostMapping("/triangulation")
	public double[] Triangulation(@Valid @RequestBody double[][] positions, double[] distances) {
		double[] resultado = locationService.getLocation(positions, distances);
		return resultado;
	}

	@GetMapping("/Menssage")
	public String getMessages(ArrayList<ArrayList<String>> menssages) {
		String resultado;
		try {
			resultado = messageService.getMessages(menssages);
			return resultado;
		} catch (MessageExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}

	}
/*
	// nivel 2
	@PostMapping("/topsecret")
	public ResponseEntity<Position> topsecret(@Valid @RequestBody List<Satelite> listsatelite)
			throws MessageExceptions {
		double[][] positions = new double[listsatelite.size()][2];
		double[] distances = new double[listsatelite.size()];
		;
		ArrayList<Double> listadistances = new ArrayList<>();
		for (int i = 0; i < listsatelite.size(); i++) {
			distances[i] = listsatelite.get(i).getDistance();
			Position position = positionRepository.findByidSatelite(listsatelite.get(i).getIdSatelite());
			;
			positions[i][1 - 1] = position.getX();
			positions[i][2 - 1] = position.getY();
		}
		try {
			double[] resultado = locationService.getLocation(positions, distances);
			Position position = new Position();
			position.setX(resultado[0]);
			position.setY(resultado[1]);
			return ResponseEntity.status(HttpStatus.OK).body(position);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}

	}

	// nivel 2
	@PostMapping("/topsecret1")
	public ResponseEntity<String> topsecret1(@Valid @RequestBody List<Satelite> listsatelite) throws MessageExceptions {
		ArrayList<ArrayList<String>> messages = new ArrayList<ArrayList<String>>();
		ArrayList<String> message = new ArrayList<String>();
		System.out.println("Tamanio" + listsatelite.size());
		double[] distances = null;
		for (int i = 0; i < listsatelite.size(); i++) {
			System.out.println("Satelite" + listsatelite.get(i).getName());
			message = new ArrayList<String>(Arrays.asList(listsatelite.get(i).getMessage()));
			System.out.println("message" + listsatelite.get(i).getMessage());
			messages.add(message);
		}
		try {

			String resul = messageService.getMessages(messages);
			return ResponseEntity.status(HttpStatus.OK).body(resul);

		} catch (Exception e) {
			System.out.println("exeption" + e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}

	}
*/
	// nivel 2
	@PostMapping("/topsecret")
	public ResponseEntity<Top_Secret> topsecret2(@Valid @RequestBody List<Satelite> listsatelite)
			throws MessageExceptions {
		double[][] positions = new double[listsatelite.size()][2];
		double[] distances = new double[listsatelite.size()];
		ArrayList<ArrayList<String>> messages = new ArrayList<ArrayList<String>>();
		ArrayList<String> message = new ArrayList<String>();

		for (int i = 0; i < listsatelite.size(); i++) {

			distances[i] = listsatelite.get(i).getDistance();
			Position position = positionRepository.findByidSatelite(listsatelite.get(i).getIdSatelite());
			;

			positions[i][1 - 1] = position.getX();
			positions[i][2 - 1] = position.getY();

			message = new ArrayList<String>(Arrays.asList(listsatelite.get(i).getMessage()));

			messages.add(message);
		}
		try {

			System.out.println("llego");
			String resul = messageService.getMessages(messages);
			double[] resultado = locationService.getLocation(positions, distances);
			Position position = new Position();
			position.setX(resultado[0]);
			position.setY(resultado[1]);
			Top_Secret topsecretresponse = new Top_Secret();
			topsecretresponse.setMessage(resul);
			topsecretresponse.setPosition(position);

			return ResponseEntity.status(HttpStatus.OK).body(topsecretresponse);

		} catch (Exception e) {
			System.out.println("exeption" + e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}

	}

	// @GetMapping("/satelitesposition/{idsatelite}")
	@RequestMapping(path = "/satelitesposition/{idsatelite}", method = RequestMethod.GET)
	public Position satelitesposition(@PathVariable long idsatelite) {
		return positionRepository.findByidSatelite(idsatelite);
	}

	@RequestMapping(path = "/topsecret_split1/{satellite_neme}", method = RequestMethod.GET)
	public Satelite satelitesposition(@PathVariable String satellite_neme) {
		return sateliteService.findByName_Satelite(satellite_neme);
	}

	@RequestMapping(path = "/topsecret_split/{satellite_neme}", method = RequestMethod.POST)
	ResponseEntity<SateliteTop_split> satelitesposition1(@PathVariable String satellite_neme) {
		Satelite sat = sateliteService.findByName_Satelite(satellite_neme);
		SateliteTop_split satelite_split = new SateliteTop_split();
		satelite_split.setDistance(sat.getDistance());
		satelite_split.setMessage(sat.getMessage());
		return new ResponseEntity<>(satelite_split, HttpStatus.OK);
	}

	@RequestMapping(path = "/topsecret_split/{satellite_neme}", method = RequestMethod.GET)
	ResponseEntity<Top_Secret> satelitesposition2(@PathVariable String satellite_neme) {
		Satelite sat = sateliteService.findByName_Satelite(satellite_neme);
		Position position = positionRepository.findByidSatelite(sat.getIdSatelite());
		Top_Secret satelite_split = new Top_Secret();
		satelite_split.setPosition(position);
		String messageresultado = "";
		List<String> listastring = new ArrayList<>();
		listastring = Arrays.asList(sat.getMessage());
		for (int i = 0; i < listastring.size(); i++) {
			messageresultado = messageresultado + " " + listastring.get(i);

		}
		satelite_split.setMessage(messageresultado);

		return new ResponseEntity<>(satelite_split, HttpStatus.OK);
	}

}
