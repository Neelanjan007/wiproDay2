package mockito_tasks;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import junittasks.NotificationService;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    private AccountRepository repo;
    private NotificationService notifier;
    private AccountService service;

    @BeforeEach
    void setUp() {
        repo = mock(AccountRepository.class);
        notifier = mock(NotificationService.class);
        service = new AccountService(repo, notifier);
    }

    @Test
    void testSuccessfulTransfer() {
        Account from = new Account(1L, 1000);
        Account to = new Account(2L, 500);

        when(repo.findById(1L)).thenReturn(from);
        when(repo.findById(2L)).thenReturn(to);

        boolean result = service.transfer(1L, 2L, 200);

        assertTrue(result);
        assertEquals(800, from.getBalance());
        assertEquals(700, to.getBalance());

        verify(repo, times(2)).update(any(Account.class));
        verify(notifier).send(1L, "Debited Rs.200.0");
    }

    @Test
    void testTransferFailsDueToInsufficientBalance() {
        Account from = new Account(1L, 100);
        Account to = new Account(2L, 500);

        when(repo.findById(1L)).thenReturn(from);
        when(repo.findById(2L)).thenReturn(to);

        boolean result = service.transfer(1L, 2L, 200);

        assertFalse(result);
        assertEquals(100, from.getBalance());
        assertEquals(500, to.getBalance());

        verify(repo, never()).update(any());
        verify(notifier, never()).send(anyLong(), anyString());
    }

    @Test
    void testTransferFailsWhenAccountNotFound() {
        when(repo.findById(1L)).thenReturn(null);
        when(repo.findById(2L)).thenReturn(new Account(2L, 500));

        boolean result = service.transfer(1L, 2L, 100);
        assertFalse(result);

        verify(repo, never()).update(any());
        verify(notifier, never()).send(anyLong(), anyString());
    }
}

