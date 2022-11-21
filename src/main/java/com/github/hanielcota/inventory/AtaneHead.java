package com.github.hanielcota.inventory;

public enum AtaneHead {

    HEAD("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTEyM2VjM2RhY2FmZmVkNmQ2NGI2ZjA0MzcwOTUwMmZiMmRhZTE2ODc2Mjg3MDJhZmUwMzM0MzAzM2M0NDVlOSJ9fX0=");

    private final String head;

    AtaneHead(String value) {
        this.head = value;
    }

    public String toString() {
        return this.head;
    }
}
