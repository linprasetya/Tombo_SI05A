/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectantarkelas;

/**
 *
 * @author Lenovo
 */
public class Main {
    public static void main(String[] args) {
        
        // membuat objek bangun datar
        ProjectAntarKelas projectantarKelas = new ProjectAntarKelas();
        
        // membuat objek persegi dan mengisi nilai properti
        Persegi persegi = new Persegi();
        persegi.sisi = 2;
        
        // membuat objek Limas dan mengisi nilai properti
        Limas mLimas = new Limas();
        mLimas.panjang = 22;
        mLimas.tinggi = 12;
        mLimas.lebar = 42;
        
        // membuat objek jarak 2 titik
        
        Jarakduatitik t1 = new Jarakduatitik();
        t1.setX(1);
        t1.setY(6);
        
        // membuat objek Segitiga dan mengisi nilai properti
        Segitiga mSegitiga = new Segitiga();
        mSegitiga.alas = 12;
        mSegitiga.tinggi = 8;
        
        
        // memanggil method luas dan keliling
        
        projectantarKelas.keliling();
        projectantarKelas.volume();
        projectantarKelas.luas();
        
        persegi.luas();
        persegi.keliling();
        
        mLimas.volume();
        
        mSegitiga.luas();
        
        // menampilkan titik
        
        System.out.println("Menampilkan info kelas titik t1 :");
        System.out.println(t1.getKoordinat());
        
        Jarakduatitik t2 = new Jarakduatitik(10, 6);
        System.out.println("Menampilkan info kelas titik t2 :");
        System.out.println(t2.getKoordinat());
        
        System.out.println("Jarak dua titik P: " + Jarakduatitik.hitJarak(t1, t2));
    }
}
