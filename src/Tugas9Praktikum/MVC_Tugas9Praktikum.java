/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas9Praktikum;

/**
 *
 * @author DELL
 */
public class MVC_Tugas9Praktikum {
    ViewTugas9Praktikum vt = new ViewTugas9Praktikum ();
    ModelTugas9Praktikum mt = new ModelTugas9Praktikum();
    ControllerTugas9Praktikum ct = new ControllerTugas9Praktikum(vt, mt);
}
