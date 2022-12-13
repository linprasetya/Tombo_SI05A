/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employer;

/**
 *
 * @author Lenovo
 */
public class Gaji
{
    public static void main (String [] args)
    {
        Employer ref;
        SalariedEmployee pekerja=new SalariedEmployee();
        CommisionEmployee pegawai=new CommisionEmployee();
        ProjectPlaner atasan=new ProjectPlaner();
     
        System.out.println ("DAFTAR GAJI KARYAWAN");
        System.out.println ("\n");
     
        ref=pekerja;      
        ref.setNama ("Jokowi");
        ref.getNama();
        ref.jabatan_3027();
        ref.perhitungangaji();
        System.out.println ("\n");
     
        ref=pegawai;
        ref.setNama ("Puan");
        ref.getNama();
        ref.jabatan_3027();
        ref.perhitungangaji();
        System.out.println ("\n");
        ref=atasan;
        ref.setNama ("Megatron wati");
        ref.getNama();
        ref.jabatan_3027();
        ref.perhitungangaji();
    }
}
