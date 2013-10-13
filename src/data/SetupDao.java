package data;

import java.io.File;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;

public class SetupDao extends AbstractDao {

	public void createSchema() {
		executeSqlFromFile(getClassPathFile("schema.sql"));
	}

	public void addTestData() {
		executeSqlFromFile(getClassPathFile("sampleData.sql"));
	}

	public void clearData() {
		AbstractDao db = new AbstractDao() {
		};
		db.executeQuery("TRUNCATE TABLE unit");
	}

	private String getClassPathFile(String fileName) {
		return getClass().getClassLoader().getResource(fileName).getFile();
	}

	private void executeSqlFromFile(String sqlFilePath) {

		Project project = new Project();
		project.init();

		SQLExec e = new SQLExec();
		e.setProject(project);
		e.setTaskType("sql");
		e.setTaskName("sql");
		e.setSrc(new File(sqlFilePath));
		e.setDriver("org.hsqldb.jdbcDriver");
		e.setUserid("sa");
		e.setPassword("");
		e.setUrl(DB_URL);
		e.execute();
	}

	public boolean tableExists(String tableName) {
		boolean exists = false;
		try {
			DatabaseMetaData metaData = getConnection().getMetaData();
			ResultSet res = metaData.getTables(null, null,
					tableName.toUpperCase(), null);
			exists = res.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return exists;
	}
}