package com.basic.basicproject.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { // 다른 곳에서 생성 못하게 ...
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
