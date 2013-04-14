
package net.bar0n.exercice1.controllers;

import net.bar0n.exercice1.dao.ClientDao;
import net.bar0n.exercice1.dao.ClientsDetailsDao;
import net.bar0n.exercice1.domain.Client;
import net.bar0n.exercice1.domain.ClientDetail;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;


@Controller
public class PhotoController {
    private static final Logger logger = LoggerFactory.getLogger(PhotoController.class);
    static private   String PATH = "C:\\photo\\";

    @Autowired
    private ClientsDetailsDao clientsDetailsDao;

    @Autowired
    private ClientDao clientDao;

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showPhotoDetails(@PathVariable("id") Long id, Model uiModel) {
        ClientDetail clientDetail = clientsDetailsDao.getDetailsByClientID(id);
      //  uiModel.addAttribute("clientDetail", clientDetail);
        uiModel.addAttribute("client", clientDetail.getClient());

        System.out.println("getPhotoPath: " + clientDetail.getClient().getPhotoPath());
        return "clients/upload";
    }

    @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] downloadPhoto(@PathVariable("id") Long id) {
        Client client = clientDao.getClientbyID(id);
        byte[] fileContent = null;
        try {
            InputStream inputStream = new FileInputStream(PATH+client.getPhotoPath());
            if (inputStream == null) logger.info("File inputstream is null");
            fileContent = IOUtils.toByteArray(inputStream);

        } catch (IOException ex) {
            logger.error("Error download Photo ");
            ex.printStackTrace();
        }

        return fileContent;
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String create(@PathVariable("id") Long id, Model uiModel,
                         HttpServletRequest httpServletRequest, @RequestParam("name") String name,
                         @RequestParam(value = "file", required = false) Part file) {

        Client client = clientDao.getClientbyID(id);
        logger.info("Contact id: " + client.getId());


        String ext = getExtension(new File(name));

        if (file != null) {
            logger.info("File name: " + file.getName());
            logger.info("File size: " + file.getSize());
            logger.info("File content type: " + file.getContentType());
            try {
                InputStream inputStream = file.getInputStream();
                if (inputStream == null) logger.info("File inputstream is null");
                IOUtils.copy(inputStream, new FileOutputStream(PATH + client.getId() + "." + ext));
            } catch (IOException ex) {
                logger.error("Error saving uploaded file");
                ex.printStackTrace();
            }

        }
        clientDao.updatePhotoPath(client.getId(),""+client.getId() + "." + ext);
        return "redirect:/show/" + client.getId();
    }
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
