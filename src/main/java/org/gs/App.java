package org.gs;

import org.gs.entity.Client;
import org.gs.entity.Planet;
import org.gs.entity.Ticket;
import org.gs.services.ClientCrudService;
import org.gs.services.PlanetCrudService;
import org.gs.services.TicketCrudService;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

        // Create a new client
        Client additionalClient = new Client();
        additionalClient.setName("Test");
        clientCrudService.createClient(additionalClient);

        // Get the client by ID
        Client clientById = clientCrudService.getClientById(4L);
        System.out.println("clientById = " + clientById);

        //Update the client
        Client clientToUpdate = clientCrudService.getClientById(6L);
        clientToUpdate.setName("Updated Client6");
        clientCrudService.updateClient(clientToUpdate);

        // Delete the client
        clientCrudService.deleteClient(2L);

        // Get all clients
        List<Client> allClients = clientCrudService.getAllClients();
        for (Client clientEntry : allClients) {
            System.out.println(clientEntry);
        }

        // Create a new planet
        Planet additionalPlanet = new Planet();
        additionalPlanet.setId("PLU");
        additionalPlanet.setName("Pluto");
        planetCrudService.createPlanet(additionalPlanet);

        // Get the planet by ID
        Planet planetById = planetCrudService.getPlanetById("VEN");
        System.out.println("planetById = " + planetById);

        // Update the planet
        Planet planetToUpdate = planetCrudService.getPlanetById("MAR");
        planetToUpdate.setName("Mars23");
        planetCrudService.updatePlanet(planetToUpdate);

        // Delete the planet
        planetCrudService.deletePlanet("MER");

        // Get all planets
        List<Planet> allPlanets = planetCrudService.getAllPlanets();
        for (Planet planetEntry : allPlanets) {
            System.out.println(planetEntry);
        }

        // Create a new ticket
        Ticket additionalTicket = new Ticket();
        additionalTicket.setCreatedAt(LocalDateTime.now());
        additionalTicket.setClient(clientCrudService.getClientById(8L));
        additionalTicket.setFromPlanetId(planetCrudService.getPlanetById("JUP"));
        additionalTicket.setToPlanetId(planetCrudService.getPlanetById("EAR"));
        ticketCrudService.createTicket(additionalTicket);

        // Get ticket by ID
        Ticket ticketById = ticketCrudService.getTicketById(5L);
        System.out.println("ticketById = " + ticketById);

        // Update the ticket
        Ticket ticketToUpdate = ticketCrudService.getTicketById(6L);
        ticketToUpdate.setToPlanetId(planetCrudService.getPlanetById("MAR"));
        ticketCrudService.updateTicket(ticketToUpdate);

        // Delete the ticket
        ticketCrudService.deleteTicket(4L);

        // Get all tickets
        ticketCrudService.getAllTickets();

    }
}