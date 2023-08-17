package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    /**
     * Хранение пользователей с их счетами осуществляется в коллекции типа HashMap,
     * key - пользователь
     * value - список счетов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления пользователя,
     * изначально счет пустой
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаления пользователя по паспорту
     * @param passport паспорт пользователя
     * @return результат удаления пользователя
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавления счета, по паспорту пользователя
     * @param passport паспорт пользователя
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод поиска пользователя по паспорту
     * @param passport паспорт пользователя
     * @return пользователь
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод поиска счета по паспорту и реквизитам
     * @param passport паспорт пользователя
     * @param requisite реквизиты счета
     * @return банковский счет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод перевода средств с одного счета на другой
     * @param srcPassport   паспорт пользователя с которого идет перевод
     * @param srcRequisite  реквизиты счета с которого идет перевод
     * @param destPassport  паспорт пользователя который идет перевод
     * @param destRequisite реквизиты счета на который идет перевод
     * @param amount        сумма перевода
     * @return результат перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src == null || dest == null || src.getBalance() - amount < 0) {
            return false;
        }
        dest.setBalance(dest.getBalance() + amount);
        src.setBalance(src.getBalance() - amount);
        return true;
    }

    /**
     * Метод получения список банковских счетов у пользователя
     * @param user пользователь банка
     * @return список банковских счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}