package services;

import model.Client;
import model.Taxi;

import java.util.List;
import java.util.Map;

public interface ClientService {
    String addClient(Client client);
    List<Client> addClient(List<Client> clients);
    List<Client> getClientByName(String name);
    Client removeClientById(Long id);
    Taxi orderTaxi(Long clientId, String taxiType);
    Map<Integer, Client> getClientAge();
    void universalSorting();
}
