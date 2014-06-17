package com.victorarana.springmvc.dao;

import java.util.List;

import com.victorarana.springmvc.dto.DTOVideo;

/**
 * This interface defines the standard operations to be performed on a 
 * model object(s)
 * 
 * @author Victor José Arana Rodríguez
 * @since Junio, 2014
 */

public interface DAOVideoInterface {
	
	public void  createVideo(DTOVideo video);
	public DTOVideo retrieveById(Integer videoId);
	public DTOVideo retrieveByTitulo(String titulo);
	public List<DTOVideo> retrieveByDescripcion(String descripcion);
	public boolean  updateVideo(DTOVideo video);
	public boolean  deleteVideo(DTOVideo video);
	
}
