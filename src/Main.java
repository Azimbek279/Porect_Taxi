import model.Client;
import model.Taxi;
import model.enums.TaxiType;
import services.serviceImpl.ClientServiceImpl;
import services.serviceImpl.TaxiServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        Taxi taxi1 = new Taxi(1L,"Toyota","+996777700700","Red", LocalDate.of(2011,2,27), TaxiType.COMFORT);
//        Taxi taxi2 = new Taxi(2L,"Lexus","+996500500500","Blue",LocalDate.of(2021,12,7), TaxiType.BUSINESS);
//        Taxi taxi3 = new Taxi(3L,"BMW","+996222200200","White",LocalDate.of(2010,3,17), TaxiType.STANDART);
//        List<Taxi> taxis = new ArrayList<>(List.of(taxi1,taxi2,taxi3));
//
//        TaxiServiceImpl taxiService = new TaxiServiceImpl();
//        System.out.println(taxiService.add(taxi2));
//        System.out.println(taxiService.add(taxis));
//        System.out.println(taxiService.findByInitialLetter("Lexus"));
//        System.out.println(taxiService.grouping());
//        System.out.println(taxiService.filterByTaxiType("BUSINESS"));
//        taxiService.update(1L);


        List<Client> clients = new ArrayList<>(Arrays.asList(
                new Client(1L, "AigerimBektenova", LocalDate.of(2005,6,21),
                        "+996700875997", new BigDecimal(34000)),
                new Client(2L, "AkylaiAbdulakimova", LocalDate.of(2008,2,20),
                        "+996507147790", new BigDecimal(12300)),
                new Client(3L, "OomatAbdulakimova", LocalDate.of(2008,2,23),
                        "+996700895643", new BigDecimal(4500))
        ));
        Client client4 = new Client(4L, "MairambekRahmanov", LocalDate.of(2000,8,5),
                "+996708238754", new BigDecimal(7600));


        ClientServiceImpl service = new ClientServiceImpl();


        System.out.println("<<<COMMANDS>>>");
        System.out.println("""
                1-button-> addClient
                2-button-> addClients
                3-button-> getClientByName
                4-button-> removeClientById
                5-button-> orderTaxi
                6-button-> getClientAge
                7-button->universalSorting
                """);

        while (true){
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    service.addClient(client4);
                    break;
                case 2:
                    service.addClient(clients);
                    break;
                case 3:
                    service.getClientByName("Aigerim");
                    break;
                case 4:
                    service.removeClientById(1L);
                    break;
                case 5:
                    service.orderTaxi(1L, String.valueOf(TaxiType.STANDART));
                    break;
                case 6:
                    service.getClientAge();
                    break;
                case 7:
                    service.universalSorting();
                default:
                    System.out.println("THERE IS NO SUCH WAY!");
            }
        }

    }
}