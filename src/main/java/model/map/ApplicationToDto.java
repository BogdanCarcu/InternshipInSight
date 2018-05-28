package model.map;

import org.modelmapper.PropertyMap;

import dao.dbmodel.ApplicationDto;
import model.Application;

public class ApplicationToDto extends PropertyMap<Application, ApplicationDto> {

	
	@Override
	protected void configure() {
		
		map().getStudent().setName(source.getStudent());
		map().getInternship().setName(source.getInternship());
		
	}

}
