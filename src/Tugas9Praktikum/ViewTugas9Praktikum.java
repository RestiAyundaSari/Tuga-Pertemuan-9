/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas9Praktikum;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ViewTugas9Praktikum extends JFrame{
    
    JLabel jlnim = new JLabel("Nim : ");
    JTextField jtnim = new JTextField();
    JLabel jlnama = new JLabel("Nama : ");
    JTextField jtnama = new JTextField();
    JLabel jlalamat = new JLabel("Alamat : ");
    JTextField jtalamat = new JTextField();
    JTextField jtcari = new JTextField();
    
    JButton jbcari = new JButton("Cari");
    JButton jbtambah = new JButton("Tambah");
    JButton jbupdate = new JButton("Update");
    JButton jbcancel = new JButton("Cancel");
    JButton jbdelete = new JButton("Delete");
    
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nim", "Nama", "Alamat"};
    
    public ViewTugas9Praktikum (){
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Mahasiswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(750,400); // x , y
        
        add(scrollPane);
        scrollPane.setBounds(20, 60, 480, 300);
        
        //CARI =================================================================
        add(jtcari);
        jtcari.setBounds(20, 20, 300, 20);
        
        // NIM =================================================================
        add(jlnim);
        jlnim.setBounds(510, 20, 90, 20);
        add(jtnim);
        jtnim.setBounds(510, 40, 120, 20);
        
        // NAMA ================================================================
        add(jlnama);
        jlnama.setBounds(510, 60, 90, 20);
        add(jtnama);
        jtnama.setBounds(510, 80, 120, 20);
        
        // ALAMAT ==============================================================
        add(jlalamat);
        jlalamat.setBounds(510, 100, 90, 20);
        add(jtalamat);
        jtalamat.setBounds(510, 120, 120, 20);
        
        
        // BUTTON ==============================================================
        add(jbcari);
        jbcari.setBounds(350, 20, 110, 20);
        
        add(jbtambah);
        jbtambah.setBounds(510, 160, 90, 20);
        
        add(jbupdate);
        jbupdate.setBounds(510, 200, 90, 20);
        
        add(jbcancel);
        jbcancel.setBounds(510, 240, 90, 20);
        
        add(jbdelete);
        jbdelete.setBounds(510, 280, 90, 20);
    }
    
    
    //Buat ngambil data texfield
    public String getNim(){
        return jtnim.getText();
    }
    
    public String getNama(){
        return jtnama.getText();
    }
    
    public String getAlamat(){
        return jtalamat.getText();
    }

    public String getCari(){
        return jtcari.getText();
    }
}

