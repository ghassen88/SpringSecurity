package com.example.demo.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entites.Etudiant;
import com.example.demo.Repositories.EtudiantRepository;

@RestController
public class EtudinatRestService {
	
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	  @Secured(value = {"ROLE_ADMIN","ROLE_SCOLARITE"})
	@RequestMapping(value = "saveEtudiant", method = RequestMethod.POST)
	public Etudiant saveEtudiant(@RequestBody Etudiant e) {
		 return etudiantRepository.save(e);
		 
		
	}
    @Secured(value = {"ROLE_ADMIN","ROLE_ETUDIANT","ROLE_SCOLARRITE","ROLE_PROF"})
	@RequestMapping(value = "etudiants", method = RequestMethod.GET)

	public List<Etudiant> listEtudiants(){
		return etudiantRepository.findAll();
		
	}
    
    
	@RequestMapping(value = "getLoggedUser", method = RequestMethod.GET)
    public Map<String,Object> getLogedUser(HttpServletRequest httpServletRequest){
		HttpSession httpSession =httpServletRequest.getSession();
		SecurityContext securityContext =(SecurityContext) httpSession.getAttribute("SPRING_SECURITY__CONTEXT");
		String username=securityContext.getAuthentication().getName();
		List<String> roles =new  ArrayList<>();
		for(GrantedAuthority ga:securityContext.getAuthentication().getAuthorities()){
			roles.add(ga.getAuthority());
		}
		Map<String,Object> params=new HashMap();
		params.put("username", username);
        params.put("roles", roles)   ;
        return params;
    }

}
