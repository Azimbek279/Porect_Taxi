package services.serviceImpl;

import dao.DataBase;
import model.Client;
import model.Driver;
import model.Taxi;
import model.enums.TaxiType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class ClientServiceImpl implements services.ClientService {

    Scanner scanner = new Scanner(System.in);

    private DataBase dataBase;

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addClient(Client client) {
        return "Client added!";
    }

    @Override
    public List<Client> addClient(List<Client> clients) {
        List<Client> clientList = new ArrayList<>();
        this.dataBase.getClients().addAll(clients);
        return clientList;
    }

    @Override
    public List<Client> getClientByName(String name) {
        List<Client> clientList = new ArrayList<>();
        for (Client client : dataBase.getClients()) {
            String[] name1 = client.getFullName().split(" ");
            if (name1[0].equals(name)) {
                clientList.add(client);
            }
        }

        return clientList;
    }

    @Override
    public Client removeClientById(Long id) {
        for (Client client : dataBase.getClients()) {
            if (client.getId().equals(id)) {
                dataBase.getClients().remove(client);
                return client;
            }

        }
        return null;
    }

    @Override
    public Taxi orderTaxi(Long clientId, String taxiType) {
        Driver driver = new Driver();
        Taxi result = null;
        for (Client client : dataBase.getClients()) {
          if (client.getId().equals(clientId)){
              System.out.println("How many km do you travel?");
              int km = new Scanner(System.in).nextInt();

              for (Taxi taxi : dataBase.getTaxis()) {
                  if (taxi.getTaxiType().name().equals(taxiType)){
                      result = driver.getTaxi1();

                      BigDecimal clientMoney = client.getMoney().subtract(BigDecimal.
                              valueOf((TaxiType.valueOf(taxiType).getPricePerKM().doubleValue() * km) + TaxiType.valueOf(taxiType).getPriceForLanding().doubleValue()));

                      BigDecimal driverMoney = client.getMoney().add(BigDecimal.
                              valueOf((TaxiType.valueOf(taxiType).getPricePerKM().doubleValue() * km) + TaxiType.valueOf(taxiType).getPriceForLanding().doubleValue()));
                      client.setMoney(clientMoney);
                      client.setMoney(driverMoney);
                  }

              }
          }

        }
        return result;

    }

    @Override
    public Map<Integer, Client> getClientAge() {
        Map<Integer, Client> map = new HashMap<>();
        for (Client client : this.dataBase.getClients()) {
            int age = Period.between(client.getDateOfBirth(), LocalDate.now()).getYears();
            map.put(age, client);
        }
        return map;
    }

    @Override
    public void universalSorting(String word) {
        System.out.println("<<<COMMANDS>>>");
        System.out.println("""
                1-> sorted id,
                2 -> sorted full name,
                3 -> sorted date of birth,
                4 -> sorted phone number,
                5 -> sorted money
                """);
        while (true) {
            switch (word) {
                case "ID: " ->
                        System.out.println(dataBase.getClients().stream().sorted(Comparator.comparing(Client::getId)).toList());
                case "FullName: " ->
                        System.out.println(dataBase.getClients().stream().sorted(Comparator.comparing(Client::getFullName)).toList());
                case "DateOfBirth: " ->
                        System.out.println(dataBase.getClients().stream().sorted(Comparator.comparing(Client::getDateOfBirth)).toList());
                case "PhoneNumber: " ->
                        System.out.println(dataBase.getClients().stream().sorted(Comparator.comparing(Client::getPhoneNumber)).toList());
                case "Money: " ->
                        System.out.println(dataBase.getClients().stream().sorted(Comparator.comparing(Client::getMoney)).toList());


            }
        }
    }
}