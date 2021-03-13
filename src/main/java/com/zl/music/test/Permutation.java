package com.zl.music.test;

public class Permutation {
    private char[] ch;

    public Permutation(String str) {
        ch = str.toCharArray();
    }

    public void listPermutation() {
        recursivePermute(ch, 0);
    }

    private void recursivePermute(char[] pstr, int k) {
        int i;
        if (k == pstr.length)
            System.out.println(String.copyValueOf(pstr));
        else {
            for (i = k; i < pstr.length; i++) {
                exchange(pstr, k, i);
                recursivePermute(pstr, k + 1); //迭代
                exchange(pstr, k, i);
            }
        }
    }

    private void exchange(char[] pstr, int k, int i) {
        char temp = pstr[k];
        pstr[k] = pstr[i];
        pstr[i] = temp;
    }

    public static void main(String[] args) {
		String test = "ABCD";
		Permutation permutation = new Permutation(test);
		permutation.listPermutation();
	}

}