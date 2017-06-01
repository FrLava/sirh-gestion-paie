package dev.paie.service;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Grade (code, nbHeuresBase, tauxBase) VALUES(?,?,?)";
		this.jdbcTemplate.update(sql,nouveauGrade.getCode() , nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase() );
	}

	@Override
	public void mettreAJour(Grade grade) {
		// TODO Auto-generated method stub
		String sql = "UPDATE grade SET code = ? WHERE ID = ? ";
		this.jdbcTemplate.update(sql, grade.getCode(), 2);

	}

	@Override
	public List<Grade> lister() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM grade";
		return this.jdbcTemplate.query(sql,(rs,rowNumber)-> {
			Grade g = new Grade();
			g.setId(rs.getInt("id"));
			g.setCode(rs.getString("code"));
			g.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
			g.setTauxBase(rs.getBigDecimal("tauxBase"));
			return g;
			});
		
		
	}
	

}
