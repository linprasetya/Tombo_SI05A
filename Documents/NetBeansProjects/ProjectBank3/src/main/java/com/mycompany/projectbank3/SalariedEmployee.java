/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectbank3;

/**
 *
 * @author Lenovo
 */
public class SalariedEmployee extends Employer
{
     double uangmakan;
     double tunjangankinerja;
 
    public SalariedEmployee()
    {
        jabatan_3027="salaried employee";
        uangmakan_3027=500000.0;
        tunjangankinerja=500000.0;
    }
 
    public double perhitungangaji()
    {
        double potongan;
        gajikotor_3027=gajipokok_3027+uangmakan_3027+tunjangankinerja;
        potongan=(10.0/100.0)*gajikotor_3027;
        gajibersih_3027=gajikotor_3027-potongan;
     
        System.out.println ("Gaji Pokok : " +gajipokok_3027);
        System.out.println ("Uang Makan : " +uangmakan_3027);
        System.out.println ("Tunjangan Kinerja : " +tunjangankinerja);
        System.out.println ("Gaji Kotor : " +gajikotor_3027);
        System.out.println ("Potongan : " +potongan);
        System.out.println ("Gaji Bersih : " +gajibersih_3027);
     
        return gajibersih_3027;
    }
}

