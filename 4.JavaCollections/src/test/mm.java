package test;

import java.util.Arrays;

public class mm
{
    public static void main(String[] args)
    {
        int n = 100;
        int sum = 0;

        for (int i = 0; i< n; i++)
        {
            sum += i;
        }

        System.out.println(sum);
    }
    public void printInfo(String user)
    {
        user = "DNO POLNOE";
        extracted(user);

    }

    private void extracted(String user) {
        try {
            System.out.println(user.toLowerCase().toUpperCase().length());
            System.out.println(Arrays.toString(user.toLowerCase().toUpperCase().getBytes()));
            System.out.println(user.toLowerCase().toUpperCase().indexOf(2));
            System.out.println(user.toLowerCase().toUpperCase().charAt(3));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

