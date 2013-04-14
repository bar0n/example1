package net.bar0n.exercice1.domain;

/**
 * Created with IntelliJ IDEA.
 * User: bar0n
 * Date: 12.04.13
 * Time: 8:12
 * To change this template use File | Settings | File Templates.
 */
public class ClientDetail {
    private long id;
    private Client client;
    private String tel_type;
    private String tel_number;
    private String ur_address;
    private String fiz_address;
    private String email;
    private String city;
    private String inn;
    private String edrpo;
    private String comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTel_type() {
        return tel_type;
    }

    public void setTel_type(String tel_type) {
        this.tel_type = tel_type;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public String getUr_address() {
        return ur_address;
    }

    public void setUr_address(String ur_address) {
        this.ur_address = ur_address;
    }

    public String getFiz_address() {
        return fiz_address;
    }

    public void setFiz_address(String fiz_address) {
        this.fiz_address = fiz_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getEdrpo() {
        return edrpo;
    }

    public void setEdrpo(String edrpo) {
        this.edrpo = edrpo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}


