package org.jsp.reservationapi.service;

import static org.jsp.reservationapi.util.ApplicationConstants.ADMIN_VERIFY_LINK;
import static org.jsp.reservationapi.util.ApplicationConstants.USER_VERIFY_LINK;

import org.jsp.reservationapi.dao.AdminDao;
import org.jsp.reservationapi.model.Admin;
import org.jsp.reservationapi.util.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Service
public class LinkGeneratorService {
	@Autowired
	private AdminDao adminDao;

	public String getActivationLink(Admin admin, HttpServletRequest request) {
		admin.setToken(RandomString.make(45));
		admin.setStatus(AccountStatus.ACTIVE.toString());
		adminDao.saveAdmin(admin);
		String siteUrl = request.getRequestURL().toString();
		return siteUrl.replace(request.getServletPath(), ADMIN_VERIFY_LINK + admin.getToken());
	}

	public String getUserActivationLink(String token, HttpServletRequest request) {
		String siteUrl = request.getRequestURL().toString();
		return siteUrl.replace(request.getServletPath(), USER_VERIFY_LINK + token);
	}
}
