package jetbrains.finalProject;

import java.util.Scanner;

public class Shift implements RunAlgorithm {

    @Override
    public void run(String mode, char[] chars, int key)
    {
        int number = 0;
        int partOne;
        final String lowerAlf = "abcdefghijklmnopqrstuvwxyz";
        final String upperAlf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final char[] lowerCharAlf = lowerAlf.toCharArray();
        final char[] upperCharAlf = upperAlf.toCharArray();
        final int alphabetLength = lowerCharAlf.length;

        for (int i = 0; i < chars.length ; i++)
        {
            if (Character.isUpperCase(chars[i])) {
                number = findNumber(upperCharAlf, chars[i]);
            } else if (Character.isLowerCase(chars[i])) {
                number = findNumber(lowerCharAlf, chars[i]);
            }

            if (chars[i] == ' ') continue;

            if (mode.equals("enc"))
            {
                if ((number + key) <= alphabetLength)
                {
                    if (Character.isUpperCase(chars[i])) {
                        System.out.println(Character.toUpperCase(lowerCharAlf[number + key - 1]));
                        chars[i] = Character.toUpperCase(lowerCharAlf[number + key - 1]);
                        continue;
                    } else if (Character.isLowerCase(chars[i])) {
                        chars[i] = lowerCharAlf[number + key - 1];
                    }
                }

                if ((number + key) > alphabetLength)
                {
                    partOne = number + key;

                    if (Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toUpperCase(lowerCharAlf[partOne - alphabetLength - 1]);
                    } else if (Character.isLowerCase(chars[i])) {
                        chars[i] = lowerCharAlf[partOne - alphabetLength - 1];
                    }
                }
            }

            if (mode.equals("dec"))
            {
                if ((number - key) > 0)
                {
                    if (Character.isTitleCase(chars[i])) {
                        chars[i] = upperCharAlf[number - key - 1];
                    } else if (Character.isLowerCase(chars[i])) {
                        chars[i] = lowerCharAlf[number - key - 1];
                    }
                }

                if ((number - key) <= 0)
                {
                    partOne = number - key;
                    if (Character.isTitleCase(chars[i])) {
                        chars[i] = upperCharAlf[partOne + alphabetLength - 1];
                    } else if (Character.isLowerCase(chars[i])) {
                        chars[i] = lowerCharAlf[partOne + alphabetLength - 1];
                    }
                }
            }
        }
    }

    public static int findNumber(char[] alfabet, char sym)
    {
        int solution = 0;
        for (int i = 0; i < alfabet.length; i++)
        {
            if (alfabet[i] == sym) {
                solution = ++i;
            }
        }
        return solution;
    }
}

