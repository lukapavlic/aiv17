package si.um.feri.aiv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OsebaDao {

	DataSource baza;

	public OsebaDao() {
		try {
			baza=(DataSource)new InitialContext().lookup("java:jboss/datasources/ExampleDS");	
			kreirajTabele();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void kreirajTabele() throws Exception {
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			
			conn.createStatement().execute("create table if not exists jsfoseba(ime varchar, priimek varchar, email varchar, cas timestamp)");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public Oseba najdi(String email) throws Exception {
		System.out.println("DAO: i��em "+email);
		Oseba ret = null;
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from jsfoseba where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ret = new Oseba(rs.getString("ime"), rs.getString("priimek"), email);
				ret.getDatumVpisa().setTimeInMillis(rs.getTimestamp("cas").getTime());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ret;
	}

	public void shrani(Oseba o) throws Exception {
		System.out.println("DAO: shranjujem "+o);
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();
			if (najdi(o.getEmail()) != null) {
				PreparedStatement ps = conn.prepareStatement("update jsfoseba set ime=? , priimek=? , cas=? where email=?");
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.setTimestamp(3, new Timestamp(o.getDatumVpisa().getTimeInMillis()));
				ps.setString(4, o.getEmail());
				ps.executeUpdate();
			} else {
				PreparedStatement ps = conn.prepareStatement("insert into jsfoseba(ime , priimek, email, cas ) values (?,?,?,?)");
				ps.setString(1, o.getIme());
				ps.setString(2, o.getPriimek());
				ps.setString(3, o.getEmail());
				o.setDatumVpisa(new GregorianCalendar());
				ps.setTimestamp(4, new Timestamp(o.getDatumVpisa().getTimeInMillis()));
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public List<Oseba> vrniVse() throws Exception {
		System.out.println("DAO: vra�am vse");
		List<Oseba> ret = new ArrayList<Oseba>();
		//try (Connection conn=baza.getConnection()) {
		Connection conn=null;
		try {
			conn=baza.getConnection();

			ResultSet rs=conn.createStatement().executeQuery("select * from jsfoseba");
			while (rs.next()) {
				Oseba o = new Oseba(rs.getString("ime"), rs.getString("priimek"), rs.getString("email"));
				o.getDatumVpisa().setTimeInMillis(rs.getTimestamp("cas").getTime());
				ret.add(o);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return ret;
	}

}