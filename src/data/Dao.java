package data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.pept.transport.Connection;

public class Dao extends AbstractDao {

	public boolean deleteAll() throws SQLException {
		try {
			stmt = getConnection().createStatement();
			rset = stmt.executeQuery("DELETE FROM unit");
		} finally {
			closeResources();
		}
		return true;
	}

	public void deleteItem(int id) throws SQLException {
		try {
			pst = getConnection().prepareStatement("DELETE FROM unit WHERE id = ?;");
			pst.setInt(1, id);
			pst.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			closeResources();
		}
	}

	public void addItem(String name, String code) throws SQLException {
		try {
			pst = getConnection()
					.prepareStatement("INSERT INTO unit (id, name, code) VALUES (NEXT VALUE FOR seq1, ?, ?);");
			pst.setString(1, name);
			pst.setString(2, code);
			pst.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			closeResources();
		}
	}

	public List<Unit> search(String keyword) throws SQLException {
		List<Unit> items = new ArrayList<Unit>();
		try {
			stmt = getConnection().createStatement();
			rset = stmt
					.executeQuery("SELECT * FROM unit WHERE LCASE(name) LIKE '%"
							+ keyword.toLowerCase() + "%'");
			while (rset.next()) {
				Unit item = new Unit();
				item.setId(rset.getInt("id"));
				item.setName(rset.getString("name"));
				item.setCode(rset.getString("code"));
				items.add(item);
			}
		} finally {
			closeResources();
		}
		return items;
	}

	public List<Unit> findAllItems() throws SQLException {
		List<Unit> items = new ArrayList<Unit>();
		try {
			stmt = getConnection().createStatement();
			rset = stmt.executeQuery("SELECT * FROM unit");
			while (rset.next()) {
				Unit item = new Unit();
				item.setId(Integer.parseInt(rset.getString("id")));
				item.setName(rset.getString("name"));
				item.setCode(rset.getString("code"));
				items.add(item);
			}
		} finally {
			closeResources();
		}
		return items;
	}
}