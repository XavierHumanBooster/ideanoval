package com.humanbooster.dao;

import java.util.Date;
import java.util.List;

import com.humanbooster.business.IdeaAlert;

public interface IdeaAlertDao {
	public boolean addIdeaAlert(IdeaAlert ideaAlert);
	public IdeaAlert findIdeaAlertById(int idIdeaAlert);
	public List<IdeaAlert> findIdeaAlertByIdUser(int idUser);
	public List<IdeaAlert> findIdeaAlertByDate(Date date);
	public boolean updateIdeaAlert(IdeaAlert ideaAlert);
	public boolean deleteIdeaAlert(IdeaAlert ideaAlert);
	public List<IdeaAlert> findAllIdeaAlert();
}
