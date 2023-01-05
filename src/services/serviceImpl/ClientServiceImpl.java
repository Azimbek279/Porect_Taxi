package services.serviceImpl;

import dao.DataBase;
import model.Client;
import model.Taxi;
import model.enums.TaxiType;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class ClientServiceImpl implements services.ClientService {

    Scanner scanner = new Scanner(System.in);

    private DataBase dataBase = new DataBase();

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addClient(Client client) {
        try {

            for (Client dataBaseClient : dataBase.getClients()) {
                if (dataBaseClient.getId().equals(client.getId())) {
                    throw new RuntimeException("ID did not match!");
                }
                if (dataBaseClient.getDateOfBirth() == client.getDateOfBirth()) {
                    throw new RuntimeException("DateOfBirth did not match!");
                }
                if (dataBaseClient.getFullName().equals(client.getFullName())) {
                    throw new RuntimeException("FullName did not match!");
                }
                if (dataBaseClient.getMoney().intValue() < 0) {
                    throw new RuntimeException("Pls top up the money, if your money is less than 0.");
                }
                if (!dataBaseClient.getPhoneNumber().startsWith("+996") && client.getPhoneNumber().length() >= 13)
                    throw new RuntimeException("PhoneNumber did not match!");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        this.dataBase.getClients().add(client);
        return "Successfully!";
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
        for (Client client : dataBase.getClients()) {
            if (client.getId().equals(clientId)) {
                for (Taxi taxi : dataBase.getTaxis()) {
                    if (taxi.getTaxiType().equals(TaxiType.valueOf(taxiType))) {
                        int t = client.getMoney().intValue();
                        if (t >= taxi.getTaxiType().getPriceForLanding().intValue()) {
                            return taxi;
                        } else {
                            System.out.println("I don't have that much money.");
                        }
                    }
                }
            }

        }
        return null;

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
    public void universalSorting() {
        System.out.println("<<<COMMANDS>>>");
        System.out.println("""
                1-> sorted id,
                2 -> sorted full name,
                3 -> sorted date of birth,
                4 -> sorted phone number,
                5 -> sorted money
                """);
        while (true) {
            int number = scanner.nextInt();
            switch (number) {
                case 1 ->
                        dataBase.getClients().stream().sorted(Comparator.comparing(Client::getId)).forEach(System.out::println);
                case 2 ->
                        dataBase.getClients().stream().sorted(Comparator.comparing(Client::getFullName)).forEach(System.out::println);
                case 3 ->
                        dataBase.getClients().stream().sorted(Comparator.comparing(Client::getDateOfBirth)).forEach(System.out::println);
                case 4 ->
                        dataBase.getClients().stream().sorted(Comparator.comparing(Client::getPhoneNumber)).forEach(System.out::println);
                case 5 ->
                        dataBase.getClients().stream().sorted(Comparator.comparing(Client::getMoney)).forEach(System.out::println);


            }
        }
    }
}