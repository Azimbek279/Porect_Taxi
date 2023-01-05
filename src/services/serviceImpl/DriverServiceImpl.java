package services.serviceImpl;

import dao.DataBase;
import model.Driver;
import model.Taxi;
import model.enums.TaxiType;
import services.DriverService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DriverServiceImpl implements DriverService {

    DataBase dataBase;

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Driver add(Driver driver) {
        this.dataBase.getDrivers().add(driver);
        return null;
    }

    @Override
    public List<Driver> add(List<Driver> drivers) {
        List<Driver>listDr = new ArrayList<>();
        this.dataBase.getDrivers().addAll(listDr);
        return listDr;
    }

    @Override
    public Driver findById(Long id) {
        for (Driver driver: dataBase.getDrivers()) {
            if (driver.getId() == id){
                dataBase.getDrivers().add(driver);
                return driver;
            }
        }
        return null;
    }

    @Override
    public List<Driver> findByName(String name) {
        List<Driver>listDriver = new ArrayList<>();
        for (Driver driver: dataBase.getDrivers()) {
            if (driver.getName().equals(name)){
                dataBase.getDrivers().add(driver);
            }

        }
        return listDriver;
    }

    @Override
    public String assignTaxiToDriver(Long taxiId, Long driverId) {
        DataBase database = new DataBase();
        Driver acDriver = null;
        Taxi acTaxi = null;
        for (Driver driver : database.getDrivers()) {
            if (Objects.equals(driver.getId(), driverId)) {
                acDriver = driver;
            }
        }
        for (Taxi taxi : database.getTaxis()) {
            if (Objects.equals(taxiId, taxi.getId())) {
                acTaxi = taxi;
            }
        }
        assert acDriver != null;
        acDriver.setTaxi(acTaxi);
        return "successfully assigned!!";
    }

    @Override
    public String changeTaxiOrDriver(Long driverId, Long taxiId) {
        Driver Driver = null;
        Taxi Taxi = null;

        DataBase database = new DataBase();
        for (Taxi taxi1 : database.getTaxis()) {
            if (Objects.equals(taxi1.getId(), taxiId)) {
                Taxi = taxi1;
            }
        }
        for (Driver driver1 : database.getDrivers()) {
            if (Objects.equals(driver1.getId(), driverId)) {
                Driver = driver1;
            }
        }
        assert Driver != null;
        Driver.setTaxi(Taxi);

        return "changed!";
    }

    @Override
    public List<Driver> getDriverByTaxiModel(String model) {
        List<Driver> drivers = new ArrayList<>();
        for (Driver driver : dataBase.getDrivers()) {
            if (driver.getName().equals(model)){
                dataBase.getDrivers().add(driver);
            }
        }
        return drivers;
    }

    @Override
    public void update(String driverName) {
        for (Driver driver : dataBase.getDrivers()) {
            if (driver.getName().equals(driverName)) {
                System.out.println(driver);
            }
        }
    }
}
