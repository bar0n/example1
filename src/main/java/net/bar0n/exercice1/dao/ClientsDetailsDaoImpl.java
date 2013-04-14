package net.bar0n.exercice1.dao;

import net.bar0n.exercice1.domain.ClientDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: bar0n
 * Date: 12.04.13
 * Time: 8:17
 * To change this template use File | Settings | File Templates.
 */
@Repository(value = "clientsDetailsDao")
public class ClientsDetailsDaoImpl implements ClientsDetailsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ClientDao clientDao;

    public ClientDetail getDetailsByClientID(long clientID) {

        String sql = "SELECT id, client_id,tel_type,tel_number," +
                "ur_address,fiz_address,email,city,inn,edrpo,comments FROM client_details WHERE client_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{clientID}, new ClientDetailMapper(clientDao));
    }

    static public class ClientDetailMapper implements RowMapper<ClientDetail> {

        private ClientDao clientDao;

        public ClientDetailMapper(ClientDao clientDao) {
            this.clientDao = clientDao;
        }

        @Override
        public ClientDetail mapRow(ResultSet rs, int rowNum) throws SQLException {

            ClientDetail clientDetail = new ClientDetail();
            clientDetail.setId(rs.getLong("id"));
            clientDetail.setCity(rs.getString("city"));
            clientDetail.setClient(clientDao.getClientbyID(rs.getLong("client_id")));
            clientDetail.setComments(rs.getString("comments"));
            clientDetail.setEdrpo(rs.getString("edrpo"));
            clientDetail.setEmail(rs.getString("email"));
            clientDetail.setFiz_address(rs.getString("fiz_address"));
            clientDetail.setTel_number(rs.getString("tel_number"));
            clientDetail.setTel_type(rs.getString("tel_type"));
            clientDetail.setUr_address(rs.getString("ur_address"));

            return clientDetail;

        }
    }
}
