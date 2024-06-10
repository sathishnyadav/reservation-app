package org.jsp.reservationapi.util;

public interface ApplicationConstants {
	String ADMIN_VERIFY_LINK = "/api/admins/activate?token=";
	String USER_VERIFY_LINK = "/api/users/activate?token=";
	String ADMIN_RESET_PASSWORD_LINK = "/api/admins/verify-link?token=";
	String USER_RESET_PASSWORD_LINK = "/api/users/verify-link?token=";
}
