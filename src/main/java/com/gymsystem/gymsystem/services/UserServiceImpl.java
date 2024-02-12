package com.gymsystem.gymsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymsystem.gymsystem.entities.Coach;
import com.gymsystem.gymsystem.entities.Membre;
import com.gymsystem.gymsystem.entities.Role;
import com.gymsystem.gymsystem.entities.User;
import com.gymsystem.gymsystem.repository.UserRepository;
@Service
public class UserServiceImpl implements UserServiceInter{
	
	@Autowired
	UserRepository userRep;
	@Override
	

	public Coach addCoach(Coach coach) {
		
		return userRep.save(coach);
	}
	public Membre addMembre(Membre membre) {
		
		return userRep.save(membre);
	}
	
  
	@Override
	public List<User> addListUser(List<User> listuser) {
		// TODO Auto-generated method stub
		return userRep.saveAll(listuser);
	}
	@Override 
	public String addUserWTUN(User user) {
		String ch="";
		if(userRep.existsByNom(user.getNom())) {
			ch="Nom est déja existé";
		}
		else {
			userRep.save(user);
			ch="user est ajouter avec succ";
		}
		return ch;
	}

@Override 
 public User updateUser(Long iduser, User user) {

	    if (userRep.existsById(iduser)) {
	    	
			User existingUser = userRep.findById(iduser).get();
	            existingUser.setEmail(user.getEmail()!= null ? user.getEmail() : existingUser.getEmail());
	            existingUser.setTelephone(user.getTelephone() != null ? user.getTelephone() : existingUser.getTelephone());
	            existingUser.setPrénom(user.getPrénom() != null ? user.getPrénom() : existingUser.getPrénom());
	            existingUser.setDateDeNaissance(user.getDateDeNaissance() != null ? user.getDateDeNaissance() : existingUser.getDateDeNaissance());
	            existingUser.setPhoto(user.getPhoto() != null ? user.getPhoto() : existingUser.getPhoto());
	            existingUser.setRole(user.getRole() != null ? user.getRole() : existingUser.getRole());

	              userRep.save(existingUser);
	           
	    } else {
	        throw new RuntimeException("L'utilisateur avec l'ID  " + iduser + " n'existe pas.");
	    }		        
	    return user;
	}
@Override 
public User updateMembre(Long iduser, Membre membre) {
	User existingUser = userRep.findById(iduser).get();
	Membre membreex =  (Membre) existingUser;

	    if (userRep.existsById(iduser)) {
	    	
			membreex.setStatus(membre.getStatus()!= null ? membre.getStatus() : membreex.getStatus());
	              userRep.save(membreex);
	           
	    } else {
	        throw new RuntimeException("Le membre  avec l'ID  " + iduser + " n'existe pas.");
	    }		        
	    return membreex;
	}
@Override
public User updateCoach(Long iduser, Coach coach) {
	User existingUser = userRep.findById(iduser).get();
	Coach coachex =  (Coach) existingUser;
    if (userRep.existsById(iduser)) {
		coachex.setSpécialité(coach.getSpécialité()!= null ? coach.getSpécialité() : coachex.getSpécialité());
              userRep.save(coachex);
           
    } else {
        throw new RuntimeException("Le coach avec l'ID  " + iduser + " n'existe pas.");
    }		        
    return coachex;
}
	@Override
	public void deleteUser(Long iduser) {
	    if (userRep.existsById(iduser)) {
		
	    	userRep.deleteById(iduser);
	        System.out.println("L'utilisateur avec l'ID " + iduser + " a été supprimé avec succès.");

	    } else {
	        throw new RuntimeException("L'utilisateur avec l'ID " + iduser + " n'existe pas.");
	    }
		
	}
	@Override
	public List<User> getListUser() {
		
		return userRep.findAll();
	}
	@Override

	
	public List<User> getListByUserrole(Role role) {
	    if (!userRep.existsByRole(role)) {
	        throw new RuntimeException("L'utilisateur avec le rôle : " + role + " n'existe pas.");
	    } else {
	        List<User> existingUsers = userRep.findByRole(role);

	        List<User> filteredUsers = existingUsers.stream()
	                .filter(user -> {
	                    if (user instanceof Membre && user.getRole().equals(role)) {
	                        return true;
	                    } else if (user instanceof Coach && user.getRole().equals(role)) {
	                        return true;
	                    }
	                    return false;
	                })
	                .collect(Collectors.toList());

	        return filteredUsers;
	    }
	}

	public List<User> getListByUserSOS(String ss) {
        List<User> existingUsers = userRep.findAll();

        List<User> filteredUsers = existingUsers.stream()
                .filter(user -> {
                    if (user instanceof Membre && ((Membre) user).getStatus().name().equals(ss)) {
                        return true;
                    } else if (user instanceof Coach && ((Coach) user).getSpécialité().name().equals(ss)) {
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());

        if (filteredUsers.isEmpty()) {
            throw new RuntimeException("Aucun utilisateur avec le statut ou la spécialité demandée: " + ss);
        }

        return filteredUsers;
    }


	@Override
	public User getByUsername(String nom) {
		
		if (!userRep.existsByNom(nom)) {
			 throw new RuntimeException("L'utilisateur avec le nom :  " + nom + " n'existe pas.");
		}
	 
		else {
			User existingUser= userRep.findByNom(nom);
			if ( existingUser instanceof Membre){ 
				Membre membre =  (Membre) existingUser;
				return userRep.findByNom(membre.getNom()); }
		
			else {
				Coach coach= (Coach) existingUser;
				return userRep.findByNom(coach.getNom()); }
	}
	}
	
	@Override
	public List<User> getUserSW(String ch) {
		
		return userRep.getUserSW(ch);
	}


}
