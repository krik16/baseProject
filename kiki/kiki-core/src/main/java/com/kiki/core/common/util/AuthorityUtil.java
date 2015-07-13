package com.kiki.core.common.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * 登录用户权限工具类
 * @author pingkang
 *
 */
public class AuthorityUtil {
	
	public static Collection<GrantedAuthority> getAuthorities(HttpServletRequest request){
		CasAuthenticationToken principal = (CasAuthenticationToken) request.getUserPrincipal();
		if(principal == null){
			return null;
		}
	    User principal2 = (User)principal.getPrincipal();
	    Collection<GrantedAuthority> authorities = principal2.getAuthorities();
	    return authorities;
	}
	
	public static Map<String, Object> getAttributes(HttpServletRequest request){
		CasAuthenticationToken token = (CasAuthenticationToken) request.getUserPrincipal();
	    AttributePrincipal principal = token.getAssertion().getPrincipal();
	    Map<String, Object> attributes = principal.getAttributes();
	    return attributes;
	}
	
	public static boolean hasAnyRoleAuthority(HttpServletRequest request,List<String> roleAuthorities){
		Collection<GrantedAuthority> authorities = getAuthorities(request);
		if(roleAuthorities != null && roleAuthorities.size() > 0){
			for (String roleAuthority : roleAuthorities) {
				if(authorities.contains(new SimpleGrantedAuthority(roleAuthority))){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean hasRoleAuthority(HttpServletRequest request,String roleAuthority){
		Collection<GrantedAuthority> authorities = getAuthorities(request);
		if(StringUtils.isNotBlank(roleAuthority)){
			if(authorities.contains(new SimpleGrantedAuthority(roleAuthority))){
				return true;
			}
		}
		return false;
	}
}
