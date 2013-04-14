package net.bar0n.exercice1.dao;

import net.bar0n.exercice1.domain.Client;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: bar0n
 * Date: 10.04.13
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
public interface ClientDao {
    List<Client> findAllClients();
    Client getClientbyID(long id);
    void updatePhotoPath(long id,String path);
    Map<Client,Double> getClientsDebts();
}
