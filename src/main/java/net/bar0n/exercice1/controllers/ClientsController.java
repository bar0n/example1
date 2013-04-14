
package net.bar0n.exercice1.controllers;

import net.bar0n.exercice1.dao.ClientDao;
import net.bar0n.exercice1.dao.ClientsDetailsDao;
import net.bar0n.exercice1.dao.WordTemplateDao;
import net.bar0n.exercice1.domain.Client;
import net.bar0n.exercice1.domain.ClientDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequestMapping("/clients")
@Controller
public class ClientsController {
    private static final Logger logger = LoggerFactory.getLogger(ClientsController.class);
	@Autowired
	private ClientDao clientDao;

    @Autowired
    private ClientsDetailsDao clientsDetailsDao;

    @Autowired
    WordTemplateDao wordTemplateDaoImpl;

    @RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
        logger.info("ClientsController!");
		List<Client> clients = clientDao.findAllClients();
		uiModel.addAttribute("clients", clients);
		return "clients/list";
	}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)    //HttpServletRequest request,HttpServletResponse response,
    public String show(@PathVariable("id") Long id, Model uiModel) {
        ClientDetail clientDetail = clientsDetailsDao.getDetailsByClientID(id);
        uiModel.addAttribute("clientDetail", clientDetail);
        return "clients/showdetails";
    }

    @RequestMapping(value = "/debts",method = RequestMethod.GET)
    public String listdebt(Model uiModel) {
        logger.info("ClientsController!");
        Map<Client,Double> clientsDebts = clientDao.getClientsDebts();
        List<Client> clients = new ArrayList<Client>(clientsDebts.keySet());
        uiModel.addAttribute("clients", clients);
        uiModel.addAttribute("mapdebt",clientsDebts );
        uiModel.addAttribute("templates",wordTemplateDaoImpl.findAllWordTemplates() );
        return "clients/listdebt";
    }
}
