package model.map;

import org.modelmapper.PropertyMap;

import dao.dbmodel.ApplicationDto;
import model.Application;

public class DtoToApplication extends PropertyMap<ApplicationDto, Application> {

	
	@Override
	protected void configure() {
		
		map().setStudent(source.getStudent().getName());
		map().setInternship(source.getInternship().getName());
		
	}

}
