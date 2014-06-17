package com.victorarana.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.victorarana.springmvc.dto.DTOVideo;

@Component("DAOVideo")
public class DAOVideo implements DAOVideoInterface{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void createVideo(DTOVideo video) {
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(video);
		session.getTransaction().commit();
		session.close();		
	}

	public DTOVideo retrieveById(Integer videoId) {
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		DTOVideo video = (DTOVideo) session.get(DTOVideo.class, videoId);
		session.getTransaction().commit();
		session.close();		
		
		return video;
	}
	
	public DTOVideo retrieveByTitulo(String titulo){
		Session session = sessionFactory.openSession();
		
		// Programmatic transactions
		session.beginTransaction();
		
		// Criteria
		Criteria criterio = session.createCriteria(DTOVideo.class);
		criterio.add(Restrictions.eq("titulo", titulo));
		DTOVideo video = (DTOVideo) criterio.uniqueResult();
		
		session.getTransaction().commit();
		session.close();		
		return video;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DTOVideo> retrieveByDescripcion(String descripcion) {
		Session session = sessionFactory.openSession();
		
		// Programmatic transactions
		session.beginTransaction();
		
		// Criteria
		Criteria criterio = session.createCriteria(DTOVideo.class);
		criterio.add(Restrictions.like("descripcion","%" + descripcion + "%"));
		
		List<DTOVideo> videos = criterio.list();
		
		session.getTransaction().commit();
		session.close();
		return videos;
	}

	public boolean updateVideo(DTOVideo video) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteVideo(DTOVideo video) {
		// TODO Auto-generated method stub
		return false;
	}
}