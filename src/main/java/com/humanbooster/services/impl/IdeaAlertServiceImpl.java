package com.humanbooster.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.business.IdeaAlert;
import com.humanbooster.dao.IdeaAlertDao;
import com.humanbooster.services.IdeaAlertService;

@Service
public class IdeaAlertServiceImpl implements IdeaAlertService {

	@Autowired
	IdeaAlertDao ideaAlertDao;

	@Override
	public List<IdeaAlert> findAllIdeaAlert() {
		List<IdeaAlert> ideaAlerts = new ArrayList<>();
		ideaAlerts = ideaAlertDao.findAllIdeaAlert();
		return ideaAlerts;
	}
}
