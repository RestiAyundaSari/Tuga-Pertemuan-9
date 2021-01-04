/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas9Praktikum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author DELL
 */
public class ControllerTugas9Praktikum {
    ModelTugas9Praktikum modeltugas9praktikum;
    ViewTugas9Praktikum viewtugas9praktikum;

    public ControllerTugas9Praktikum(ViewTugas9Praktikum vtp, ModelTugas9Praktikum mtp) {
        this.modeltugas9praktikum= mtp;
        this.viewtugas9praktikum = vtp;
        
        if (modeltugas9praktikum.getBanyakData()!= 0) {
            String dataMahasiswa[][] = modeltugas9praktikum.readMahasiswa();
            viewtugas9praktikum.tabel.setModel((new JTable(dataMahasiswa, viewtugas9praktikum.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewtugas9praktikum.jbtambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = viewtugas9praktikum.getNim();
                String nama = viewtugas9praktikum.getNama();
                String alamat = viewtugas9praktikum.getAlamat();
                modeltugas9praktikum.insertMahasiswa(nim, nama, alamat);

                String dataMahasiswa[][] = modeltugas9praktikum.readMahasiswa();
                viewtugas9praktikum.tabel.setModel(new JTable(dataMahasiswa, viewtugas9praktikum.namaKolom).getModel());
            }
        });
        
        viewtugas9praktikum.jbupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nim = viewtugas9praktikum.getNim();
                String nama = viewtugas9praktikum.getNama();
                String alamat = viewtugas9praktikum.getAlamat();
                modeltugas9praktikum.updateMahasiswa(nim, nama, alamat);
                
                String dataMahasiswa[][] = modeltugas9praktikum.readMahasiswa();
                viewtugas9praktikum.tabel.setModel(new JTable(dataMahasiswa, viewtugas9praktikum.namaKolom).getModel());
            }
        });
        
          viewtugas9praktikum.jbdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nim = viewtugas9praktikum.getNim();
                
               int input = JOptionPane.showConfirmDialog(null,"Apa anda ingin menghapus NIM " + nim + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                modeltugas9praktikum.deleteMahasiswa(nim);
                String dataMahasiswa[][] = modeltugas9praktikum.readMahasiswa();
                viewtugas9praktikum.tabel.setModel(new JTable(dataMahasiswa, viewtugas9praktikum.namaKolom).getModel());
                }else{
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
          
        viewtugas9praktikum.jbcari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String cari = viewtugas9praktikum.getCari();
                System.out.println(cari);
                
                String dataMahasiswa[][] = modeltugas9praktikum.cariMahasiswa(cari);
                viewtugas9praktikum.tabel.setModel(new JTable(dataMahasiswa, viewtugas9praktikum.namaKolom).getModel());
            }
        });
        

        viewtugas9praktikum.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewtugas9praktikum.tabel.getSelectedRow();
                int kolom = viewtugas9praktikum.tabel.getSelectedColumn(); // ga kepake sekarang

                String nim = viewtugas9praktikum.tabel.getValueAt(baris, 0).toString();
                String nama = viewtugas9praktikum.tabel.getValueAt(baris, 1).toString();
                String alamat = viewtugas9praktikum.tabel.getValueAt(baris, 2).toString();
                

                viewtugas9praktikum.jtnim.setText(nim);
                viewtugas9praktikum.jtnama.setText(nama);
                viewtugas9praktikum.jtalamat.setText(alamat);
            }
        }
        );
    }

}

