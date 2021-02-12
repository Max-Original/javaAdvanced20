package hw.model;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
	 
	USER(Set.of(Permission.DEVELOPERS_READ)),
	ADMIN(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));
	
	private final Set<Permission> permissions;

	private Role(Set<Permission> permisions) {
		this.permissions = permisions;
	}

	public Set<Permission> getPermisions() {
		return permissions;
	}
	
	public Set<SimpleGrantedAuthority> getAuthorities(){
		return getPermisions().stream()
		.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
		.collect(Collectors.toSet());
	}

}
