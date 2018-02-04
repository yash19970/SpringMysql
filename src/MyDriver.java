import model.entities.Contact;
import model.util.ConnectionConfig;
import model.daoimpl.ContactDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class MyDriver {
    public static void main(String[] args){
        Connection conn =null;
        try{
            conn = ConnectionConfig.getConnection();
            if(conn !=null){
                System.out.println("Done");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

       /* ContactDaoImpl obj = new ContactDaoImpl();
        Contact cont = new Contact(2,"yash", "99283");
        obj.insert(cont);*/

        /*List<Contact> contacts  = obj.fetch();
        for( Contact contact: contacts ){
            System.out.println(contact.getName());
            System.out.println(contact.getNumber());
        } */
    }
}