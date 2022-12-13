/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.employer;

/**
 *
 * @author Lenovo
 */
public abstract class Employer {
    String nama;
    String jabatan_3027;
    double gajibersih_3027;
    double gajikotor_3027;
    double gajipokok_3027;
    double uangmakan_3027;
 
    public Employer()
    {
        gajipokok_3027=1500000.0;
    }
 
    public void setNama (String name)
    {
        this.nama=name;
    }
 
    public String getNama()
    {
        System.out.println ("Nama Karyawan : " +nama);
        return nama;
    }
 
    public String jabatan_3027()
    {
        System.out.println ("Posisi Jabatan : " +jabatan_3027);
        return jabatan_3027;
    }
 
    public abstract double perhitungangaji();
 
}
