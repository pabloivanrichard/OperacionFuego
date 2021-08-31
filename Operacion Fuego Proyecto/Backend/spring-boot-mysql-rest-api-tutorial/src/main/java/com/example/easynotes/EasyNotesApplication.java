package com.example.easynotes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.easynotes.model.Position;
import com.example.easynotes.model.Satelite;
import com.example.easynotes.model.Ship;
import com.example.easynotes.model.Space;
import com.example.easynotes.repository.IPositionRepository;
import com.example.easynotes.repository.ISateliteRepository;
import com.example.easynotes.repository.IShipRepository;
import com.example.easynotes.repository.ISpaceRepository;

@SpringBootApplication
@EnableJpaAuditing
public class EasyNotesApplication {
	
	 @Autowired
	 private ISateliteRepository sateRepository;
	 
	 @Autowired
	 private IPositionRepository positionRepository;
	 
	 @Autowired
	 private ISpaceRepository spaceRepository;
	 @Autowired
	 private IShipRepository shipRepository;

	public static void main(String[] args) {
		SpringApplication.run(EasyNotesApplication.class, args);
		//inicializarDatos();
	}
	
	@Bean
	InitializingBean sendDatabase() {
		Satelite satelite=new Satelite();
		satelite.setDistance(100.0);
		satelite.setName("Kenobi");
		String message[]= {"este","", "","mensaje",""};
		satelite.setMessage(message);
		Position position1=new Position();
		position1.setX(-500);
		position1.setY(-200);
		position1.setSatelite(satelite);
		
		Satelite satelite2=new Satelite();
		satelite2.setDistance(115.5);
		satelite2.setName("skywalker");
		String message2[]= {"","es","","","secreto"};
		satelite2.setMessage(message2);
		Position position2=new Position();
		position2.setX(100);
		position2.setY(-100);
		position2.setSatelite(satelite2);
		
		Satelite satelite3=new Satelite();
		satelite3.setDistance(142.7);
		satelite3.setName("sato");
		String message3[]= {"este","","un","",""};
		satelite3.setMessage(message3);
		Position position3=new Position();
		position3.setX(500);
		position3.setY(100);
		position3.setSatelite(satelite3);
		
		//Nave
		Ship ship=new Ship();
		ship.setNameship("nave portacarga imperial");
		
		//space
	     Space space=new Space();
	     List<Satelite> satellites =new ArrayList<>();
	     satellites.add(satelite);
	     satellites.add(satelite2);
	     satellites.add(satelite3);
	     space.getSatellites().add(satelite);
	     space.getSatellites().add(satelite2);
	     space.getSatellites().add(satelite3);
		
	    return () -> {
	    	spaceRepository.save(space);
	    	positionRepository.save(position1);
	    	positionRepository.save(position2);
	    	positionRepository.save(position3);
	    	shipRepository.save(ship);
	      };

	   }
}
