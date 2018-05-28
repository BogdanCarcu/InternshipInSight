package model.map;

import org.modelmapper.PropertyMap;

import dao.dbmodel.InternshipDto;
import model.Internship;

public class DtoToInternship extends PropertyMap<InternshipDto, Internship> {

	
	@Override
	protected void configure() {
		
		map().setCompany(source.getCompany().getName());
		
	}

}
