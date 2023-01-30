package com.javarush.task.task15.task1522;

public class Earth implements Planet {
    private static Earth instance;

    private Earth() {
    }

    public static Earth getInstance() {
        if (instance == null) {
            instance = new Earth();
        }
        return instance;
    }
}
/*
public class Singleton {
  private static Singleton INSTANCE;

  private Singleton() {}

  public static Singleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Singleton();
    }
    return INSTANCE;
  }
}
 */