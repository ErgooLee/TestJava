package com.xiaowuzei.test.algr.leet;

public class N372_SuperPow {

    public static void main(String[] args) {
        System.out.println(new N372_SuperPow().superPow(2, 11));
    }

    int[] b;
    int[] record = new int[11];

    public int superPow(int a, int[] b) {
        int a_mod_k = a % 1337;
        this.b = b;
        record[0] = 1;
        for (int i = 1; i <= 10; i++) {
            record[i] = (a_mod_k * (record[i - 1] % 1337)) % 1337;
        }
        return superPow(b.length - 1);
    }

    public int superPow(int index) {
        if (index < 0) {
            return 1;
        }
        int p1_mod_k = record[b[index]];
        int p2_mod_k = superPow(superPow(index - 1), 10);
        return (p1_mod_k * p2_mod_k) % 1337;
    }

    public int superPow2(int a_mod_k, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            // k 是奇数
            return (a_mod_k * superPow(a_mod_k, n - 1)) % 1337;
        } else {
            // k 是偶数
            int sub = superPow(a_mod_k, n / 2);
            return (sub * sub) % 1337;
        }
    }

    public int superPow1(int a_mod_k, int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = (a_mod_k * (result % 1337)) % 1337;
        }
        return result;
    }

    public int superPow(int a_mod_k, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            // k 是奇数
            return (a_mod_k * superPow(a_mod_k, n - 1)) % 1337;
        } else {
            // k 是偶数
            int sub = superPow(a_mod_k, n / 2);
            return (sub * sub) % 1337;
        }
    }


}
