package hw.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.weaver.ast.HasAnnotation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hw.model.Developer;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

	private List<Developer> Developers = Stream.of(new Developer(1L, "Max", "Developer"), new Developer(2L, "Masha", "Developer")).collect(Collectors.toList());

	@GetMapping
	public List<Developer> getAll(){
		return Developers;
	}
	
	@GetMapping("{id}")
	@PreAuthorize("hasAuthority('developers:read')")
	public Developer getById(@PathVariable Long id) {
		return Developers.stream().filter(developer -> developer.getId().equals(id)).findFirst().orElse(null);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('developers:write')")
	public Developer create(@RequestBody Developer developer) {
		this.Developers.add(developer);
		return developer;
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('developers:write')")
	public void deleteById(@PathVariable Long id) {
		Developers.removeIf(developer -> developer.getId().equals(id));
	}
}
