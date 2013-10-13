package listener;

import javax.servlet.ServletContextEvent;
import data.SetupDao;

public class ServletContextListener implements
		javax.servlet.ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		SetupDao setup = new SetupDao();
		if (!setup.tableExists("unit")) {
			setup.createSchema();
			setup.addTestData();
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
