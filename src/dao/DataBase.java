package dao;

import model.Client;
import model.Driver;
import model.License;
import model.Taxi;

import java.util.Set;

public class DataBase {
    Set<Client> clients;
    Set<Driver>drivers;
    Set<Taxi>taxis;

    Set<License>licenses;

    public DataBase(Set<Client> clients, Set<Driver> drivers, Set<Taxi> taxis, Set<License> licenses) {
        this.clients = clients;
        this.drivers = drivers;
        this.taxis = taxis;
        this.licenses = licenses;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Taxi> getTaxis() {
        return taxis;
    }

    public void setTaxis(Set<Taxi> taxis) {
        this.taxis = taxis;
    }

    public Set<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(Set<License> licenses) {
        this.licenses = licenses;
    }

    @Override
    public String toString() {
        return "DataBase" +
                "\nClients: " + clients +
                "\nDrivers: " + drivers +
                "\nTaxis: " + taxis +
                "\nLicenses: " + licenses;
    }

}
