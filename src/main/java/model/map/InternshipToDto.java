package model.map;

import org.modelmapper.PropertyMap;

import dao.dbmodel.InternshipDto;
import model.Internship;

public class InternshipToDto extends PropertyMap<Internship, InternshipDto> {

	
	@Override
	protected void configure() {
		
		map().getCompany().setName(source.getCompany());
		
	}
	
	
}
