package org.antipal.thesis.jpa.model;

import lombok.Data;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Data

@Entity
@Table(name = "users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 65)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 65)
    @Column(name = "last_name")
    private String lastName;
    
    @NotNull
    @Size(max = 30)
    @Column(unique=true)
	private
    String username;
    
    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;
    
    @NotNull
    @Size(max = 128)
    private String password;
        
    @OneToOne
    @JoinColumn(name="friend_id")
    private User friend;
    
    @OneToOne(mappedBy="friend")
    private User user;		
    
    @OneToOne(fetch = FetchType.LAZY,
    		cascade = CascadeType.ALL,
    		mappedBy = "user")    
    private UserProfile userProfile;
    
    public User() {
    	
    }
    
    public User(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
