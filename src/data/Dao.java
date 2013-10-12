package data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Dao extends AbstractDao {

	public boolean deleteAll() throws SQLException {
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("DELETE FROM unit");
		} finally {
			closeResources();
		}
		return true;
	}

	public boolean deleteItem(int id) throws SQLException {
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("DELETE FROM unit WHERE id = " + id);
		} finally {
			closeResources();
		}
		return true;
	}

	public boolean addItem(String name, String code) throws SQLException {
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("INSERT INTO unit VALUES (NEXT VALUE FOR seq1), '"
					+ name + "', '" + code + "'");
		} finally {
			closeResources();
		}
		return true;
	}

	public List<Unit> search(String keyword) throws SQLException {
		List<Unit> items = new ArrayList<Unit>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM unit WHERE LCASE(name) LIKE '%"
					+ keyword.toLowerCase() + "%'");
			while (rs.next()) {
				Unit item = new Unit();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCode(rs.getString("code"));
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
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM unit");
			while (rs.next()) {
				Unit item = new Unit();
				item.setId(Integer.parseInt(rs.getString("id")));
				item.setName(rs.getString("name"));
				item.setCode(rs.getString("code"));
				items.add(item);
			}
		} finally {
			closeResources();
		}
		return items;
	}

}