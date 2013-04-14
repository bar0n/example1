package net.bar0n.exercice1.dao;

import net.bar0n.exercice1.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: bar0n
 * Date: 10.04.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */

@Repository("clientDao")
public class ClientDaoImpl implements ClientDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Client> findAllClients() {
        String sql = "select id, first_name, last_name,photo_path from clients";
        return jdbcTemplate.query(sql, new ContactMapper());
    }

    @Override
    public Client getClientbyID(long id) {
        String sql = "select id, first_name, last_name, photo_path from clients where id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id} ,new ContactMapper());
    }

    @Override
    public void updatePhotoPath(long id,String path) {
        jdbcTemplate.update("update clients set photo_path = ? where id = ?",new Object[]{path,id});
    }

    @Override
    public Map<Client, Double> getClientsDebts() {
        String sql = "select a.*,b.debt from clients a left join clients_debt b on a.id = b.client_id";
        return (Map<Client, Double>)jdbcTemplate.query(sql,new MapExtractor());  //To change body of implemented methods use File | Settings | File Templates.
    }

    private static final class ContactMapper implements RowMapper<Client> {

        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {

            Client client = new Client();
            client.setId(rs.getLong("id"));
            client.setFirstName(rs.getString("first_name"));
            client.setLastName(rs.getString("last_name"));
            client.setPhotoPath(rs.getString("photo_path"));

            return client;
        }

    }

    private static class MapExtractor implements ResultSetExtractor<Map<Client, Double>> {
        @Override
        public Map<Client, Double> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Client, Double> map = new HashMap<Client, Double>();

            ContactMapper contactMapper = new ContactMapper();
            int i=1;
            while (rs.next()) {
                Client client = contactMapper.mapRow(rs, i++);
                map.put(client, rs.getDouble("debt"));
            }
            return map;
        }
    }
}
