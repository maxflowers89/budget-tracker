package eu.europa.ecb.budgettracker.budgets.repositories.exceptions;

public class DocumentNotFoundException extends RuntimeException {

  public DocumentNotFoundException(String message) {
    super(message);
  }
}
