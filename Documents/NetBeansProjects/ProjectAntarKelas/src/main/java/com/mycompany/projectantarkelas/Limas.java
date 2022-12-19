/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectantarkelas;

/**
 *
 * @author Lenovo
 */
public class Limas extends ProjectAntarKelas{
    
    float panjang;
    float lebar;
    float tinggi;

    @Override
    float volume() {
        float volume = 1/2 * (panjang * tinggi * lebar);
        System.out.println("Volume limas: " + volume);
        return volume;
    }   
    
}