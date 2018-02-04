package model.daoimpl;
import java.util.ArrayList;
import java.util.List;
import model.dao.ContactDao;
import model.entities.Contact;
import model.util.ConnectionConfig;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by yashjain on 1/11/18.
 */
public class ContactDaoImpl implements ContactDao {
    @Override
    public void insert(Contact contact) {
        Connection conn  = null;
        PreparedStatement preparedStatement = null;
        try{
            conn = ConnectionConfig.getConnection();
            preparedStatement = conn.prepareStatement("INSERT INTO mytable (contactno,name,id) VALUES (?,?,?)");

            preparedStatement.setString(1,contact.getNumber());
            preparedStatement.setString(2,contact.getName());
            preparedStatement.setInt(3,contact.getId());
            preparedStatement.executeUpdate();
            System.out.println("Inserted");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(preparedStatement !=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //.
    }

    @Override
    public List<Contact> fetch() {
        List<Contact> contacts = new ArrayList<>();
        Connection conn  = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            conn = ConnectionConfig.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM mytable");
            // result of query is stored in resultset.
            while(resultSet.next()){
                Contact contact = new Contact();
                contact.setName(resultSet.getString("name"));
                contact.setNumber(resultSet.getString("contactno"));
                contacts.add(contact);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(resultSet !=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement !=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    return contacts;
    }
}
