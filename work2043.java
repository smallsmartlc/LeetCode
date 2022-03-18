package Leetcode.smart;

/**
 * 2043 简易银行系统
 *
 * @author LuCong
 * @since 2022-2-9
 **/
public class work2043 {
    public static void main(String[] args) {
        work2043 w = new work2043();
        w.run();
    }

    private void run() {
        Bank bank = new Bank(10, 100, 20, 50, 30);
        System.out.println(bank.withdraw(3, 10));
        System.out.println(bank.transfer(5, 1, 20));
        System.out.println(bank.deposit(5, 20));
        System.out.println(bank.transfer(3, 4, 15));
        System.out.println(bank.withdraw(10, 50));
    }


    private class Bank {
        private long[] balance;

        public Bank(long... balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (illegalAccount(account1) || illegalAccount(account2)) return false;
            if (balance[account1 - 1] < money) return false;
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (illegalAccount(account)) return false;
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (illegalAccount(account)) return false;
            if (balance[account - 1] < money) return false;
            balance[account - 1] -= money;
            return true;
        }

        private boolean illegalAccount(int account) {
            if (account < 1 || account >= balance.length) return true;
            return false;
        }
    }
}


