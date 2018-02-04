package model.dao;

import model.entities.Contact;
import java.util.List;
public interface ContactDao {

    void insert(Contact contact);
    // here
    public List<Contact> fetch();

}
