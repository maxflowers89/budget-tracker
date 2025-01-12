package eu.europa.ecb.budgettracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class BudgetTrackerApplicationTests {

  @Test
  void verifiesModularStructure() {
    ApplicationModules modules = ApplicationModules.of(BudgetTrackerApplication.class);
    modules.verify();
  }

  @Test
  void createModuleDocumentation() {
    ApplicationModules modules = ApplicationModules.of(BudgetTrackerApplication.class);
    new Documenter(modules)
        .writeDocumentation()
        .writeIndividualModulesAsPlantUml();
  }
}
