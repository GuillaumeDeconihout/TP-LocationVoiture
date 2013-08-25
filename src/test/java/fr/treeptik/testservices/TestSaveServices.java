package fr.treeptik.testservices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.services.ClientService;
import fr.treeptik.locationvoiture.services.ReservationService;
import fr.treeptik.locationvoiture.services.VoitureService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/dispatcher-servlet.xml")
public class TestSaveServices {

	@Autowired
	private VoitureService voitureService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ReservationService reservationService;

	@Test
	public void TestSaveVoiture() {
		try {
			Voiture voiture = new Voiture(null,"Porsche","Cayen",new Date());
			voiture = voitureService.save(voiture);
			Assert.assertNotNull(voiture.getId());
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TestSaveClient() {
		try {
			Client client = new Client(null,"Penrt","Jeff","jpenrt@gmail.com");
			client = clientService.save(client);
			Assert.assertNotNull(client.getId());
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TestSaveReservation() {
		try {
			Voiture voiture = new Voiture(null,"Ferrari","F100",new Date());
			voiture = voitureService.save(voiture);
			
			Client client = new Client(null,"Prif","John","jprif@gmail.com");
			client = clientService.save(client);
			
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateReservation = new Date();
			Date datePriseVehicule = new Date();
			Date dateRetourVehicule = new Date();
			try {
				dateReservation = dateFormat.parse("21/07/2013");
				datePriseVehicule = dateFormat.parse("27/07/2013");
				dateRetourVehicule = dateFormat.parse("28/07/2013");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Reservation reservation = new Reservation(null,voiture,client,dateReservation,datePriseVehicule,dateRetourVehicule);
			reservation = reservationService.save(reservation);
			Assert.assertNotNull(reservation.getId());
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	

}
