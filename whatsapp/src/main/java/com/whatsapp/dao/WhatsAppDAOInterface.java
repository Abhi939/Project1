package com.whatsapp.dao;

import java.util.List;

import com.whatsapp.entity.WhatsappUser;

public interface WhatsAppDAOInterface {

	int createProfileDAO(WhatsappUser ws);

	WhatsappUser viewProfile(WhatsappUser ws);

	List<WhatsappUser> viewAllProfile();
	
	int deleteProfile(WhatsappUser ws);
	
	int editProfile(WhatsappUser ws,int c,String email);

}
