package net.bar0n.exercice1.dao;

import net.bar0n.exercice1.domain.WordTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bar0n
 * Date: 10.04.13
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
public interface WordTemplateDao {
    List<WordTemplate> findAllWordTemplates();
}
