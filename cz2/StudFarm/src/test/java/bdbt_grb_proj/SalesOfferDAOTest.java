package bdbt_grb_proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class SalesOfferDAOTest {

	private SalesOfferDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		datasource.setUsername("RADEK");
		datasource.setPassword("Studiaauto17");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		dao = new SalesOfferDAO(new JdbcTemplate(datasource));
		
	}

	@Test
	void testList() {
		List<SalesOffer> listSalesOffer = dao.list();
		assertTrue(!listSalesOffer.isEmpty());
		
	}

	@Test
	void testSave() {
		SalesOffer salesOffer = new SalesOffer(0,"NIEAKTYWNA",3299.99f,19);
		dao.save(salesOffer);
	}

	@Test
	void testGet() {
		int id = 6;
		SalesOffer salesOffer = dao.get(id);
		assertNotNull(salesOffer);
	}

	@Test
	void testUpdate() {
		SalesOffer salesOffer = new SalesOffer();
		salesOffer.setId(24);
		salesOffer.setStatus("AKTYWNA");
		salesOffer.setPrice(4399.99f);
		salesOffer.setHorseId(19);
		
		dao.update(salesOffer);	
	}

	@Test
	void testDelete() {
		int id = 33;
		dao.delete(id);
	}

}
