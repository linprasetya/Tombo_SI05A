/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employer;

/**
 *
 * @author Lenovo
 */
public class CommisionEmployee extends Employer
{
    double uangmakan_3027;
 
    public CommisionEmployee()
    {
        jabatan_3027="Commision Employee";
        uangmakan_3027=500000.0;
    }
 
    public double perhitungangaji()
    {
        double potongan;
        gajikotor_3027=gajipokok_3027+uangmakan_3027;
        potongan=(5.0/100.0)*gajikotor_3027;
        gajibersih_3027=gajikotor_3027-potongan;
     
        System.out.println ("Gaji Pokok : " +gajipokok_3027);
        System.out.println ("Uang Makan : " +uangmakan_3027);
        System.out.println ("Gaji Kotor : " +gajikotor_3027);
        System.out.println ("Potongan : " +potongan);
        System.out.println ("Gaji Bersih : " +gajibersih_3027);
     
        return gajibersih_3027;
    }
}
