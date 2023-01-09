import model.Client;
import model.Driver;
import model.Taxi;
import model.enums.Gender;
import model.enums.TaxiType;
import services.serviceImpl.ClientServiceImpl;
import services.serviceImpl.DriverServiceImpl;
import services.serviceImpl.TaxiServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static Scanner glScanner = new Scanner(System.in);
    static Scanner scanner = new Scanner(System.in);
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("""
                    \n<*<*<*<*<*<*<*<*< GLOBAL COMMANDS >*>*>*>*>*>*>*>*>
                    ~ 1 ~ | Cross to Taxi methods
                    ~ 2 ~ | Cross to Client methods
                    ~ 3 ~ | Cross to Driver methods
                    ~ 0 ~ | Exit""");
            int command = glScanner.nextInt();
            if (command == 0) break;
            if (command == 1) {
                Taxi taxi1 = new Taxi(1L, "Toyota", "+996777700700", "Red", LocalDate.of(2011, 2, 27), TaxiType.COMFORT);
                Taxi taxi2 = new Taxi(2L, "Lexus", "+996500500500", "Blue", LocalDate.of(2021, 12, 7), TaxiType.BUSINESS);
                Taxi taxi3 = new Taxi(3L, "BMW", "+996222200200", "White", LocalDate.of(2010, 3, 17), TaxiType.STANDART);
                Taxi taxi4 = new Taxi(4L, "Ford", "+996700700000", "White", LocalDate.of(2008, 5, 12), TaxiType.STANDART);
                Taxi taxi5 = new Taxi(5L, "Tesla", "+996900900900", "White", LocalDate.of(2022, 6, 1), TaxiType.COMFORT);
                List<Taxi> taxis = new ArrayList<>(List.of(taxi1, taxi2, taxi3, taxi4, taxi5));

                TaxiServiceImpl taxiService = new TaxiServiceImpl();

                while (true) {
                    System.out.println(""" 
                            >>>>>>>>>>>> COMMANDS <<<<<<<<<<<
                            |1| -> Add Taxi by Object
                            |2| -> Add Taxi by List
                            |3| -> Find by initial letter
                            |4| -> Grouping
                            |5| -> Filter by taxi type
                            |6| -> Update
                            |7| -> Get Taxi by ID
                            |0| -> Break
                            """);

                    int cmd = scan.nextInt();
                    if (cmd == 0) break;
                    if (cmd == 1) System.out.println(taxiService.add(taxi4));
                    if (cmd == 2) System.out.println(taxiService.add(taxis));
                    if (cmd == 3) {
                        System.out.println("Enter car's model: ");
                        System.out.println(taxiService.findByInitialLetter(new Scanner(System.in).nextLine()));
                    }
                    if (cmd == 4) System.out.println(taxiService.grouping());
                    if (cmd == 5) {
                        System.out.println("Enter type to filter: ");
                        System.out.println(taxiService.filterByTaxiType(new Scanner(System.in).nextLine().toUpperCase()));
                    }
                    if (cmd == 6) {
                        System.out.println("Enter the ID to Update: ");
                        taxiService.update(new Scanner(System.in).nextLong());
                    }
                    if (cmd == 7) {
                        System.out.println("Enter the ID to find: ");
                        System.out.println(taxiService.getTaxiById(new Scanner(System.in).nextLong()));
                    }
                }
            } else if (command == 2) {

                List<Client> clients = new ArrayList<>(Arrays.asList(
                        new Client(1L, "AigerimBektenova", LocalDate.of(2005, 6, 21),
                                "+996700875997", new BigDecimal(34000)),
                        new Client(2L, "AkylaiAbdulakimova", LocalDate.of(2008, 2, 20),
                                "+996507147790", new BigDecimal(12300)),
                        new Client(3L, "OomatAbdulakimova", LocalDate.of(2008, 2, 23),
                                "+996700895643", new BigDecimal(4500))
                ));

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

                while (true) {
                    int num = scanner.nextInt();
                    switch (num) {
                        case 1:
                            System.out.println(service.addClient(new Client(4L, "MairambekRahmanov", LocalDate.of(2000, 8, 5),
                                    "+996708238754", new BigDecimal(7600))));
                            break;
                        case 2:
                            System.out.println(service.addClient(clients));
                            break;
                        case 3:
                            System.out.println(service.getClientByName("Aigerim"));
                            break;
                        case 4:
                            System.out.println(service.removeClientById(1L));
                            break;
                        case 5:
                            System.out.println(service.orderTaxi(1L, "Comfort"));
                            break;
                        case 6:
                            System.out.println(service.getClientAge());
                            break;
                        case 7:
                            service.universalSorting("Client universalMethod: ");
                        default:
                            System.out.println("THERE IS NO SUCH WAY!");
                    }
                }
            } else if (command == 3) {
                List<Driver>drivers = new ArrayList<>(Arrays.asList(
                        new Driver(2L,"Meder","Razakov",Gender.MALE,"0777-32-32-32",new BigDecimal(60000),TaxiType.BUSINESS),
                        new Driver(3L,"Ulan","Kairi",Gender.MALE,"0777-45-45-45",new BigDecimal(55000),TaxiType.STANDART),
                        new Driver(4L,"Uluk","Bakytov",Gender.MALE,"0777-56-56-56",new BigDecimal(60000),TaxiType.BUSINESS)
                ));

                DriverServiceImpl driverService = new DriverServiceImpl();
                while (true){
                    System.out.println(""" 
                            >>>>>>>>>>>> COMMANDS <<<<<<<<<<<
                            |1| -> Add Driver by Object
                            |2| -> Add Driver by List
                            |3| -> Find by id driver
                            |4| -> Find by name
                            |5| -> Assign Taxi To Driver
                            |6| -> Change Taxi or Driver
                            |7| -> Get Driver by Taxi Model
                            |8| -> Update Driver
                            |0| -> Break
                            """);
                    while(true){
                        int button = scanner.nextInt();
                        switch (button){
                            case 1:
                                System.out.println(driverService.add(new Driver(1L,"Beka","Arapov", Gender.MALE,"0777-88-88-90",new BigDecimal(55000),
                                        TaxiType.COMFORT)));
                                break;
                            case 2:
                                System.out.println(driverService.add(drivers));
                                break;
                            case 3:
                                System.out.println(driverService.findById(1L));
                                break;
                            case 4:
                                System.out.println(driverService.findByName("Meder"));
                                break;
                            case 5:
                                System.out.println(driverService.assignTaxiToDriver(1L,2L));
                                break;
                            case 6:
                                System.out.println(driverService.changeTaxiOrDriver(3L,2L));
                                break;
                            case 7:
                                System.out.println(driverService.getDriverByTaxiModel("Tesla"));
                                break;
                            case 8:
                                driverService.update("Beka");
                                break;
                        }
                    }
                }
            }else System.out.println("Please enter only <4> commands!");
        }
    }
}