package it.progettogestionale.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import it.progettogestionale.web.GestionaleConfig;
import it.progettogestionale.web.dao.RescanDao;
import it.progettogestionale.web.model.Rescan;

public class RescanDaoImpl implements RescanDao {
	
	@PersistenceContext
	private EntityManager em;
	
//	private GestionaleConfig gc;

	@Override
	public Rescan getById(int id) {
		return em.find(Rescan.class, id);
	}

	@Override
	@Transactional
	public void add(Rescan r) {
		em.persist(r);
	}

	@Override
	@Transactional
	public void update(Rescan r) {
		em.merge(r);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Rescan r = getById(id);
		em.remove(r);
	}

//	@Override
//	public void emptyCheck(Rescan r) {
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		String query = "SELECT COUNT(idrescan) FROM rescan";
//		Connection conn = (Connection) gc.getDbConnection();
//		try {
//			stmt = conn.prepareStatement(query);
//			rs = stmt.executeQuery();
//			boolean empty = true;
//			while(rs.next()){
//				empty = false;
//			}
//			if(empty) {
//				em.persist(r);
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
}
