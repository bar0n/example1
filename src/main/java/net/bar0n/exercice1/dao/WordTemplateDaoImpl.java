package net.bar0n.exercice1.dao;

import net.bar0n.exercice1.domain.WordTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bar0n
 * Date: 14.04.13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */

@Repository(value = "wordTemplateDaoImpl")
public class WordTemplateDaoImpl implements WordTemplateDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<WordTemplate> findAllWordTemplates() {

        return jdbcTemplate.query("select id,name from wordtemplate",new BeanPropertyRowMapper( WordTemplate.class));
    }

}
