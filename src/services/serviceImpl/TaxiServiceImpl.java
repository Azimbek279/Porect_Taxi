package services.serviceImpl;

import dao.DataBase;
import model.Taxi;
import model.enums.TaxiType;
import services.TaxiService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaxiServiceImpl implements TaxiService {
    DataBase dataBase = new DataBase();

    @Override
    public StringBuilder add(Taxi taxi) {
        Set<Taxi> taxis = new HashSet<>();
        boolean isTrue = false;
        if (taxi.getYear().isAfter(LocalDate.of(2010,12,31))){
            isTrue = taxis.add(taxi);
            dataBase.setTaxis(taxis);
        }
        return isTrue ? new StringBuilder("----->  Successfully added!"):new StringBuilder("----->  Not added maybe because of the date!");

    }

    @Override
    public StringBuilder add(List<Taxi> taxis) {
        Set<Taxi> taxiSet = new HashSet<>();
        boolean isTrue = false;
        isTrue = taxiSet.addAll(taxis);
        dataBase.setTaxis(taxiSet);
        return isTrue ? new StringBuilder("----->  Successfully added!"):new StringBuilder("----->  Not added!");
    }

    @Override
    public List<Taxi> findByInitialLetter(String model) {
        List<Taxi> taxis = new ArrayList<>();
        for (Taxi taxi : dataBase.getTaxis()) {
            if(taxi.getModel().trim().startsWith(String.valueOf(model.toUpperCase().charAt(0)))){
                taxis.add(taxi);
            }
        }
        return taxis;
    }

    @Override
    public Map<TaxiType, List<Taxi>> grouping() {
        return dataBase.getTaxis().stream().collect(Collectors.groupingBy(Taxi::getTaxiType));
    }

    @Override
    public List<Taxi> filterByTaxiType(String taxiType) {
        return dataBase.getTaxis().stream().filter(s->s.getTaxiType().name().equals(taxiType.toUpperCase())).toList();
    }

    @Override
    public void update(Long id) {
        for (Taxi taxi : dataBase.getTaxis()) {
            if(taxi.getId().equals(id)){
                System.out.println("What do you want to change?");
                String cmd = new Scanner(System.in).nextLine();
                if (cmd.equalsIgnoreCase("ID")){
                    System.out.println("Enter new ID: ");
                    taxi.setId(new Scanner(System.in).nextLong());
                    System.out.println("Successfully updated!");
                }if (cmd.equalsIgnoreCase("MODEL")){
                    System.out.println("Enter new MODEL: ");
                    taxi.setModel(new Scanner(System.in).nextLine());
                    System.out.println("Successfully updated!");
                }if (cmd.equalsIgnoreCase("NUMBER")){
                    System.out.println("Enter new NUMBER: ");
                    taxi.setNumber(new Scanner(System.in).nextLine());
                    System.out.println("Successfully updated!");
                }if (cmd.toUpperCase().equals("COLOUR")){
                    System.out.println("Enter new COLOUR: ");
                    taxi.setColour(new Scanner(System.in).nextLine());
                    System.out.println("Successfully updated!");
                }if (cmd.toUpperCase().equals("YEAR")){
                    System.out.println("Enter new YEAR (first year, then month, last day): ");
                    taxi.setYear(LocalDate.of(new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt(),new Scanner(System.in).nextInt()));
                    System.out.println("Successfully updated!");
                }if (cmd.toUpperCase().equals("TAXI TYPE")){
                    try {
                        System.out.println("Enter new TAXI TYPE: ");
                        taxi.setTaxiType(TaxiType.valueOf(new Scanner(System.in).nextLine()));
                        System.out.println("Successfully updated!");
                    }catch (Exception e){
                        System.out.println("Please check only the taxi type in the listing!");
                    }
                }
            }
        }
    }

    @Override
    public List<Taxi> getTaxiById(long id) {
        List<Taxi> taxiList = new ArrayList<>();
        for (Taxi taxi : dataBase.getTaxis()) {
            if (taxi.getId().equals(id)){
                taxiList.add(taxi);
                return taxiList;
            }
        }
        return null;
    }
}
