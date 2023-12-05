package com.test.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;

@Controller
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//Authentication : 인증 정보를 가지고 있는 객체
		
		//방금 로그인한 사람이 어떤 자격을 가지고 있는지 확인한다.
		//자격에 따라 로그인 성공 시 이동할 페이지를 다르게 설정한다.
		
		List<String> roleNames = new ArrayList<String>();
		
		//security-context.xml에서 role 정보를 가지고있음
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		System.out.println(roleNames);
		
		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/spring/admin/admin.do");
		} else if (roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/spring/member/member.do");
		} else {
			response.sendRedirect("/spring/index.do");
		}
		
	}
	
	
}
