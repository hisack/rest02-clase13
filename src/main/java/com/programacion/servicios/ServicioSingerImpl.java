
package com.programacion.servicios;
import com.programacion.db.Singer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class ServicioSingerImpl implements ServicioSinger
{

    @Inject private DataSource dataSource;
    @Override
    public List<Singer> findAll(){

        Connection con = null;
        List<Singer> ret = new ArrayList<>();
        try{



            con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from singer order by first_name");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Singer obj = new Singer ();
                obj.setId(rs.getInt("id"));
                obj.setFirstName(rs.getString("first_name"));
                obj.setLastName(rs.getString("last_name"));
                obj.setLastName(rs.getString("birth_date"));
                ret.add(obj);
            }

            rs.close();
            pstmt.close();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally{
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return ret;
    }



}