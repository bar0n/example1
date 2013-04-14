package net.bar0n.exercice1.dao;

import net.bar0n.exercice1.domain.ClientDetail;

/**
 * Created with IntelliJ IDEA.
 * User: bar0n
 * Date: 11.04.13
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
public interface ClientsDetailsDao {
   ClientDetail getDetailsByClientID(long id);
}
