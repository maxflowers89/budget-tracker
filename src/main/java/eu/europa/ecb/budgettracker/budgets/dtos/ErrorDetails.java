package eu.europa.ecb.budgettracker.budgets.dtos;

public record ErrorDetails(int statusCode, String message, String requestDescription) {

}
