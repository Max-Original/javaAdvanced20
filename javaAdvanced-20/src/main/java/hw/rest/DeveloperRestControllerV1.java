package hw.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.*;


import hw.model.Developer;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

	private List<Developer> Developers = Stream.of(new Developer(1L, "MAX", "DEVELOPER"),
			new Developer(2L, "MASHA", "DEVELOPER"), new Developer(3L, "ANNA", "DEVELOPER"))
			.collect(Collectors.toList());

	@GetMapping
	public List<Developer> getAll() {
		return Developers;
	}

	@GetMapping("/{id}")
	public Developer getById(@PathVariable Long id) {
		return Developers.stream().filter(developer -> developer.getId().equals(id)).findFirst().orElse(null);
	}
}
