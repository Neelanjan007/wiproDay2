package mockito_tasks;

import junittasks.NotificationService;

public class AccountService {

    private final AccountRepository repo;
    private final NotificationService notifier;

    public AccountService(AccountRepository repo, NotificationService notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    public boolean transfer(Long fromId, Long toId, double amount) {
        Account from = repo.findById(fromId);
        Account to = repo.findById(toId);

        if (from == null || to == null) {
            return false;
        }

        if (from.getBalance() < amount) {
            return false;
        }

        from.debit(amount);
        to.credit(amount);

        repo.update(from);
        repo.update(to);
        notifier.send(fromId, "Debited Rs." + amount);
        return true;
    }
}
