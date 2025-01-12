package eu.europa.ecb.budgettracker.categories.apis;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {

  @GetMapping
  public ResponseEntity<List<String>> categories() {
    return ResponseEntity.ok(List.of(
        "consultancy services",
        "licenses",
        "operations",
        "business travels"
    ));
  }
}
