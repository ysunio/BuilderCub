package com.buildercub.scenarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardSettlement {

    static class Expense {
        String payer;
        double amount;
        List<String> payees;

        Expense(String payer, double amount, List<String> payee) {
            this.payer = payer;
            this.payees = payee;
            this.amount = amount;
        }
    }

    static class Transaction {
        String to;
        String from;
        double amount;

        Transaction(String to, String from, double amount) {
            this.to = to;
            this.from = from;
            this.amount = Math.round(amount * 100.0) / 100.0;;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "to='" + to + '\'' +
                    ", from='" + from + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

    public static void main(String[] args) {

        System.out.println(buildTransaction(List.of(
                new Expense("Sunil", 1000, List.of("Lambda")),
                new Expense("Lambda", 2000, List.of("S3"))
        )));

        System.out.println(buildTransaction(List.of(
                new Expense("Sunil", 1000, List.of("Alice", "Bob", "Charlie")),
                new Expense("Alice", 3000, List.of("Alice", "Bob", "Charlie")),
                new Expense("Bob", 5000, List.of("Sunil")),
                new Expense("Charlie", 3000, List.of("Alice")),
                new Expense("Sunil", 1456, List.of("Sunil", "Bob"))
        )));
    }

    static class PersonalBalance {
        String name;
        double amount;

        public PersonalBalance(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }
    }

    private static List<Transaction> buildTransaction(List<Expense> expenses) {
        // Build Balance Map

        Map<String, Double> balances = balanceMapGenerator(expenses);

        // Get Payees, and Get Payers
        List<PersonalBalance> creditor = new ArrayList<>();
        List<PersonalBalance> debitor = new ArrayList<>();

        for (Map.Entry<String, Double> entry : balances.entrySet()) {
            if(entry.getValue() == 0.0) continue;

            if (entry.getValue() > 0.1)
                creditor.add(new PersonalBalance(entry.getKey(), entry.getValue()));
            else
                debitor.add(new PersonalBalance(entry.getKey(), -entry.getValue())); // Making Positive
        }

        // Sort to Pick High Amount first - Greedy
        creditor.sort((a, b) -> (int) (b.amount - a.amount));
        debitor.sort((a, b) -> (int) (a.amount - b.amount));

        // Build Mapping for Transactions
        List<Transaction> finalTransaction = new ArrayList<>();
        int i=0, j=0;

        while(i < creditor.size() && j < debitor.size()){
            PersonalBalance cr = creditor.get(i);
            PersonalBalance db = debitor.get(j);

            double amountToSettle = Math.min(cr.amount, db.amount);
            if(amountToSettle > 0.1){
                finalTransaction.add(new Transaction(cr.name, db.name, amountToSettle));
            }

            cr.amount -= amountToSettle;
            db.amount -= amountToSettle;

            if(cr.amount < 0.1) i++;
            if(db.amount < 0.1) j++;
        }

        return finalTransaction;
    }

    private static Map<String, Double> balanceMapGenerator(List<Expense> expenses) {
        Map<String, Double> balances = new HashMap<>();

        for (Expense expense : expenses) {
            double perHeadAmount = expense.amount / expense.payees.size();
            if (!balances.containsKey(expense.payer)) balances.put(expense.payer, 0.0);
            balances.put(expense.payer, balances.get(expense.payer) + perHeadAmount);

            for (String payee : expense.payees) {
                if (!balances.containsKey(payee)) balances.put(payee, 0.0);
                balances.put(payee, balances.get(payee) - perHeadAmount);
            }
        }

        return balances;
    }
}
